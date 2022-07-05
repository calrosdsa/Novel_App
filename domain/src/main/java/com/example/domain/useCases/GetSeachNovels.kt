package com.example.domain.useCases

import com.example.data.dto.searchNovel.ResultSearch
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSearchNovels @Inject constructor(
    private val novelRepository: NovelRepository
) {
    operator  fun invoke ():Flow<Resource<List<ResultSearch>>> = flow {
        try {
            emit(Resource.Loading())
            val searchResults = novelRepository.searchNovel()
            emit(Resource.Success(data = searchResults))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unnexpected error ocurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server"))
        }
    }
}