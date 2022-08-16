package com.example.login

import android.util.Patterns
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.data.dto.user.ErrorSingResponse
import com.example.data.repository.NovelRepository
import com.example.domain.interactors.UpdateFollowingNovels
import com.example.domain.resources.Resource
import com.example.domain.useCases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlinx.coroutines.launch
import java.io.IOException

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val updateFollowingNovels: UpdateFollowingNovels,
    private val loginUseCase: LoginUseCase
):ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun login(email:String, password:String ,
              navController: NavController
    ) {

        val errorMessage = if(email.isBlank() || password.isBlank()) {
            //R.string.error_input_empty
            "Requited Field"
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //R.string.error_not_a_valid_email
            "Required Field"
        }
        else null

        errorMessage?.let {
            _state.value = state.value.copy(error= it)
            return
        }

       viewModelScope.launch {

         loginUseCase(email,password).collect{ result->
               when(result){
                   is Resource.Loading ->  _state.value = state.value.copy(displayProgressBar = true)
                   is Resource.Success -> {
                       _state.value  = state.value.copy(successLogin = true, displayProgressBar = false, error = result.message?:"")
                       result.data?.let {
                           updateFollowingNovels(
                               UpdateFollowingNovels.Params(
                                   it.key
                               )
                           )
                       }
            navController.popBackStack()
                       }
                   is Resource.Error ->{
                       _state.value  = state.value.copy(
                           error = result.message.toString(),
                           successLogin = false,
                           displayProgressBar = false,
                       )
                   }
               }
           }
        }
    }
    fun hideErrorDialog() {
        _state.value = state.value.copy(
            errorMessage = null
        )
    }

}