package com.example.data.local.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.data.local.entities.NovelImageEntity;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/data/local/daos/NovelImageDao;", "Lcom/example/data/local/daos/EntityDao;", "Lcom/example/data/local/entities/NovelImageEntity;", "()V", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteForShowId", "showId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImagesForShowId", "Lkotlinx/coroutines/flow/Flow;", "imageCountForShowId", "", "data_debug"})
public abstract class NovelImageDao extends com.example.data.local.daos.EntityDao<com.example.data.local.entities.NovelImageEntity> {
    
    public NovelImageDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM novel_images WHERE novel_id = :showId")
    public abstract java.lang.Object deleteForShowId(long showId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM novel_images WHERE novel_id = :showId")
    public abstract java.lang.Object imageCountForShowId(long showId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM novel_images WHERE novel_id = :showId")
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.local.entities.NovelImageEntity> getImagesForShowId(long showId);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM novel_images")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}