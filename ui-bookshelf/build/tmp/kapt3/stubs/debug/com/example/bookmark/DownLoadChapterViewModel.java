package com.example.bookmark;

import androidx.lifecycle.ViewModel;
import com.example.api.UiMessageManager;
import com.example.domain.observers.ObserverChapter;
import com.example.domain.observers.ObserverChapters;
import com.example.domain.util.ObservableLoadingCounter;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/bookmark/DownLoadChapterViewModel;", "Landroidx/lifecycle/ViewModel;", "observerChapter", "Lcom/example/domain/observers/ObserverChapters;", "(Lcom/example/domain/observers/ObserverChapters;)V", "loadingCounter", "Lcom/example/domain/util/ObservableLoadingCounter;", "messageManager", "Lcom/example/api/UiMessageManager;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bookmark/DownLoadChapterState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "ui-bookshelf_debug"})
public final class DownLoadChapterViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.observers.ObserverChapters observerChapter = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingCounter = null;
    private final com.example.api.UiMessageManager messageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.bookmark.DownLoadChapterState> state = null;
    
    @javax.inject.Inject()
    public DownLoadChapterViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapters observerChapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.bookmark.DownLoadChapterState> getState() {
        return null;
    }
}