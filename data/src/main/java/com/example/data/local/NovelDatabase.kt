package com.example.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.util.Converters
import com.example.data.NovelDatabaseDao
import com.example.data.local.entities.*

@Database(
    entities = [
        HistorySearchEntity::class,
        FollowingEntity::class,
        CategoryEntity::class,
        LastRequest::class,
        HistoryNovelEntry::class,
        HistoryNovelEntity::class,
        NovelImageEntity::class,
        ChapterEntity::class
               ],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
    ],
)
@TypeConverters(Converters::class)
abstract class NovelDatabase:RoomDatabase(), NovelDatabaseDao{
    companion object {
        const val DATABASE_NAME = "novel.db"
    }
}