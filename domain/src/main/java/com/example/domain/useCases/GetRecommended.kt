package com.example.domain.useCases

import com.example.data.dto.recommended.Recommended
import com.example.data.repository.NovelRepository
import com.example.domain.resources.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecommended @Inject constructor(
    private val novelRepository: NovelRepository
) {
    operator fun invoke (): Flow<Resource<Recommended>> = flow {
        try {

        emit(Resource.Loading<Recommended>())
        val recommended = novelRepository.getRecommended()
        emit(Resource.Success<Recommended>(data = recommended))

        }catch (e:HttpException){
            emit(Resource.Error<Recommended>(message = e.localizedMessage?: "An unnexpected error ocurred"))
        }catch (e:IOException){
            emit(Resource.Error<Recommended>(message = " Couldn't reach the server"))
        }
    }
}