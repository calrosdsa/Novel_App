package com.example.domain.useCases

import com.example.data.dto.reviews.ReviewsDto
import com.example.data.repository.NovelRepository
import kotlinx.coroutines.flow.Flow
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetReviews @Inject constructor(
    private val repository: NovelRepository
    ) {
    operator fun invoke(novelSlug:String): Flow<Resource<ReviewsDto>> = flow {
        try {
            emit(Resource.Loading<ReviewsDto>())
            val reviews = repository.getReviewsNovel(novelSlug)
            emit(Resource.Success<ReviewsDto>(reviews))
        }catch (e: HttpException) {
            emit(Resource.Error<ReviewsDto>(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e: IOException){
            emit(Resource.Error<ReviewsDto>("Couldnt reach to server"))
        }
    }
}
