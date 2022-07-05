package com.example.domain.useCases

import com.example.data.dto.novel.NovelDetailDto
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNovelDetail @Inject constructor(
      private val repository: NovelRepository
) {
    operator fun invoke(novelSlug:String): Flow<Resource<NovelDetailDto>> = flow {
        try {
            emit(Resource.Loading())
            val novelDetailDto = repository.getNovelBySlug(novelSlug)
            emit(Resource.Success(novelDetailDto))
        }catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldnt reach to server"))
        }
    }
}