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
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/data/DatabaseModuleBinds;", "", "()V", "bindNovelDatabase", "Lcom/example/data/NovelDatabaseDao;", "db", "Lcom/example/data/local/NovelDatabase;", "provideDatabaseTransactionRunner", "Lcom/example/data/DatabaseTransactionRunner;", "runner", "Lcom/example/data/RoomTransactionRunner;", "data_debug"})
@dagger.Module()
public abstract class DatabaseModuleBinds {
    
    public DatabaseModuleBinds() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.data.NovelDatabaseDao bindNovelDatabase(@org.jetbrains.annotations.NotNull()
    com.example.data.local.NovelDatabase db);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    @javax.inject.Singleton()
    public abstract com.example.data.DatabaseTransactionRunner provideDatabaseTransactionRunner(@org.jetbrains.annotations.NotNull()
    com.example.data.RoomTransactionRunner runner);
}