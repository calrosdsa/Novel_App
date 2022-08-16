package com.example.detail;

import androidx.annotation.StringRes;
import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.example.data.dto.novel.NovelDetailDto;
import com.example.data.dto.chapters.NovelChaptersDto;
import com.example.data.dto.reviews.ReviewsDto;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/example/detail/NovelState;", "", "is_loading", "", "novel", "Lcom/example/data/dto/novel/NovelDetailDto;", "currentId", "", "error", "", "(ZLcom/example/data/dto/novel/NovelDetailDto;ILjava/lang/String;)V", "getCurrentId", "()I", "getError", "()Ljava/lang/String;", "()Z", "getNovel", "()Lcom/example/data/dto/novel/NovelDetailDto;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ui-details_debug"})
public final class NovelState {
    private final boolean is_loading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.dto.novel.NovelDetailDto novel = null;
    private final int currentId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String error = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.detail.NovelState copy(boolean is_loading, @org.jetbrains.annotations.Nullable()
    com.example.data.dto.novel.NovelDetailDto novel, int currentId, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
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
    
    public NovelState() {
        super();
    }
    
    public NovelState(boolean is_loading, @org.jetbrains.annotations.Nullable()
    com.example.data.dto.novel.NovelDetailDto novel, int currentId, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean is_loading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.novel.NovelDetailDto component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.novel.NovelDetailDto getNovel() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getCurrentId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getError() {
        return null;
    }
}