package com.example.data.repository;

import com.example.data.NovelDatabaseDao;
import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.HistoryDao;
import com.example.data.local.entities.HistorySearchEntity;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\fH\u0016J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/data/repository/NovelRepositoryDbImpl;", "Lcom/example/data/repository/NovelRepositoryDb;", "historyDao", "Lcom/example/data/local/daos/HistoryDao;", "(Lcom/example/data/local/daos/HistoryDao;)V", "deleteAllSearch", "", "allSearch", "", "Lcom/example/data/local/entities/HistorySearchEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSearchHistories", "Lkotlinx/coroutines/flow/Flow;", "insetHistorySearch", "historySearchEntity", "(Lcom/example/data/local/entities/HistorySearchEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class NovelRepositoryDbImpl implements com.example.data.repository.NovelRepositoryDb {
    private final com.example.data.local.daos.HistoryDao historyDao = null;
    
    @javax.inject.Inject()
    public NovelRepositoryDbImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.HistoryDao historyDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.local.entities.HistorySearchEntity>> getAllSearchHistories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insetHistorySearch(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistorySearchEntity historySearchEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAllSearch(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.HistorySearchEntity> allSearch, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}