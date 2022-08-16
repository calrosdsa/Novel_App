package com.example.data

import android.content.Context
import androidx.room.Room
import com.example.data.local.NovelDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomDatabaseModule{

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ):NovelDatabase {
        return Room.databaseBuilder(
        context,
        NovelDatabase::class.java,
            NovelDatabase.DATABASE_NAME
        ).build()
    }

}

@InstallIn(SingletonComponent::class)
@Module
object DatabaseDaoModule {
    @Provides
    fun provideNovelShowHistorySearch(db: NovelDatabaseDao) = db.showHistorySearch()
    @Provides
    fun provideNovelFollowing(db: NovelDatabase) = db.showFollowings()
    @Provides
    fun provideCategories(db:NovelDatabase) = db.showCategories()
    @Provides
    fun provideHistoryNovelDao(db:NovelDatabase) = db.historyNovelsDao()
    @Provides
    fun provideLastRequestsDao(db:NovelDatabase) = db.lastRequestDao()
    @Provides
    fun provideNovelHistoryDao(db:NovelDatabase) = db.novelHistoryDao()
    @Provides
    fun provideNovelImageDao(db:NovelDatabase) = db.novelImageDao()
    @Provides
    fun provideChapterNovelDao(db:NovelDatabase) = db.chapterNovelDao()
}


@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindNovelDatabase(db: NovelDatabase): NovelDatabaseDao

    @Singleton
    @Binds
    abstract fun provideDatabaseTransactionRunner(runner: RoomTransactionRunner): DatabaseTransactionRunner
}