package com.example.search;

import androidx.lifecycle.ViewModel;
import com.example.api.UiMessageManager;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.data.repository.NovelRepositoryDb;
import com.example.domain.interactors.UpdateSearchHistory;
import com.example.domain.observers.ObserverSearchHistory;
import com.example.domain.observers.ObserverSearchResults;
import com.example.domain.useCases.GetSearchNovels;
import com.example.domain.util.ObservableLoadingCounter;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0014\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&J\u0006\u0010(\u001a\u00020$J\b\u0010)\u001a\u00020$H\u0002J\u0006\u0010*\u001a\u00020$J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\'J\u001a\u0010-\u001a\u00020$2\b\b\u0002\u0010.\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020/J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/example/search/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "getSearchNovels", "Lcom/example/domain/useCases/GetSearchNovels;", "novelRepositoryDb", "Lcom/example/data/repository/NovelRepositoryDb;", "observerSearchHistory", "Lcom/example/domain/observers/ObserverSearchHistory;", "updateSearchHistory", "Lcom/example/domain/interactors/UpdateSearchHistory;", "observerSearchResults", "Lcom/example/domain/observers/ObserverSearchResults;", "(Lcom/example/domain/useCases/GetSearchNovels;Lcom/example/data/repository/NovelRepositoryDb;Lcom/example/domain/observers/ObserverSearchHistory;Lcom/example/domain/interactors/UpdateSearchHistory;Lcom/example/domain/observers/ObserverSearchResults;)V", "loadingState", "Lcom/example/domain/util/ObservableLoadingCounter;", "recommendedLoadingState", "<set-?>", "Lcom/example/search/SearchHistoryState;", "searchHistory", "getSearchHistory", "()Lcom/example/search/SearchHistoryState;", "setSearchHistory", "(Lcom/example/search/SearchHistoryState;)V", "searchHistory$delegate", "Landroidx/compose/runtime/MutableState;", "searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/search/SearchViewState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "deleteAll", "", "allSearch", "", "Lcom/example/data/local/entities/HistorySearchEntity;", "getSearch", "getSearchHistories", "getSearchResults", "insertSearch", "resultSearch", "refresh", "query", "", "search", "searchTerm", "ui-search_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.useCases.GetSearchNovels getSearchNovels = null;
    private final com.example.data.repository.NovelRepositoryDb novelRepositoryDb = null;
    private final com.example.domain.observers.ObserverSearchHistory observerSearchHistory = null;
    private final com.example.domain.interactors.UpdateSearchHistory updateSearchHistory = null;
    private final com.example.domain.observers.ObserverSearchResults observerSearchResults = null;
    private final com.example.api.UiMessageManager uiMessageManager = null;
    private final com.example.domain.util.ObservableLoadingCounter recommendedLoadingState = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchHistory$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.search.SearchViewState> state = null;
    
    @javax.inject.Inject()
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetSearchNovels getSearchNovels, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepositoryDb novelRepositoryDb, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverSearchHistory observerSearchHistory, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateSearchHistory updateSearchHistory, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverSearchResults observerSearchResults) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.search.SearchHistoryState getSearchHistory() {
        return null;
    }
    
    public final void setSearchHistory(@org.jetbrains.annotations.NotNull()
    com.example.search.SearchHistoryState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.search.SearchViewState> getState() {
        return null;
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String searchTerm) {
    }
    
    public final void getSearch() {
    }
    
    public final void refresh(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean refresh) {
    }
    
    public final void insertSearch(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistorySearchEntity resultSearch) {
    }
    
    private final void getSearchHistories() {
    }
    
    public final void deleteAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.HistorySearchEntity> allSearch) {
    }
    
    public final void getSearchResults() {
    }
}