package com.example.search.pagination;

import androidx.lifecycle.ViewModel;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.domain.observers.ObserverPagedHistorySearch;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/example/search/pagination/HistorySearchViewModel;", "Landroidx/lifecycle/ViewModel;", "pagingInteractor", "Lcom/example/domain/observers/ObserverPagedHistorySearch;", "(Lcom/example/domain/observers/ObserverPagedHistorySearch;)V", "pagedList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/data/local/entities/HistorySearchEntity;", "getPagedList", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "ui-search_debug"})
public final class HistorySearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.local.entities.HistorySearchEntity>> pagedList = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.search.pagination.HistorySearchViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.paging.PagingConfig PAGING_CONFIG = null;
    
    @javax.inject.Inject()
    public HistorySearchViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverPagedHistorySearch pagingInteractor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.local.entities.HistorySearchEntity>> getPagedList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/search/pagination/HistorySearchViewModel$Companion;", "", "()V", "PAGING_CONFIG", "Landroidx/paging/PagingConfig;", "getPAGING_CONFIG", "()Landroidx/paging/PagingConfig;", "ui-search_debug"})
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