package com.example.data.local.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.local.entities.HistoryNovelEntry
import com.example.data.resultentities.HistoryEntryWithNovels
import kotlinx.coroutines.flow.Flow
@Dao
abstract class HistoryNovelDao : PaginatedNovelsEntryDao<HistoryNovelEntry, HistoryEntryWithNovels>() {
    @Transaction
    @Query("SELECT * FROM history_entries WHERE page = :page ORDER BY page_order")
    abstract fun entriesObservable(page: Int): Flow<List<HistoryNovelEntry>>

    @Transaction
    @Query("SELECT * FROM history_entries ORDER BY page, page_order LIMIT :count OFFSET :offset")
    abstract fun entriesObservable(count: Int, offset: Int): Flow<List<HistoryEntryWithNovels>>

    @Transaction
//    @Query("SELECT * FROM history_entries ORDER BY page, page_order")
    @Query("SELECT * FROM history_entries ORDER BY page ASC ")
    abstract fun entriesPagingSource(): PagingSource<Int, HistoryEntryWithNovels>

    @Query("DELETE FROM history_entries WHERE page = :page")
    abstract override suspend fun deletePage(page: Int)

    @Query("DELETE FROM history_entries")
    abstract override suspend fun deleteAll()

    @Query("SELECT MAX(page) from history_entries")
    abstract override suspend fun getLastPage(): Int?
}