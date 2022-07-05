package com.example.data.local.daos

import androidx.room.*
import com.example.data.local.entities.LastRequest
import com.example.data.local.entities.Request

@Dao
abstract class LastRequestDao : EntityDao<LastRequest>() {
    @Query("SELECT * FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract suspend fun lastRequest(request: Request, entityId: Long): LastRequest?

    @Query("SELECT COUNT(*) FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract suspend fun requestCount(request: Request, entityId: Long): Int

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: LastRequest):Long
            //Long
}