package com.example.data.local.daos;

import com.example.data.local.entities.Entry;
import com.example.data.resultentities.EntryWithHistoryNovels;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/data/local/daos/EntryDao;", "EC", "Lcom/example/data/local/entities/Entry;", "LI", "Lcom/example/data/resultentities/EntryWithHistoryNovels;", "Lcom/example/data/local/daos/EntityDao;", "()V", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract class EntryDao<EC extends com.example.data.local.entities.Entry, LI extends com.example.data.resultentities.EntryWithHistoryNovels<EC>> extends com.example.data.local.daos.EntityDao<EC> {
    
    public EntryDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}