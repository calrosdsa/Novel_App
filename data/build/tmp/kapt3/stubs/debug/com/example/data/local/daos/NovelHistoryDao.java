package com.example.data.local.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.data.local.entities.HistoryNovelEntity;
import com.example.data.resultentities.HistoryDetailed;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/data/local/daos/NovelHistoryDao;", "Lcom/example/data/local/daos/EntityDao;", "Lcom/example/data/local/entities/HistoryNovelEntity;", "()V", "delete", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistoryDetailedWithIdFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/data/resultentities/HistoryDetailed;", "getHistoryWithIdDetailed", "getIdOrSavePlaceholder", "show", "(Lcom/example/data/local/entities/HistoryNovelEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNovelWithIdFlow", "getShowWithId", "getShowWithIdOrThrow", "data_debug"})
public abstract class NovelHistoryDao extends com.example.data.local.daos.EntityDao<com.example.data.local.entities.HistoryNovelEntity> {
    
    public NovelHistoryDao() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM novel_history WHERE id = :id")
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.local.entities.HistoryNovelEntity> getNovelWithIdFlow(long id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM novel_history WHERE id = :id")
    @androidx.room.Transaction()
    public abstract java.lang.Object getHistoryWithIdDetailed(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.resultentities.HistoryDetailed> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM novel_history WHERE id = :id")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.resultentities.HistoryDetailed> getHistoryDetailedWithIdFlow(long id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM novel_history WHERE id = :id")
    public abstract java.lang.Object getShowWithId(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.local.entities.HistoryNovelEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getShowWithIdOrThrow(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.local.entities.HistoryNovelEntity> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM novel_history WHERE id = :id")
    public abstract java.lang.Object delete(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM novel_history")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getIdOrSavePlaceholder(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistoryNovelEntity show, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
}