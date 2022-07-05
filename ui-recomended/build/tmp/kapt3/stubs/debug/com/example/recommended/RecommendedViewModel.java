package com.example.recommended;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.example.data.local.daos.FollowingDao;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.repository.NovelRepository;
import com.example.data.repository.NovelUtil;
import com.example.domain.StateRefresh;
import com.example.domain.UserAuth;
import com.example.domain.UserData;
import com.example.domain.resources.Resource;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetRecommended;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.IOException;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0006\u00107\u001a\u000208J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u000208H\u0002J\u000e\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000206J\u000e\u0010\u001a\u001a\u0002082\u0006\u0010=\u001a\u00020\u0018R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180 2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180 8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010\'2\b\u0010\u0017\u001a\u0004\u0018\u00010\'8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010/\u001a\u00020.2\u0006\u0010\u0017\u001a\u00020.8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00105\u001a\u000206X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/example/recommended/RecommendedViewModel;", "Landroidx/lifecycle/ViewModel;", "getRecommended", "Lcom/example/domain/useCases/GetRecommended;", "getChapters", "Lcom/example/domain/useCases/GetChapters;", "novelRepository", "Lcom/example/data/repository/NovelRepository;", "novelUtil", "Lcom/example/data/repository/NovelUtil;", "followingDao", "Lcom/example/data/local/daos/FollowingDao;", "auth", "Lcom/example/domain/UserAuth;", "context", "Landroid/content/Context;", "(Lcom/example/domain/useCases/GetRecommended;Lcom/example/domain/useCases/GetChapters;Lcom/example/data/repository/NovelRepository;Lcom/example/data/repository/NovelUtil;Lcom/example/data/local/daos/FollowingDao;Lcom/example/domain/UserAuth;Landroid/content/Context;)V", "_stateChapters", "Landroidx/compose/runtime/MutableState;", "Lcom/example/recommended/NovelChaptersState;", "chapters", "Landroidx/compose/runtime/State;", "()Landroidx/compose/runtime/State;", "<set-?>", "", "currentId", "getCurrentId", "()I", "setCurrentId", "(I)V", "currentId$delegate", "Landroidx/compose/runtime/MutableState;", "", "ids", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "ids$delegate", "Landroid/graphics/Bitmap;", "imgBit", "getImgBit", "()Landroid/graphics/Bitmap;", "setImgBit", "(Landroid/graphics/Bitmap;)V", "imgBit$delegate", "Lcom/example/recommended/RecommendedState;", "state", "getState", "()Lcom/example/recommended/RecommendedState;", "setState", "(Lcom/example/recommended/RecommendedState;)V", "state$delegate", "tokenKey", "", "addNovelToBookMark", "", "getAllNovelsFoo", "getAllNovelsIds", "getChaptersNovel", "novelSlug", "id", "ui-recomended_debug"})
public final class RecommendedViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.useCases.GetRecommended getRecommended = null;
    private final com.example.domain.useCases.GetChapters getChapters = null;
    private final com.example.data.repository.NovelRepository novelRepository = null;
    private final com.example.data.repository.NovelUtil novelUtil = null;
    private final com.example.data.local.daos.FollowingDao followingDao = null;
    private final com.example.domain.UserAuth auth = null;
    private final java.lang.String tokenKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState state$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState currentId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState ids$delegate = null;
    private final androidx.compose.runtime.MutableState<com.example.recommended.NovelChaptersState> _stateChapters = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.recommended.NovelChaptersState> chapters = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState imgBit$delegate = null;
    
    @javax.inject.Inject()
    public RecommendedViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetRecommended getRecommended, @org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetChapters getChapters, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository novelRepository, @org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelUtil novelUtil, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.FollowingDao followingDao, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.recommended.RecommendedState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    com.example.recommended.RecommendedState p0) {
    }
    
    public final int getCurrentId() {
        return 0;
    }
    
    public final void setCurrentId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getIds() {
        return null;
    }
    
    public final void setIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.recommended.NovelChaptersState> getChapters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getImgBit() {
        return null;
    }
    
    public final void setImgBit(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    private final void getAllNovelsFoo() {
    }
    
    private final void getAllNovelsIds() {
    }
    
    public final void getChaptersNovel(@org.jetbrains.annotations.NotNull()
    java.lang.String novelSlug) {
    }
    
    public final void getCurrentId(int id) {
    }
    
    public final void addNovelToBookMark() {
    }
}