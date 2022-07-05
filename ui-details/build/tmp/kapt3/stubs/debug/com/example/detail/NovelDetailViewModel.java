package com.example.detail;

import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.data.util.Constants;
import com.example.domain.resources.Resource;
import com.example.domain.resources.TimeAgo;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetNovelDetail;
import com.example.domain.useCases.GetReviews;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.text.SimpleDateFormat;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u001cJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010&\u001a\u00020\"R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/example/detail/NovelDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getNovel", "Lcom/example/domain/useCases/GetNovelDetail;", "getChapters", "Lcom/example/domain/useCases/GetChapters;", "getReviews", "Lcom/example/domain/useCases/GetReviews;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/domain/useCases/GetNovelDetail;Lcom/example/domain/useCases/GetChapters;Lcom/example/domain/useCases/GetReviews;Landroidx/lifecycle/SavedStateHandle;)V", "_isRefresh", "Landroidx/compose/runtime/MutableState;", "", "_state", "Lcom/example/detail/NovelState;", "_stateChapters", "Lcom/example/detail/NovelChaptersState;", "_stateReview", "Lcom/example/detail/NovelReviewsState;", "chapters", "Landroidx/compose/runtime/State;", "()Landroidx/compose/runtime/State;", "isRefresh", "reviews", "sdf", "Ljava/text/SimpleDateFormat;", "slug", "", "state", "getState", "formatDate", "date", "getChaptersNovel", "", "novelSlug", "getNovelDetail", "getReviewsNovel", "refresh", "ui-details_debug"})
public final class NovelDetailViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.useCases.GetNovelDetail getNovel = null;
    private final com.example.domain.useCases.GetChapters getChapters = null;
    private final com.example.domain.useCases.GetReviews getReviews = null;
    private final java.text.SimpleDateFormat sdf = null;
    private final androidx.compose.runtime.MutableState<com.example.detail.NovelState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.detail.NovelState> state = null;
    private final androidx.compose.runtime.MutableState<com.example.detail.NovelChaptersState> _stateChapters = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.detail.NovelChaptersState> chapters = null;
    private final androidx.compose.runtime.MutableState<com.example.detail.NovelReviewsState> _stateReview = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.detail.NovelReviewsState> reviews = null;
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _isRefresh = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.Boolean> isRefresh = null;
    private final java.lang.String slug = null;
    
    @javax.inject.Inject()
    public NovelDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetNovelDetail getNovel, @org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetChapters getChapters, @org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetReviews getReviews, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.detail.NovelState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.detail.NovelChaptersState> getChapters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.detail.NovelReviewsState> getReviews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Boolean> isRefresh() {
        return null;
    }
    
    public final void refresh() {
    }
    
    private final void getNovelDetail(java.lang.String novelSlug) {
    }
    
    private final void getChaptersNovel(java.lang.String novelSlug) {
    }
    
    private final void getReviewsNovel(java.lang.String novelSlug) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
}