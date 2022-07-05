package com.example.data.dto.user

data class User(
    val email: String,
    val first_name: String,
    val last_name: String,
    val pk: Int,
    val username: String
)

data class LoginRequest(
    val email: String,
    val password: String
)


data class SignUpRequest(
    val username: String,
    val email: String,
    val password1: String,
    val password2:String
)