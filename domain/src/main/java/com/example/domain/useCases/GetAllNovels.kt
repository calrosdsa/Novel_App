package com.example.domain.useCases

import com.example.data.dto.allNovels.AllNovelsDto
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllNovels @Inject constructor(
    private val novelRepository: NovelRepository
){
    operator fun invoke (): Flow<Resource<AllNovelsDto>> = flow{
         try {
             emit(Resource.Loading<AllNovelsDto>())
             val allNovels = novelRepository.getSearchNovels()
             emit(Resource.Success<AllNovelsDto>(allNovels))
         }catch(e:HttpException) {
             emit(Resource.Error<AllNovelsDto>(message = e.localizedMessage ?: "An unnexpected error ocurred"))
         }catch (e: IOException){
        emit(Resource.Error<AllNovelsDto>("Couldnt reach to server"))
    }

    }
}