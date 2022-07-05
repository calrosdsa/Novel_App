package com.example.domain.useCases

import com.example.data.dto.library.BookMarkDto
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBookMark @Inject constructor(
    private val repository: NovelRepository
) {
    operator fun invoke(token:String,options:Int,ordering:String): Flow<Resource<BookMarkDto>> = flow {
        try {
            emit(Resource.Loading<BookMarkDto>())
            val library = repository.getLibrary(token,options, ordering)
            emit(Resource.Success<BookMarkDto>(library))
        }catch (e: HttpException) {
            emit(Resource.Error<BookMarkDto>(message = e.localizedMessage?: "An unnexpected error ocurred"))
            }catch (e: IOException){
                emit(Resource.Error<BookMarkDto>("Couldnt reach to server"))
            }
    }
}