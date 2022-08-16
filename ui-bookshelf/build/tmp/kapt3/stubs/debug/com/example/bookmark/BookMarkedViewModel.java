package com.example.bookmark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.api.UiMessageManager;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.repository.NovelRepository;
import com.example.domain.StateRefresh;
import com.example.domain.UserAuth;
import com.example.domain.interactors.AddOrRemoveNovelFromBookMark;
import com.example.domain.interactors.UpdateFollowingNovels;
import com.example.domain.interactors.UpdatedOptionsBookMark;
import com.example.domain.observers.ObserverFollowings;
import com.example.domain.util.NovelOrder;
import com.example.domain.util.ObservableLoadingCounter;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0012\u0010\'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0016\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001eJ\u0016\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u0011J\u000e\u00103\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0017J\b\u00106\u001a\u00020$H\u0002J\u0006\u00107\u001a\u00020$R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/example/bookmark/BookMarkedViewModel;", "Landroidx/lifecycle/ViewModel;", "observerFollowings", "Lcom/example/domain/observers/ObserverFollowings;", "updateFollowingNovels", "Lcom/example/domain/interactors/UpdateFollowingNovels;", "updatedOptionsBookMark", "Lcom/example/domain/interactors/UpdatedOptionsBookMark;", "addOrRemoveNovelFromBookMark", "Lcom/example/domain/interactors/AddOrRemoveNovelFromBookMark;", "userAuth", "Lcom/example/domain/UserAuth;", "(Lcom/example/domain/observers/ObserverFollowings;Lcom/example/domain/interactors/UpdateFollowingNovels;Lcom/example/domain/interactors/UpdatedOptionsBookMark;Lcom/example/domain/interactors/AddOrRemoveNovelFromBookMark;Lcom/example/domain/UserAuth;)V", "currentItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/data/local/entities/FollowingEntity;", "filterType", "Lcom/example/bookmark/FilterOption;", "loadingState", "Lcom/example/domain/util/ObservableLoadingCounter;", "option", "", "ordering", "Lcom/example/domain/util/NovelOrder;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bookmark/FollowingState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "token", "", "getToken", "()Ljava/lang/String;", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "clearMessage", "", "id", "", "getFollowings", "refresh", "", "onDispose", "removeNovel", "novelId", "title", "setAction", "setCurrentItem", "item", "setFIlter", "optionFilter", "setOption", "setOrdering", "novelOrder", "updateDataSource", "updateLibrary", "ui-bookshelf_debug"})
public final class BookMarkedViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.observers.ObserverFollowings observerFollowings = null;
    private final com.example.domain.interactors.UpdateFollowingNovels updateFollowingNovels = null;
    private final com.example.domain.interactors.UpdatedOptionsBookMark updatedOptionsBookMark = null;
    private final com.example.domain.interactors.AddOrRemoveNovelFromBookMark addOrRemoveNovelFromBookMark = null;
    private final com.example.domain.UserAuth userAuth = null;
    private final com.example.api.UiMessageManager uiMessageManager = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> option = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.domain.util.NovelOrder> ordering = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.bookmark.FilterOption> filterType = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.data.local.entities.FollowingEntity> currentItem = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.bookmark.FollowingState> state = null;
    
    @javax.inject.Inject()
    public BookMarkedViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverFollowings observerFollowings, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateFollowingNovels updateFollowingNovels, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdatedOptionsBookMark updatedOptionsBookMark, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.AddOrRemoveNovelFromBookMark addOrRemoveNovelFromBookMark, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth userAuth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.bookmark.FollowingState> getState() {
        return null;
    }
    
    public final void updateLibrary() {
    }
    
    public final void onDispose() {
    }
    
    private final void updateDataSource() {
    }
    
    public final void setCurrentItem(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.FollowingEntity item) {
    }
    
    public final void removeNovel(int novelId, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void setAction(int novelId, int option) {
    }
    
    public final void setOption(int option) {
    }
    
    public final void setOrdering(@org.jetbrains.annotations.NotNull()
    com.example.domain.util.NovelOrder novelOrder) {
    }
    
    private final void getFollowings(boolean refresh) {
    }
    
    public final void refresh() {
    }
    
    public final void setFIlter(@org.jetbrains.annotations.NotNull()
    com.example.bookmark.FilterOption optionFilter) {
    }
    
    public final void clearMessage(long id) {
    }
}