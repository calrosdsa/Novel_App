package com.example.domain.useCases

import com.example.data.dto.browse.BrowseDto
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GetBrowseResults @Inject constructor(
    private val  novelRepository: NovelRepository,
){
    operator fun invoke(
        ordering:String,
        status:Int?,
        category:Int?
    ):Flow<Resource<BrowseDto>> = flow {
        try {
            emit(Resource.Loading())
            val response = novelRepository.getBrowseResults(1,ordering,status,category)
            response?.let {
                emit(Resource.Success(response))
            }
        }catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage?:"An Unexpected error"))
        }catch (e:IOException){
            emit(Resource.Error(message = e.localizedMessage?:"No Internet Connexion.Reload The Page??"))
        }
    }

}