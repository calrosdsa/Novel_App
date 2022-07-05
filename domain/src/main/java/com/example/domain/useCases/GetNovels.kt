package com.example.domain.useCases

import com.example.data.dto.novels.NovelsDto
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNovels @Inject constructor(
    private val repository: NovelRepository
) {
    operator fun invoke(): Flow<Resource<NovelsDto>> = flow {
        try {
            emit(Resource.Loading<NovelsDto>())
            val NovelsDtos = repository.getNovels()
            emit(Resource.Success<NovelsDto>(NovelsDtos))
        }catch (e:HttpException) {
            emit(Resource.Error<NovelsDto>(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e:IOException){
            emit(Resource.Error<NovelsDto>("Couldnt reach to server"))
        }
    }
}