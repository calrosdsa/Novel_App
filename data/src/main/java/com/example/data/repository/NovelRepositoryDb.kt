package com.example.data.repository

import com.example.data.local.entities.HistorySearchEntity
import kotlinx.coroutines.flow.Flow

interface NovelRepositoryDb {
    fun getAllSearchHistories():Flow<List<HistorySearchEntity>>
    suspend fun insetHistorySearch(historySearchEntity: HistorySearchEntity)
    suspend fun deleteAllSearch(allSearch:List<HistorySearchEntity>)
}