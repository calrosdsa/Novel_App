package com.example.signup

import androidx.annotation.StringRes
import com.example.data.dto.user.LoginResponse
import com.example.data.dto.user.SignUpResponse

data class SignUpState (
    val response: SignUpResponse? = null,
    val successLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    @StringRes val errorEmail:Int?  = null,
    @StringRes val errorPassword:Int? = null,
    val username: String = "",
    val email: String = "",
    val password1: String = "",
    val password2: String = "",
    @StringRes val errorMessage: Int? = null,
    val error :String = ""
        )