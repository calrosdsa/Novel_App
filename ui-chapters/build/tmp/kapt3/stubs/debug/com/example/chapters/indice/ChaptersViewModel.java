package com.example.chapters.indice;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.api.UiMessageManager;
import com.example.data.dto.chapters.ChaptersDto;
import com.example.data.dto.chapters.DownLoadChapter;
import com.example.data.local.daos.ChapterDao;
import com.example.data.local.daos.NovelImageDao;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.local.entities.NovelImageEntity;
import com.example.data.remote.ApiService;
import com.example.data.remote.Ids;
import com.example.data.repository.NovelUtil;
import com.example.data.util.Constants;
import com.example.domain.observers.ObserverChapter;
import com.example.domain.resources.Resource;
import com.example.domain.util.ObservableLoadingCounter;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0013J\u000e\u0010&\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0015\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*\u00a2\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/chapters/indice/ChaptersViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/example/data/remote/ApiService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "observerChapters", "Lcom/example/domain/observers/ObserverChapter;", "novelUtil", "Lcom/example/data/repository/NovelUtil;", "context", "Landroid/content/Context;", "chapterDao", "Lcom/example/data/local/daos/ChapterDao;", "novelImageDao", "Lcom/example/data/local/daos/NovelImageDao;", "(Lcom/example/data/remote/ApiService;Landroidx/lifecycle/SavedStateHandle;Lcom/example/domain/observers/ObserverChapter;Lcom/example/data/repository/NovelUtil;Landroid/content/Context;Lcom/example/data/local/daos/ChapterDao;Lcom/example/data/local/daos/NovelImageDao;)V", "chapters", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/data/dto/chapters/DownLoadChapter;", "loadingState", "Lcom/example/domain/util/ObservableLoadingCounter;", "results", "Lcom/example/data/dto/chapters/ChaptersDto;", "slug", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/chapters/indice/ChaptersState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "getAllChapterDownload", "", "ids", "", "getAllChapters", "isDownload", "", "item", "Lcom/example/data/local/entities/ChapterEntity;", "(Lcom/example/data/local/entities/ChapterEntity;)Ljava/lang/Boolean;", "ui-chapters_debug"})
public final class ChaptersViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.example.domain.observers.ObserverChapter observerChapters = null;
    private final com.example.data.repository.NovelUtil novelUtil = null;
    private final android.content.Context context = null;
    private final com.example.data.local.daos.ChapterDao chapterDao = null;
    private final com.example.data.local.daos.NovelImageDao novelImageDao = null;
    private final java.lang.String slug = null;
    private final com.example.api.UiMessageManager uiMessageManager = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.data.dto.chapters.ChaptersDto> results = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.data.dto.chapters.DownLoadChapter>> chapters = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.chapters.indice.ChaptersState> state = null;
    
    @javax.inject.Inject()
    public ChaptersViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapter observerChapters, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelUtil novelUtil, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.ChapterDao chapterDao, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.NovelImageDao novelImageDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.chapters.indice.ChaptersState> getState() {
        return null;
    }
    
    public final void getAllChapters(@org.jetbrains.annotations.NotNull()
    java.lang.String slug) {
    }
    
    public final void getAllChapterDownload(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> ids) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isDownload(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.ChapterEntity item) {
        return null;
    }
}