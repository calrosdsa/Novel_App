package com.example.signup

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.data.repository.NovelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: NovelRepository
) :ViewModel(){

    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun singUp(username:String,email:String, password1:String,password2: String,navController: NavController) {

        val errorMessage = if(email.isBlank()) {
            R.string.error_input_empty
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            R.string.error_not_a_valid_email
        } else if (password1 != password2){
            R.string.password_not_match
        }
        else null

        errorMessage?.let {
            _state.value = state.value.copy(errorMessage = it)
            return
        }

        viewModelScope.launch {
            val response =  repository.signUpRequest(username,email, password1,password2)
            _state.value  = state.value.copy(response = response)
            _state.value = state.value.copy(displayProgressBar = true)
            delay(2000)
            _state.value = state.value.copy(displayProgressBar = false)
            _state.value = state.value.copy(successLogin = true)
            navController.navigate("main/profile"){
                popUpTo("main/home")  { inclusive = true }
            }
        }


    }


    fun hideErrorDialog() {
        _state.value = state.value.copy(
            errorMessage = null
        )
    }

}