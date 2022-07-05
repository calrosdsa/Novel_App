package com.example.login

import androidx.annotation.StringRes
import com.example.data.dto.user.UserX

data class LoginState(
    val user: UserX?= null,
    val email: String = "",
    val password: String = "",
    val successLogin: Boolean = false,
    val error:String = "",
    val displayProgressBar: Boolean = false,
    @StringRes val errorMessage: Int? = null,
)
