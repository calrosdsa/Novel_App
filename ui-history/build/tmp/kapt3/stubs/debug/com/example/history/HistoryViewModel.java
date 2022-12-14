package com.example.history;

import androidx.lifecycle.ViewModel;
import androidx.paging.*;
import com.example.data.dto.history.HistoryDtoItem;
import com.example.data.remote.ApiService;
import com.example.domain.UserAuth;
import com.example.domain.observers.ObservableHistoryNovels;
import com.example.domain.pagination.NovelHistoryPagination;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/example/history/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/example/data/remote/ApiService;", "auth", "Lcom/example/domain/UserAuth;", "pagingInteractor", "Lcom/example/domain/observers/ObservableHistoryNovels;", "(Lcom/example/data/remote/ApiService;Lcom/example/domain/UserAuth;Lcom/example/domain/observers/ObservableHistoryNovels;)V", "pager", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/data/dto/history/HistoryDtoItem;", "getPager", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "ui-history_debug"})
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.example.domain.UserAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.history.HistoryDtoItem>> pager = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.history.HistoryViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.paging.PagingConfig PAGING_CONFIG = null;
    
    @javax.inject.Inject()
    public HistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObservableHistoryNovels pagingInteractor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.history.HistoryDtoItem>> getPager() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/history/HistoryViewModel$Companion;", "", "()V", "PAGING_CONFIG", "Landroidx/paging/PagingConfig;", "getPAGING_CONFIG", "()Landroidx/paging/PagingConfig;", "ui-history_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.paging.PagingConfig getPAGING_CONFIG() {
            return null;
        }
    }
}