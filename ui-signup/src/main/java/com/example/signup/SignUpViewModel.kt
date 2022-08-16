package com.example.signup

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.dto.user.ErrorSingResponse
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: NovelRepository,
    @ApplicationContext private val context: Context
) :ViewModel(){

    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun singUp(
        username: String, email: String, password1: String, password2: String,
        //           navController: NavController
    ) {
            _state.value = SignUpState()

         if(email.isBlank()) {
            _state.value = state.value.copy(
                errorMessage =  R.string.error_input_empty,
                errorEmail = R.string.error_input_empty,
                errorPassword = R.string.error_input_empty,
                )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _state.value = state.value.copy(errorEmail  =  R.string.error_not_a_valid_email)
        }
        if (password1 != password2){
            _state.value = state.value.copy(errorPassword =   R.string.password_not_match)
        }

        if (password1.length < 9){
            _state.value = state.value.copy(errorPassword =   R.string.password_is_too_short)
        }


        if(state.value.errorPassword !=null || state.value.errorMessage !=null || state.value.errorEmail != null){
            return
        }
        val gson = Gson()

        viewModelScope.launch {

            flow {
                try {
                    emit(Resource.Loading())
            val response =  repository.signUpRequest(username,email, password1,password2)
                   val mError = gson.fromJson(response.errorBody()?.string() , ErrorSingResponse::class.java)
                    mError.email?.get(0)?.let{
                    Toast.makeText(context, it ,Toast.LENGTH_SHORT).show()
                    }
                    mError.username?.get(0)?.let{
                        Toast.makeText(context, it ,Toast.LENGTH_SHORT).show()
                    }
                    //Toast.makeText(context, mError.email?.get(0) ?: "",Toast.LENGTH_SHORT).show()
                    emit(Resource.Success(response))
                }catch (e:HttpException){
                    emit(Resource.Error(message = e.localizedMessage?:"An unexpected error"))
                }catch (e:IOException){
                    emit(Resource.Error(message = e.localizedMessage?:"An unexpected error"))
                }
            }.collect{result->
                when(result){
                    is Resource.Loading ->  _state.value = state.value.copy(displayProgressBar = true)
                    is Resource.Success -> {
                     _state.value  = state.value.copy(successLogin = true, displayProgressBar = false)

//            navController.navigate("main/profile"){
//                popUpTo("main/home")  { inclusive = true }
//            }
                    }
                    is Resource.Error ->{
                        _state.value  = state.value.copy(
                            successLogin = false,
                            displayProgressBar = false,
                            error = result.message.toString()
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