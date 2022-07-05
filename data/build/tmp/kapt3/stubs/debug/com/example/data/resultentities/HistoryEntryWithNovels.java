package com.example.data.resultentities;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.local.entities.NovelImageEntity;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001e\u0010\u0004\u001a\u00020\u00028\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n8\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/data/resultentities/HistoryEntryWithNovels;", "Lcom/example/data/resultentities/EntryWithHistoryNovels;", "Lcom/example/data/local/entities/HistoryNovelEntry;", "()V", "entry", "getEntry", "()Lcom/example/data/local/entities/HistoryNovelEntry;", "setEntry", "(Lcom/example/data/local/entities/HistoryNovelEntry;)V", "images", "", "Lcom/example/data/local/entities/NovelImageEntity;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "relations", "Lcom/example/data/local/entities/HistoryNovelEntity;", "getRelations", "setRelations", "equals", "", "other", "", "hashCode", "", "data_debug"})
public final class HistoryEntryWithNovels implements com.example.data.resultentities.EntryWithHistoryNovels<com.example.data.local.entities.HistoryNovelEntry> {
    @androidx.room.Embedded()
    public com.example.data.local.entities.HistoryNovelEntry entry;
    @androidx.room.Relation(parentColumn = "novel_id", entityColumn = "id")
    public java.util.List<com.example.data.local.entities.HistoryNovelEntity> relations;
    @androidx.room.Relation(parentColumn = "novel_id", entityColumn = "novel_id")
    public java.util.List<com.example.data.local.entities.NovelImageEntity> images;
    
    public HistoryEntryWithNovels() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.data.local.entities.HistoryNovelEntry getEntry() {
        return null;
    }
    
    @java.lang.Override()
    public void setEntry(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistoryNovelEntry p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.data.local.entities.HistoryNovelEntity> getRelations() {
        return null;
    }
    
    @java.lang.Override()
    public void setRelations(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.HistoryNovelEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.data.local.entities.NovelImageEntity> getImages() {
        return null;
    }
    
    @java.lang.Override()
    public void setImages(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.NovelImageEntity> p0) {
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
    
    public long generateStableId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.data.local.entities.HistoryNovelEntity getNovel() {
        return null;
    }
}