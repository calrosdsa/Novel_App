package com.example.data.store.history_novels

import android.content.Context
import android.util.Log
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.data.local.daos.HistoryNovelDao
import com.example.data.local.daos.NovelHistoryDao
import com.example.data.local.daos.NovelImageDao
import com.example.data.local.entities.HistoryNovelEntry
import com.example.data.local.entities.NovelImageEntity
import com.example.data.repository.NovelUtil
import com.example.data.repository.history_novels.HistoryNovelShowsLastRequestStore
import com.example.data.repository.history_novels.HistoryNovelsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.map
import org.threeten.bp.Duration
import javax.inject.Singleton

typealias HistoryNovelsStore = Store<Int, List<HistoryNovelEntry>>

@InstallIn(SingletonComponent::class)
@Module
internal object HistoryNovelsModule {
    @Provides
    @Singleton
    fun provideHistoryNovelModule(
        historyNovelDao: HistoryNovelDao,
        novelHistoryDao: NovelHistoryDao,
        historyNovelsDataSource: HistoryNovelsDataSource,
//        novelUtil: NovelUtil,
  //      @ApplicationContext context: Context,
        lastRequestStore: HistoryNovelShowsLastRequestStore,
    //    novelImageDao: NovelImageDao,
        ):HistoryNovelsStore = StoreBuilder.from(
        fetcher = Fetcher.of{ page:Int ->
            historyNovelsDataSource(page)
                .also {
                    Log.d("RESPONSE","ACKSA")
              //      if (page == 0) lastRequestStore.updateLastRequest()
                }
        },
        sourceOfTruth = SourceOfTruth.of(
            reader = {page:Int->
               historyNovelDao.entriesObservable(page).map {entries->
                when{
                entries.isEmpty() -> null
                lastRequestStore.isRequestExpired(Duration.ofHours(3))-> null
                    else-> entries
                }
               }
               },
            writer = {page,response->
                 historyNovelDao.withTransaction {
                     val entries =response.map{ (novel,entry)->
//                         novelImageDao.insert(
//                             NovelImageEntity(
//                                 id = novel.id,
//                                 novelId=novel.id,
//                                 image = novelUtil.getImageBitmap(context,novel.novel_cover)
//                              )
//                         )
                       entry.copy(novelId = novelHistoryDao.getIdOrSavePlaceholder(novel), page = page)
                     }
                     if(page == 1){
                       historyNovelDao.deleteAll()
                       historyNovelDao.insertAll(entries)
//                         novelHistoryDao.insertAll(novel)
//                         historyNovelDao.insertAll(entry)
                     }else{
                       historyNovelDao.updatePage(page,entries)
                  }
                 }
            },
            delete =historyNovelDao::deletePage,
            deleteAll =historyNovelDao::deleteAll
        )
    ).build()
}