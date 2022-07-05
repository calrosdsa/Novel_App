package com.example.data.repository

import com.example.data.NovelDatabaseDao
import com.example.data.local.NovelDatabase
import com.example.data.local.daos.HistoryDao
import com.example.data.local.entities.HistorySearchEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NovelRepositoryDbImpl @Inject constructor(
    private val historyDao: HistoryDao
):NovelRepositoryDb {
    override fun getAllSearchHistories(): Flow<List<HistorySearchEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insetHistorySearch(historySearchEntity: HistorySearchEntity) {
        return historyDao.insertHistorySearch(historySearchEntity)
    }

    override suspend fun deleteAllSearch(allSearch: List<HistorySearchEntity>) {
        return historyDao.deleteAll()
    }

}