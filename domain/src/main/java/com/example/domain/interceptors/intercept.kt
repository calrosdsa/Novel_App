package com.example.domain.interceptors

import com.example.domain.UserAuth
import kotlinx.coroutines.*
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

class TokenInterceptor @Inject constructor (
    @Named("Token") private val token:String,
    private val auth: UserAuth
    ):Interceptor {
    private val tokenValue:String = auth.tokenValue.token


    override fun intercept(chain: Interceptor.Chain): Response {
        return if(tokenValue.isNotBlank()){
            val request = chain.request().newBuilder()
                .header("Authorization", "token $tokenValue")
                .build()
            chain.proceed(request)
        } else {
            val request = chain.request().newBuilder()
                .build()
            chain.proceed(request)
        }
    }
}