package com.example.domain.useCases

import com.example.data.dto.profile.ProfileDto
import com.example.data.repository.NovelRepository
import kotlinx.coroutines.flow.Flow
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetProfile @Inject constructor(
    private val repository: NovelRepository
    ) {
    operator fun invoke(token:String): Flow<Resource<ProfileDto>> = flow {
        try {
            emit(Resource.Loading<ProfileDto>())
            val profile = repository.getProfile(
               token
            )
            emit(Resource.Success<ProfileDto>(profile))
        }catch (e: HttpException) {
            emit(Resource.Error<ProfileDto>(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error<ProfileDto>("Couldn't reach to server"))
        }
    }
}
