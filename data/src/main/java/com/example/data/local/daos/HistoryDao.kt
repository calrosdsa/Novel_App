package com.example.data.local.daos

import androidx.paging.PagingSource
import androidx.room.*
import com.example.data.local.entities.HistorySearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_search ORDER BY timestamp DESC")
     fun getAllHistories(): PagingSource<Int ,HistorySearchEntity>

    @Query("SELECT * FROM history_search ")
    fun getAllNovelsSearchs():Flow<List<HistorySearchEntity>>

     @Query("SELECT * FROM history_search WHERE isInHistory= 1 ORDER BY timestamp DESC LIMIT 20 ")
     fun getHistorySearch():Flow<List<HistorySearchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertHistorySearch(historySearch:HistorySearchEntity)

    @Query("DELETE FROM history_search")
     suspend fun deleteAll()

    @Query("DELETE FROM history_search WHERE label = :label")
     suspend fun deletePage(label: String)



    @Query(
        """
            SELECT * 
            FROM history_search
            WHERE LOWER(title) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) == title  LIMIT 10
        """
    )
    suspend fun search(query: String): List<HistorySearchEntity>


}