package com.example.data.local.entities;

import android.graphics.Bitmap;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "novel_images")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00d6\u0001J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/example/data/local/entities/NovelImageEntity;", "Lcom/example/data/local/entities/NovelEntity;", "id", "", "novelId", "title", "", "chapterCount", "", "image", "Landroid/graphics/Bitmap;", "(JJLjava/lang/String;ILandroid/graphics/Bitmap;)V", "getChapterCount", "()I", "getId", "()J", "getImage", "()Landroid/graphics/Bitmap;", "getNovelId", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "data_debug"})
public final class NovelImageEntity implements com.example.data.local.entities.NovelEntity {
    @androidx.room.PrimaryKey()
    private final long id = 0L;
    @androidx.room.ColumnInfo(name = "novel_id")
    private final long novelId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private final int chapterCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Bitmap image = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.NovelImageEntity copy(long id, long novelId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int chapterCount, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image) {
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
    
    public NovelImageEntity(long id, long novelId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int chapterCount, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getId() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getNovelId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getChapterCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getImage() {
        return null;
    }
}