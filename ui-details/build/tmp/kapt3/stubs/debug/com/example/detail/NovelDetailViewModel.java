package com.example.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.data.local.daos.FollowingDao;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.repository.NovelRepository;
import com.example.data.repository.NovelUtil;
import com.example.data.util.Constants;
import com.example.domain.StateRefresh;
import com.example.domain.UserAuth;
import com.example.domain.resources.Resource;
import com.example.domain.resources.TimeAgo;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetNovelDetail;
import com.example.domain.useCases.GetReviews;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020#J\u0010\u0010>\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u000207J\u0010\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u000207H\u0002J\u0010\u0010B\u001a\u00020<2\u0006\u0010A\u001a\u000207H\u0002J\u0010\u0010C\u001a\u00020<2\u0006\u0010A\u001a\u000207H\u0002J\u0006\u0010D\u001a\u00020<R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R/\u0010,\u001a\u0004\u0018\u00010+2\b\u0010!\u001a\u0004\u0018\u00010+8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010*\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010 R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u000e\u0010:\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/example/detail/NovelDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getNovel", "Lcom/example/domain/useCases/GetNovelDetail;", "novelRepository", "Lcom/example/data/repository/NovelRepository;", "getChapters", "Lcom/example/domain/useCases/GetChapters;", "getReviews", "Lcom/example/domain/useCases/GetReviews;", "novelUtil", "Lcom/example/data/repository/NovelUtil;", "auth", "Lcom/example/domain/UserAuth;", "followingDao", "Lcom/example/data/local/daos/FollowingDao;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "context", "Landroid/content/Context;", "(Lcom/example/domain/useCases/GetNovelDetail;Lcom/example/data/repository/NovelRepository;Lcom/example/domain/useCases/GetChapters;Lcom/example/domain/useCases/GetReviews;Lcom/example/data/repository/NovelUtil;Lcom/example/domain/UserAuth;Lcom/example/data/local/daos/FollowingDao;Landroidx/lifecycle/SavedStateHandle;Landroid/content/Context;)V", "_isRefresh", "Landroidx/compose/runtime/MutableState;", "", "_state", "Lcom/example/detail/NovelState;", "_stateChapters", "Lcom/example/detail/NovelChaptersState;", "_stateReview", "Lcom/example/detail/NovelReviewsState;", "chapters", "Landroidx/compose/runtime/State;", "()Landroidx/compose/runtime/State;", "<set-?>", "", "", "ids", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "ids$delegate", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Bitmap;", "imgBit", "getImgBit", "()Landroid/graphics/Bitmap;", "setImgBit", "(Landroid/graphics/Bitmap;)V", "imgBit$delegate", "isRefresh", "reviews", "sdf", "Ljava/text/SimpleDateFormat;", "slug", "", "state", "getState", "tokenKey", "addToLibrary", "", "currentId", "formatDate", "date", "getChaptersNovel", "novelSlug", "getNovelDetail", "getReviewsNovel", "refresh", "ui-details_debug"})
public final class NovelDetailViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.useCases.GetNovelDetail getNovel = null;
    private final com.example.data.repository.NovelRepository novelRepository = null;
    private final com.example.domain.useCases.GetChapters getChapters = null;
    private final com.example.domain.useCases.GetReviews getReviews = null;
    private final com.example.data.repository.NovelUtil novelUtil = null;
    private final com.example.domain.UserAuth auth = null;
    private final com.example.data.local.daos.FollowingDao followingDao = null;
    private final android.content.Context context = null;
    private final java.text.SimpleDateFormat sdf = null;
    private final java.lang.String tokenKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState ids$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState imgBit$delegate = null;
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
    com.example.data.repository.NovelRepository novelRepository, @org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetChapters getChapters, @org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetReviews getReviews, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelUtil novelUtil, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.FollowingDao followingDao, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getIds() {
        return null;
    }
    
    public final void setIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getImgBit() {
        return null;
    }
    
    public final void setImgBit(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
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
    
    public final void addToLibrary(int currentId) {
    }
}