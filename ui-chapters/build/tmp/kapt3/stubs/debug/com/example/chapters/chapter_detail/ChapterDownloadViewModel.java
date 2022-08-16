package com.example.chapters.chapter_detail;

import android.util.Log;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.api.UiMessageManager;
import com.example.data.dto.chapters.SingleChapterDto;
import com.example.data.local.daos.ChapterDao;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.remote.ApiService;
import com.example.data.util.Constants;
import com.example.domain.observers.ObserverChapter;
import com.example.domain.observers.ObserverChapterDetail;
import com.example.domain.observers.ObserverChapters;
import com.example.domain.resources.Resource;
import com.example.domain.util.ObservableLoadingCounter;
import com.example.settings.AppTheme;
import com.example.settings.FontOption;
import com.example.settings.UserSettings;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"J\u000e\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ\u000e\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ\u000e\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ\u000e\u0010/\u001a\u00020*2\u0006\u0010+\u001a\u00020\'R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000fR\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000f\u00a8\u00060"}, d2 = {"Lcom/example/chapters/chapter_detail/ChapterDownloadViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "userSettings", "Lcom/example/settings/UserSettings;", "observerChapterDetail", "Lcom/example/domain/observers/ObserverChapterDetail;", "observerChapter", "Lcom/example/domain/observers/ObserverChapter;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/example/settings/UserSettings;Lcom/example/domain/observers/ObserverChapterDetail;Lcom/example/domain/observers/ObserverChapter;)V", "brightness", "Lkotlinx/coroutines/flow/StateFlow;", "", "getBrightness", "()Lkotlinx/coroutines/flow/StateFlow;", "brillo", "getBrillo", "()F", "fontSizeStream", "getFontSizeStream", "loadingState", "Lcom/example/domain/util/ObservableLoadingCounter;", "next", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "previous", "scrollStream", "getScrollStream", "slug", "state", "Lcom/example/chapters/chapter_detail/ChapterState;", "getState", "theme", "Lcom/example/settings/AppTheme;", "getTheme", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "weightStream", "Lcom/example/settings/FontOption;", "getWeightStream", "onChangeMode", "", "value", "setBrightness", "setFontSize", "setScrollSpeed", "setWeightStream", "ui-chapters_debug"})
public final class ChapterDownloadViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.settings.UserSettings userSettings = null;
    private final java.lang.String slug = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> previous = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> next = null;
    private final com.example.domain.util.ObservableLoadingCounter loadingState = null;
    private final com.example.api.UiMessageManager uiMessageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> brightness = null;
    private final float brillo = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.settings.AppTheme> theme = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> scrollStream = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> fontSizeStream = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.settings.FontOption> weightStream = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.chapters.chapter_detail.ChapterState> state = null;
    
    @javax.inject.Inject()
    public ChapterDownloadViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.example.settings.UserSettings userSettings, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapterDetail observerChapterDetail, @org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapter observerChapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getBrightness() {
        return null;
    }
    
    public final float getBrillo() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.settings.AppTheme> getTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getScrollStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getFontSizeStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.settings.FontOption> getWeightStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.chapters.chapter_detail.ChapterState> getState() {
        return null;
    }
    
    public final void setBrightness(float value) {
    }
    
    public final void onChangeMode(@org.jetbrains.annotations.NotNull()
    com.example.settings.AppTheme value) {
    }
    
    public final void setScrollSpeed(float value) {
    }
    
    public final void setFontSize(float value) {
    }
    
    public final void setWeightStream(@org.jetbrains.annotations.NotNull()
    com.example.settings.FontOption value) {
    }
}