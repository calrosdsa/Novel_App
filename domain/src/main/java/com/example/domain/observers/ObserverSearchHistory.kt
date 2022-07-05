package com.example.domain.observers

import com.example.data.local.daos.HistoryDao
import com.example.data.local.entities.HistorySearchEntity
import com.example.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverSearchHistory @Inject constructor(
    private val historyDao: HistoryDao
) : SubjectInteractor<ObserverSearchHistory.Params, List<HistorySearchEntity>>() {


    override fun createObservable(params: Params): Flow<List<HistorySearchEntity>> {
        return historyDao.getHistorySearch()
    }
    data class Params(val count: Int = 20)

}