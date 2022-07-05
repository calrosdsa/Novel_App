package com.example.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.local.entities.NovelImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NovelImageDao:EntityDao<NovelImageEntity>() {
    @Query("DELETE FROM novel_images WHERE novel_id = :showId")
    abstract suspend fun deleteForShowId(showId: Long)

    @Query("SELECT COUNT(*) FROM novel_images WHERE novel_id = :showId")
    abstract suspend fun imageCountForShowId(showId: Long): Int

    @Query("SELECT * FROM novel_images WHERE novel_id = :showId")
    abstract fun getImagesForShowId(showId: Long): Flow<NovelImageEntity>

    @Query("DELETE FROM novel_images")
    abstract suspend fun deleteAll()
//
//    @Transaction
//    open suspend fun saveImages(showId: Long, images: NovelImageEntity) {
//        deleteForShowId(showId)
//        insertOrUpdate(images)
//    }

//    @Transaction
//    open suspend fun saveImagesIfEmpty(showId: Long, images:NovelImageEntity) {
//        if (imageCountForShowId(showId) <= 0) {
//            insertAll(images)
//        }
  //  }
}