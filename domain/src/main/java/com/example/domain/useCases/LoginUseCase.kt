package com.example.domain.useCases

import android.util.Log
import com.example.data.remote.ApiService
import com.example.data.repository.NovelRepository
import com.example.data.util.bodyOrThrow
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val novelRepository: NovelRepository
) {
    operator fun invoke(email:String,password:String) = flow {
    try {
        emit(Resource.Loading())
        val result = novelRepository.loginRequest(email,password).body()
        if(result == null){
            emit(Resource.Error(message = "Unable to log in with provided credentials."))
        }else{
        emit(Resource.Success(data = result))
        }
    }catch (e:HttpException){
        emit(Resource.Error(message = e.localizedMessage?: "An expected error"))
    }catch (e:IOException){
        emit(Resource.Error(message = e.localizedMessage?: "An expected error"))
    }

    }
}