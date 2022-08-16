package com.example.chapters.indice;

import android.util.Log;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.data.local.daos.ChapterDao;
import com.example.data.local.daos.NovelImageDao;
import com.example.data.util.Constants;
import com.example.domain.observers.ObserverChapter;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ%\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/example/chapters/indice/DownloadIndiceViewModel;", "Landroidx/lifecycle/ViewModel;", "observerChapter", "Lcom/example/domain/observers/ObserverChapter;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "chapterDao", "Lcom/example/data/local/daos/ChapterDao;", "imageDao", "Lcom/example/data/local/daos/NovelImageDao;", "(Lcom/example/domain/observers/ObserverChapter;Landroidx/lifecycle/SavedStateHandle;Lcom/example/data/local/daos/ChapterDao;Lcom/example/data/local/daos/NovelImageDao;)V", "id", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/chapters/indice/ChapterDownloadState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteChapters", "", "ids", "", "", "", "(Ljava/util/List;Ljava/lang/Long;)V", "ui-chapters_debug"})
public final class DownloadIndiceViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.local.daos.ChapterDao chapterDao = null;
    private final com.example.data.local.daos.NovelImageDao imageDao = null;
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.chapters.indice.ChapterDownloadState> state = null;
    
    @javax.inject.Inject()
    public DownloadIndiceViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapter observerChapter, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.ChapterDao chapterDao, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.NovelImageDao imageDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.chapters.indice.ChapterDownloadState> getState() {
        return null;
    }
    
    public final void deleteChapters(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> ids, @org.jetbrains.annotations.Nullable()
    java.lang.Long id) {
    }
}