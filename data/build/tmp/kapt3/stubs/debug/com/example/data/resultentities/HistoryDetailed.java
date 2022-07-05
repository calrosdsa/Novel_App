package com.example.data.resultentities;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.NovelImageEntity;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0087\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/example/data/resultentities/HistoryDetailed;", "", "()V", "backdrop", "Lcom/example/data/local/entities/NovelImageEntity;", "getBackdrop", "()Lcom/example/data/local/entities/NovelImageEntity;", "backdrop$delegate", "Lkotlin/Lazy;", "images", "", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "show", "Lcom/example/data/local/entities/HistoryNovelEntity;", "getShow", "()Lcom/example/data/local/entities/HistoryNovelEntity;", "setShow", "(Lcom/example/data/local/entities/HistoryNovelEntity;)V", "equals", "", "other", "hashCode", "", "data_debug"})
public final class HistoryDetailed {
    @androidx.room.Embedded()
    public com.example.data.local.entities.HistoryNovelEntity show;
    @androidx.room.Relation(parentColumn = "id", entityColumn = "novel_id")
    public java.util.List<com.example.data.local.entities.NovelImageEntity> images;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    private final kotlin.Lazy backdrop$delegate = null;
    
    public HistoryDetailed() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.HistoryNovelEntity getShow() {
        return null;
    }
    
    public final void setShow(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistoryNovelEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.local.entities.NovelImageEntity> getImages() {
        return null;
    }
    
    public final void setImages(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.NovelImageEntity> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.local.entities.NovelImageEntity getBackdrop() {
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
}