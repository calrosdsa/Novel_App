package com.example.domain



sealed class AuthResult<T>(val data:T? = null,val error: String? = null){
    class Authorized<T>(data: T) : AuthResult<T>(data)
    class UnAuthorized<T>(data: T? = null,error: String): AuthResult<T>(data, error)
    class UnKnowError<T>(data: T? = null,error: String): AuthResult<T>(data, error)
}
