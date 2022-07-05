package com.example.bookmark;

import androidx.lifecycle.MediatorLiveData;
import com.example.domain.util.NovelOrder;
import com.example.data.local.entities.FollowingEntity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J_\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\bH\u00d6\u0001J\t\u0010*\u001a\u00020+H\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006,"}, d2 = {"Lcom/example/bookmark/FollowingState;", "", "loading", "", "followings", "", "Lcom/example/data/local/entities/FollowingEntity;", "option", "", "ordering", "Lcom/example/domain/util/NovelOrder;", "filterType", "Lcom/example/bookmark/FilterOption;", "currentItem", "message", "Lcom/example/api/UiMessage;", "(ZLjava/util/List;ILcom/example/domain/util/NovelOrder;Lcom/example/bookmark/FilterOption;Lcom/example/data/local/entities/FollowingEntity;Lcom/example/api/UiMessage;)V", "getCurrentItem", "()Lcom/example/data/local/entities/FollowingEntity;", "getFilterType", "()Lcom/example/bookmark/FilterOption;", "getFollowings", "()Ljava/util/List;", "getLoading", "()Z", "getMessage", "()Lcom/example/api/UiMessage;", "getOption", "()I", "getOrdering", "()Lcom/example/domain/util/NovelOrder;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ui-bookshelf_debug"})
public final class FollowingState {
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.example.data.local.entities.FollowingEntity> followings = null;
    private final int option = 0;
    @org.jetbrains.annotations.Nullable()
    private final com.example.domain.util.NovelOrder ordering = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.bookmark.FilterOption filterType = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.local.entities.FollowingEntity currentItem = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.api.UiMessage message = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.bookmark.FollowingState copy(boolean loading, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.local.entities.FollowingEntity> followings, int option, @org.jetbrains.annotations.Nullable()
    com.example.domain.util.NovelOrder ordering, @org.jetbrains.annotations.Nullable()
    com.example.bookmark.FilterOption filterType, @org.jetbrains.annotations.Nullable()
    com.example.data.local.entities.FollowingEntity currentItem, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public FollowingState() {
        super();
    }
    
    public FollowingState(boolean loading, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.local.entities.FollowingEntity> followings, int option, @org.jetbrains.annotations.Nullable()
    com.example.domain.util.NovelOrder ordering, @org.jetbrains.annotations.Nullable()
    com.example.bookmark.FilterOption filterType, @org.jetbrains.annotations.Nullable()
    com.example.data.local.entities.FollowingEntity currentItem, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.local.entities.FollowingEntity> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.local.entities.FollowingEntity> getFollowings() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getOption() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.domain.util.NovelOrder component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.domain.util.NovelOrder getOrdering() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bookmark.FilterOption component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bookmark.FilterOption getFilterType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.local.entities.FollowingEntity component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.local.entities.FollowingEntity getCurrentItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage getMessage() {
        return null;
    }
}