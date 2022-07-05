package com.example.discover;

import com.example.data.dto.browse.BrowseDto;
import com.example.data.local.entities.CategoryEntity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/discover/DiscoverState;", "", "categoryEntity", "", "Lcom/example/data/local/entities/CategoryEntity;", "loading", "", "message", "Lcom/example/api/UiMessage;", "(Ljava/util/List;ZLcom/example/api/UiMessage;)V", "getCategoryEntity", "()Ljava/util/List;", "getLoading", "()Z", "getMessage", "()Lcom/example/api/UiMessage;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "ui-discover_debug"})
public final class DiscoverState {
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.example.data.local.entities.CategoryEntity> categoryEntity = null;
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.example.api.UiMessage message = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.discover.DiscoverState copy(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.local.entities.CategoryEntity> categoryEntity, boolean loading, @org.jetbrains.annotations.Nullable()
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
    
    public DiscoverState() {
        super();
    }
    
    public DiscoverState(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.local.entities.CategoryEntity> categoryEntity, boolean loading, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.local.entities.CategoryEntity> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.local.entities.CategoryEntity> getCategoryEntity() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage getMessage() {
        return null;
    }
}