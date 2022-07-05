package com.example.discover;

import android.util.Log;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.api.UiMessageManager;
import com.example.data.dto.browse.BrowseDto;
import com.example.data.dto.browse.Novel;
import com.example.data.remote.ApiService;
import com.example.data.util.Constants;
import com.example.domain.interactors.UpdateCategory;
import com.example.domain.observers.ObserverCategory;
import com.example.domain.pagination.NovelBrowsePagination;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import com.example.domain.useCases.GetBrowseResults;
import com.example.domain.util.ObservableLoadingCounter;
import kotlinx.coroutines.flow.*;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\b\u0010\'\u001a\u00020$H\u0002J\u000e\u0010(\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020)J\u000e\u0010*\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010+\u001a\u00020$2\u0006\u0010 \u001a\u00020)J\b\u0010,\u001a\u00020$H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/discover/DiscoverViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "updateCategory", "Lcom/example/domain/interactors/UpdateCategory;", "apiService", "Lcom/example/data/remote/ApiService;", "observerCategory", "Lcom/example/domain/observers/ObserverCategory;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/example/domain/interactors/UpdateCategory;Lcom/example/data/remote/ApiService;Lcom/example/domain/observers/ObserverCategory;)V", "category", "", "filter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/discover/FilterState;", "getFilter", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadingState", "Lcom/example/domain/util/ObservableLoadingCounter;", "ordering", "pagingList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/data/dto/browse/Novel;", "getPagingList", "()Lkotlinx/coroutines/flow/Flow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/discover/DiscoverState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "status", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "clearMessage", "", "id", "", "getCategories", "setCategory", "", "setOrdering", "setStatus", "updatePagingQuery", "ui-discover_debug"})
public final class DiscoverViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.interactors.UpdateCategory updateCategory = null;
    private final com.example.data.remote.ApiService apiService = null;
    private final java.lang.String category = null;
    private final java.lang.String status = null;
    private final java.lang.String ordering = null;
    private final com.example.api.UiMessageManager uiMessageManager = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.discover.FilterState> filter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.browse.Novel>> pagingList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.discover.DiscoverState> state = null;
    
    @javax.inject.Inject()
    public DiscoverViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateCategory updateCategory, @org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverCategory observerCategory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.discover.FilterState> getFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.data.dto.browse.Novel>> getPagingList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.discover.DiscoverState> getState() {
        return null;
    }
    
    public final void setStatus(int status) {
    }
    
    public final void setOrdering(@org.jetbrains.annotations.NotNull()
    java.lang.String ordering) {
    }
    
    public final void setCategory(int category) {
    }
    
    private final void updatePagingQuery() {
    }
    
    private final void getCategories() {
    }
    
    public final void clearMessage(long id) {
    }
}