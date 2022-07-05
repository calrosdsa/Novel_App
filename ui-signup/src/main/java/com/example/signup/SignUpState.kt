package com.example.signup

import androidx.annotation.StringRes
import com.example.data.dto.user.LoginResponse

data class SignUpState (
    val response: LoginResponse? = null,
    val successLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    val username: String = "",
    val email: String = "",
    val password1: String = "",
    val password2: String = "",
    @StringRes val errorMessage: Int? = null,
        )