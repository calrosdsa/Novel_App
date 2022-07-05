package com.example.data.store.history_search;

import android.util.Log;
import com.dropbox.android.external.store4.Fetcher;
import com.dropbox.android.external.store4.SourceOfTruth;
import com.dropbox.android.external.store4.Store;
import com.dropbox.android.external.store4.StoreBuilder;
import com.example.data.local.daos.HistoryDao;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.data.remote.ApiService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/example/data/store/history_search/SearchModule;", "", "()V", "provideSearchModule", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/HistorySearchEntity;", "Lcom/example/data/store/history_search/SearchResultStore;", "apiService", "Lcom/example/data/remote/ApiService;", "historyDao", "Lcom/example/data/local/daos/HistoryDao;", "data_debug"})
@dagger.Module()
public final class SearchModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.store.history_search.SearchModule INSTANCE = null;
    
    private SearchModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.dropbox.android.external.store4.Store<java.lang.String, java.util.List<com.example.data.local.entities.HistorySearchEntity>> provideSearchModule(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.HistoryDao historyDao) {
        return null;
    }
}