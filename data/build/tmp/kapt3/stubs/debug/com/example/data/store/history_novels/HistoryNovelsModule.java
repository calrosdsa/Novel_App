package com.example.data.store.history_novels;

import android.content.Context;
import android.util.Log;
import com.dropbox.android.external.store4.Fetcher;
import com.dropbox.android.external.store4.SourceOfTruth;
import com.dropbox.android.external.store4.Store;
import com.dropbox.android.external.store4.StoreBuilder;
import com.example.data.local.daos.HistoryNovelDao;
import com.example.data.local.daos.NovelHistoryDao;
import com.example.data.local.daos.NovelImageDao;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.repository.NovelUtil;
import com.example.data.repository.history_novels.HistoryNovelShowsLastRequestStore;
import com.example.data.repository.history_novels.HistoryNovelsDataSource;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import org.threeten.bp.Duration;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/example/data/store/history_novels/HistoryNovelsModule;", "", "()V", "provideHistoryNovelModule", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/HistoryNovelEntry;", "Lcom/example/data/store/history_novels/HistoryNovelsStore;", "historyNovelDao", "Lcom/example/data/local/daos/HistoryNovelDao;", "novelHistoryDao", "Lcom/example/data/local/daos/NovelHistoryDao;", "historyNovelsDataSource", "Lcom/example/data/repository/history_novels/HistoryNovelsDataSource;", "lastRequestStore", "Lcom/example/data/repository/history_novels/HistoryNovelShowsLastRequestStore;", "data_debug"})
@dagger.Module()
public final class HistoryNovelsModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.store.history_novels.HistoryNovelsModule INSTANCE = null;
    
    private HistoryNovelsModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.dropbox.android.external.store4.Store<java.lang.Integer, java.util.List<com.example.data.local.entities.HistoryNovelEntry>> provideHistoryNovelModule(@org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.HistoryNovelDao historyNovelDao, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.NovelHistoryDao novelHistoryDao, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.history_novels.HistoryNovelsDataSource historyNovelsDataSource, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.history_novels.HistoryNovelShowsLastRequestStore lastRequestStore) {
        return null;
    }
}