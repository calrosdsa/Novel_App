package com.example.domain.observers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.local.daos.HistoryDao
import com.example.data.local.entities.HistorySearchEntity
import com.example.domain.PagingInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverPagedHistorySearch @Inject constructor(
    private val historyDao: HistoryDao
) : PagingInteractor<ObserverPagedHistorySearch.Params, HistorySearchEntity>() {


    override fun createObservable(params: Params): Flow<PagingData<HistorySearchEntity>> {
        return Pager(
             config =params.pagingConfig,
             pagingSourceFactory = historyDao::getAllHistories
        ).flow
    }

    data class Params(
        override val pagingConfig: PagingConfig,
    ) : PagingInteractor.Parameters<HistorySearchEntity>

}