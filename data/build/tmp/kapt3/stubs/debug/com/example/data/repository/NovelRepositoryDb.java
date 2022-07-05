package com.example.data.repository;

import com.example.data.local.entities.HistorySearchEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tH&J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/data/repository/NovelRepositoryDb;", "", "deleteAllSearch", "", "allSearch", "", "Lcom/example/data/local/entities/HistorySearchEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSearchHistories", "Lkotlinx/coroutines/flow/Flow;", "insetHistorySearch", "historySearchEntity", "(Lcom/example/data/local/entities/HistorySearchEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface NovelRepositoryDb {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.local.entities.HistorySearchEntity>> getAllSearchHistories();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insetHistorySearch(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.HistorySearchEntity historySearchEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllSearch(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.HistorySearchEntity> allSearch, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}