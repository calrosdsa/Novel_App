package com.example.data;

import android.content.Context;
import androidx.room.Room;
import com.example.data.local.NovelDatabase;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0015H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/example/data/DatabaseDaoModule;", "", "()V", "provideCategories", "Lcom/example/data/local/daos/CategoryDao;", "db", "Lcom/example/data/local/NovelDatabase;", "provideChapterNovelDao", "Lcom/example/data/local/daos/ChapterDao;", "provideHistoryNovelDao", "Lcom/example/data/local/daos/HistoryNovelDao;", "provideLastRequestsDao", "Lcom/example/data/local/daos/LastRequestDao;", "provideNovelFollowing", "Lcom/example/data/local/daos/FollowingDao;", "provideNovelHistoryDao", "Lcom/example/data/local/daos/NovelHistoryDao;", "provideNovelImageDao", "Lcom/example/data/local/daos/NovelImageDao;", "provideNovelShowHistorySearch", "Lcom/example/data/local/daos/HistoryDao;", "Lcom/example/data/NovelDatabaseDao;", "data_debug"})
@dagger.Module()
public final class DatabaseDaoModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.DatabaseDaoModule INSTANCE = null;
    
    private DatabaseDaoModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.HistoryDao provideNovelShowHistorySearch(@org.jetbrains.annotations.NotNull()
    com.example.data.NovelDatabaseDao db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.FollowingDao provideNovelFollowing(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.CategoryDao provideCategories(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.HistoryNovelDao provideHistoryNovelDao(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.LastRequestDao provideLastRequestsDao(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.NovelHistoryDao provideNovelHistoryDao(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.NovelImageDao provideNovelImageDao(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.data.local.daos.ChapterDao provideChapterNovelDao(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db) {
        return null;
    }
}