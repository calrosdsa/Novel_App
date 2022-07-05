package com.example.domain.interactors

import com.dropbox.android.external.store4.fresh
import com.example.data.fetch
import com.example.data.local.daos.HistoryNovelDao
import com.example.data.store.history_novels.HistoryNovelsStore
import com.example.domain.Interactor
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdatedHistoryNovels @Inject constructor(
    private val historyNovelsStore: HistoryNovelsStore,
    private val dispatchers: AppCoroutineDispatchers,
    private val historyNovelDao: HistoryNovelDao
): Interactor<UpdatedHistoryNovels.Params>() {

    override suspend fun doWork(params: Params) {
        val page = params.page
//            when {
//            params.page >= 1 -> {
//                val lastPage = historyNovelDao.getLastPage()
//                if (lastPage != null) lastPage + 1 else 1
//            }
//            else -> 1
//        }

         withContext(dispatchers.io){
              historyNovelsStore.fetch(page,forceFresh = true)
         }
    }

    override suspend fun deleteAll(params: Params) {
        TODO("Not yet implemented")
    }
    data class Params(
        val page:Int,
        val forceRefresh:Boolean = true
    )
}