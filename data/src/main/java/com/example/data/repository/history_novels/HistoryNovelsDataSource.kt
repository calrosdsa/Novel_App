package com.example.data.repository.history_novels

import android.util.Log
import com.example.data.dto.history.HistoryDtoItem
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.local.entities.HistoryNovelEntry
import com.example.data.mapper.HistoryDtoToHistoryEntity
import com.example.data.remote.ApiService
import com.example.data.util.IndexedMapper
import com.example.data.util.bodyOrThrow
//import com.example.data.util.bodyOrThrow
import com.example.data.util.pairMapperOf
import com.example.data.util.withRetry
import com.example.domain.UserAuth
import retrofit2.awaitResponse
import javax.inject.Inject

class HistoryNovelsDataSource @Inject constructor(
    private val apiService: ApiService,
    historyDtoToHistoryEntity: HistoryDtoToHistoryEntity,
    private val auth: UserAuth
){
    private val token:String
    get() = auth.tokenValue.token
    private val entryMapper = IndexedMapper<HistoryDtoItem, HistoryNovelEntry> { index, _ ->
        HistoryNovelEntry(novelId = 0, pageOrder = index, page = 0)
    }

    private val resultsMapper = pairMapperOf(historyDtoToHistoryEntity, entryMapper)

    suspend operator fun invoke(
        page:Int,
    ): List<Pair<HistoryNovelEntity, HistoryNovelEntry>> = withRetry {
                     Log.d("RESPONSE","$page")
           apiService.getHistoryNovels(token,page)
               .awaitResponse()
               .let{
                     resultsMapper.invoke(it.bodyOrThrow())
               }
    }
}