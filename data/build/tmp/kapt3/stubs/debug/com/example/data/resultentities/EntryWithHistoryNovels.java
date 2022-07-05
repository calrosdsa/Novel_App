package com.example.data.resultentities;

import com.example.data.local.entities.Entry;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.local.entities.NovelImageEntity;
import java.util.Objects;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0018\u0010\u0004\u001a\u00028\u0000X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/example/data/resultentities/EntryWithHistoryNovels;", "ET", "Lcom/example/data/local/entities/Entry;", "", "entry", "getEntry", "()Lcom/example/data/local/entities/Entry;", "setEntry", "(Lcom/example/data/local/entities/Entry;)V", "images", "", "Lcom/example/data/local/entities/NovelImageEntity;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "novel", "Lcom/example/data/local/entities/HistoryNovelEntity;", "getNovel", "()Lcom/example/data/local/entities/HistoryNovelEntity;", "relations", "getRelations", "setRelations", "generateStableId", "", "data_debug"})
public abstract interface EntryWithHistoryNovels<ET extends com.example.data.local.entities.Entry> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ET getEntry();
    
    public abstract void setEntry(@org.jetbrains.annotations.NotNull()
    ET p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.data.local.entities.HistoryNovelEntity> getRelations();
    
    public abstract void setRelations(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.HistoryNovelEntity> p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.data.local.entities.NovelImageEntity> getImages();
    
    public abstract void setImages(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.NovelImageEntity> p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.entities.HistoryNovelEntity getNovel();
    
    public abstract long generateStableId();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static <ET extends com.example.data.local.entities.Entry>com.example.data.local.entities.HistoryNovelEntity getNovel(@org.jetbrains.annotations.NotNull()
        com.example.data.resultentities.EntryWithHistoryNovels<ET> $this) {
            return null;
        }
        
        public static <ET extends com.example.data.local.entities.Entry>long generateStableId(@org.jetbrains.annotations.NotNull()
        com.example.data.resultentities.EntryWithHistoryNovels<ET> $this) {
            return 0L;
        }
    }
}