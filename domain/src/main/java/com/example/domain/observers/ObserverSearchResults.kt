package com.example.domain.observers

import com.example.data.local.daos.HistoryDao
import com.example.data.local.entities.HistorySearchEntity
import com.example.domain.SuspendingWorkInteractor
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ObserverSearchResults @Inject constructor(
    private val historyDao: HistoryDao,
    private val dispatchers: AppCoroutineDispatchers
):SuspendingWorkInteractor<ObserverSearchResults.Params, List<HistorySearchEntity>>() {

    override suspend fun doWork(params: Params): List<HistorySearchEntity> = withContext(dispatchers.io){
          historyDao.search(params.query)
    }

    data class Params(val query: String)
}