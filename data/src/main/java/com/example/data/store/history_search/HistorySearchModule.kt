package com.example.data.store.history_search

import android.util.Log
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.data.local.daos.HistoryDao
import com.example.data.local.entities.HistorySearchEntity
import com.example.data.mapper.toHistorySearchEntity
import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

typealias   SearchResultStore = Store<String,List<HistorySearchEntity>>

@InstallIn(SingletonComponent::class)
@Module
internal object SearchModule {
    @Provides
    @Singleton
    fun provideSearchModule(
        apiService: ApiService,
        historyDao: HistoryDao
    ): SearchResultStore = StoreBuilder.from(
        fetcher = Fetcher.of {
            apiService.searchNovel()
        },
        sourceOfTruth = SourceOfTruth.of(
            reader ={historyDao.getAllNovelsSearchs()
                .map { entries ->
                when {
                    // Store only treats null as 'no value', so convert to null
                    entries.isEmpty() -> null
                    // If the request is expired, our data is stale
                    //         lastRequestStore.isRequestExpired(Duration.ofHours(3)) -> null
                    // Otherwise, our data is fresh and valid
                    else -> entries
                }
            }
            },
            writer = { _,response->
                   response.map {entry->
                    //       entry.copy(showId = showDao.getIdOrSavePlaceholder(show), page = page)
                    historyDao.insertHistorySearch(entry.toHistorySearchEntity())
                }
            },
            delete =  historyDao::deletePage,
            deleteAll = historyDao::deleteAll,
        )
    ).build()
}



