package com.example.domain.useCases

import com.example.data.dto.user.LoginResponse
import com.example.data.repository.NovelRepository
import com.example.domain.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class AuthImpl @Inject constructor(
    private val repository: NovelRepository
) {
    operator fun invoke(email:String,password:String): Flow<AuthResult<LoginResponse>> = flow {
        try {
            //emit(AuthResult.Authorized<LoginResponse>())
            val response = repository.loginRequest(
                email ,
                password
                //    token
            )
            emit(AuthResult.Authorized<LoginResponse>(response))
        }catch (e: HttpException) {
            emit(AuthResult.UnAuthorized<LoginResponse>(error = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e: IOException){
            emit(AuthResult.UnKnowError<LoginResponse>(error = "Couldnt reach to server"))
        }
    }
}