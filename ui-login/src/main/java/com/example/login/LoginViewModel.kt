package com.example.login

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.data.repository.NovelRepository
import com.example.domain.interactors.UpdateFollowingNovels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: NovelRepository,
    private val updateFollowingNovels: UpdateFollowingNovels,
):ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun login(email:String, password:String , navController: NavController) {

        val errorMessage = if(email.isBlank() || password.isBlank()) {
            R.string.error_input_empty
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            R.string.error_not_a_valid_email
        }
        else null

        errorMessage?.let {
            _state.value = state.value.copy(errorMessage = it)
            return
        }

       viewModelScope.launch {
            val resource = repository.loginRequest(email, password)
            _state.value  = state.value.copy(user = resource.user)
            _state.value = state.value.copy(displayProgressBar = true)
            delay(2000)
            _state.value = state.value.copy(displayProgressBar = false)
            _state.value = state.value.copy(successLogin = true)

           updateFollowingNovels(
               UpdateFollowingNovels.Params(
                   resource.key
               )
           )
            navController.popBackStack()
        }


    }

    fun hideErrorDialog() {
        _state.value = state.value.copy(
            errorMessage = null
        )
    }

}