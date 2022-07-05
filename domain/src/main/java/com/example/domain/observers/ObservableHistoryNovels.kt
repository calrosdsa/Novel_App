package com.example.domain.observers

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.local.daos.HistoryNovelDao
import com.example.data.resultentities.HistoryEntryWithNovels
import com.example.domain.PaginatedEntryRemoteMediator
import com.example.domain.PagingInteractor
import com.example.domain.interactors.UpdatedHistoryNovels
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@OptIn(ExperimentalPagingApi::class)

@OptIn(ExperimentalPagingApi::class)
class ObservableHistoryNovels @Inject constructor(
    private val updatedHistoryNovels: UpdatedHistoryNovels,
    private val historyNovelDao: HistoryNovelDao,
): PagingInteractor<ObservableHistoryNovels.Params, HistoryEntryWithNovels>(){

    override fun createObservable(params: Params): Flow<PagingData<HistoryEntryWithNovels>> {
        return Pager(
            config = PagingConfig(
                pageSize =20,
                initialLoadSize = 5,
                prefetchDistance = 3,
            ),
            remoteMediator = PaginatedEntryRemoteMediator (fetch = { page ->
                updatedHistoryNovels.executeSync(
                    UpdatedHistoryNovels.Params(page = page, forceRefresh = true)
                )
            }),
            pagingSourceFactory = historyNovelDao::entriesPagingSource
        ).flow
    }

    data class Params(
        override val pagingConfig: PagingConfig,
    ) : Parameters<HistoryEntryWithNovels>
}