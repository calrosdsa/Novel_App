package com.example.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.local.entities.ChapterEntity
import com.example.data.resultentities.ChapterAndNovelImage
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChapterDao {
    @Transaction
    @Query("SELECT * FROM novel_images")
    abstract fun getAllChapters():Flow<List<ChapterAndNovelImage>>

    @Transaction
    @Query("SELECT * FROM novel_images WHERE id = :id")
    abstract fun getAllChaptersById(id:Long):Flow<ChapterAndNovelImage>

    @Query("SELECT * FROM chapter_novel WHERE slug = :slug")
    abstract fun getChapterBySlug(slug:String):Flow<ChapterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertChapters(chapters:List<ChapterEntity>)

    @Query("DELETE FROM chapter_novel WHERE id in (:ids)")
    abstract suspend fun deleteChapters(ids:List<Int>)

    @Query("DELETE FROM novel_images WHERE id = :id")
    abstract suspend fun deleteImage(id:Long)
}

