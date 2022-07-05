package com.example.domain.useCases

import android.util.Log
import com.example.data.dto.chapters.NovelChaptersDto
import com.example.data.repository.NovelRepository
import kotlinx.coroutines.flow.Flow
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetChapters @Inject constructor(
    private val repository: NovelRepository
    ) {
    operator fun invoke(novelSlug:String): Flow<Resource<NovelChaptersDto>> = flow {
        Log.d("SLUGGG",novelSlug)
        try {
            emit(Resource.Loading<NovelChaptersDto>())
            val chapters = repository.getNovelsChapters(novelSlug)
            emit(Resource.Success<NovelChaptersDto>(chapters))
        }catch (e: HttpException) {
            emit(Resource.Error<NovelChaptersDto>(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error<NovelChaptersDto>("Couldnt reach to server"))
        }
    }
}
