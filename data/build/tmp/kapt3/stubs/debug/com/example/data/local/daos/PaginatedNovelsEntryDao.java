package com.example.data.local.daos;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Transaction;
import com.example.data.local.entities.PaginatedEntry;
import com.example.data.resultentities.EntryWithHistoryNovels;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u0004\u0018\u00010\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001f\u0010\u0012\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\'\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/data/local/daos/PaginatedNovelsEntryDao;", "EC", "Lcom/example/data/local/entities/PaginatedEntry;", "LI", "Lcom/example/data/resultentities/EntryWithHistoryNovels;", "Lcom/example/data/local/daos/EntryDao;", "()V", "deletePage", "", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastPage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "entity", "(Lcom/example/data/local/entities/PaginatedEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "", "([Lcom/example/data/local/entities/PaginatedEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePage", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract class PaginatedNovelsEntryDao<EC extends com.example.data.local.entities.PaginatedEntry, LI extends com.example.data.resultentities.EntryWithHistoryNovels<EC>> extends com.example.data.local.daos.EntryDao<EC, LI> {
    
    public PaginatedNovelsEntryDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    @java.lang.Override()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    EC entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    @java.lang.Override()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    EC[] entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    @java.lang.Override()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends EC> entities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletePage(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLastPage(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Transaction()
    public java.lang.Object updatePage(int page, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends EC> entities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}