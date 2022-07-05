package com.example.data.local.daos;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.resultentities.HistoryEntryWithNovels;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\nH\'J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\'J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0012H\'J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/data/local/daos/HistoryNovelDao;", "Lcom/example/data/local/daos/PaginatedNovelsEntryDao;", "Lcom/example/data/local/entities/HistoryNovelEntry;", "Lcom/example/data/resultentities/HistoryEntryWithNovels;", "()V", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePage", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entriesObservable", "Lkotlinx/coroutines/flow/Flow;", "", "count", "offset", "entriesPagingSource", "Landroidx/paging/PagingSource;", "getLastPage", "data_debug"})
public abstract class HistoryNovelDao extends com.example.data.local.daos.PaginatedNovelsEntryDao<com.example.data.local.entities.HistoryNovelEntry, com.example.data.resultentities.HistoryEntryWithNovels> {
    
    public HistoryNovelDao() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM history_entries WHERE page = :page ORDER BY page_order")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.local.entities.HistoryNovelEntry>> entriesObservable(int page);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM history_entries ORDER BY page, page_order LIMIT :count OFFSET :offset")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.resultentities.HistoryEntryWithNovels>> entriesObservable(int count, int offset);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM history_entries ORDER BY page ASC ")
    @androidx.room.Transaction()
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.example.data.resultentities.HistoryEntryWithNovels> entriesPagingSource();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM history_entries WHERE page = :page")
    @java.lang.Override()
    public abstract java.lang.Object deletePage(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM history_entries")
    @java.lang.Override()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT MAX(page) from history_entries")
    @java.lang.Override()
    public abstract java.lang.Object getLastPage(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
}