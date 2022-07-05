package com.example.domain.observers;

import com.example.data.local.daos.HistoryDao;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.domain.SuspendingWorkInteractor;
import com.example.util.AppCoroutineDispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/domain/observers/ObserverSearchResults;", "Lcom/example/domain/SuspendingWorkInteractor;", "Lcom/example/domain/observers/ObserverSearchResults$Params;", "", "Lcom/example/data/local/entities/HistorySearchEntity;", "historyDao", "Lcom/example/data/local/daos/HistoryDao;", "dispatchers", "Lcom/example/util/AppCoroutineDispatchers;", "(Lcom/example/data/local/daos/HistoryDao;Lcom/example/util/AppCoroutineDispatchers;)V", "doWork", "params", "(Lcom/example/domain/observers/ObserverSearchResults$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "domain_debug"})
public final class ObserverSearchResults extends com.example.domain.SuspendingWorkInteractor<com.example.domain.observers.ObserverSearchResults.Params, java.util.List<? extends com.example.data.local.entities.HistorySearchEntity>> {
    private final com.example.data.local.daos.HistoryDao historyDao = null;
    private final com.example.util.AppCoroutineDispatchers dispatchers = null;
    
    @javax.inject.Inject()
    public ObserverSearchResults(@org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.HistoryDao historyDao, @org.jetbrains.annotations.NotNull()
    com.example.util.AppCoroutineDispatchers dispatchers) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverSearchResults.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.local.entities.HistorySearchEntity>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/example/domain/observers/ObserverSearchResults$Params;", "", "query", "", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_debug"})
    public static final class Params {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String query = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.observers.ObserverSearchResults.Params copy(@org.jetbrains.annotations.NotNull()
        java.lang.String query) {
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
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public Params(@org.jetbrains.annotations.NotNull()
        java.lang.String query) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQuery() {
            return null;
        }
    }
}