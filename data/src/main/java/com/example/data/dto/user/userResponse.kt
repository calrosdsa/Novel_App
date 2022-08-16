package com.example.data.dto.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName




data class LoginResponse(
    var key: String,
    var user: UserX,
    val email: List<String>,
    val username: List<String>
)

data class SignUpResponse(
    var key: String,
    var user: UserX,
//    val email: List<String>,
//    val username: List<String>
)

data class ErrorSingResponse(
    @Expose
    var email: List<String>?,
    @Expose
    var username: List<String>?
)
