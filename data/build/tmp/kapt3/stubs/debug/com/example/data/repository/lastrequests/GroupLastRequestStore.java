package com.example.data.repository.lastrequests;

import com.example.data.local.daos.LastRequestDao;
import com.example.data.local.entities.LastRequest;
import com.example.data.local.entities.Request;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.TemporalAmount;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/data/repository/lastrequests/GroupLastRequestStore;", "", "request", "Lcom/example/data/local/entities/Request;", "dao", "Lcom/example/data/local/daos/LastRequestDao;", "(Lcom/example/data/local/entities/Request;Lcom/example/data/local/daos/LastRequestDao;)V", "getRequestInstant", "Lorg/threeten/bp/Instant;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateLastRequest", "", "isRequestBefore", "", "instant", "(Lorg/threeten/bp/Instant;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRequestExpired", "threshold", "Lorg/threeten/bp/temporal/TemporalAmount;", "(Lorg/threeten/bp/temporal/TemporalAmount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastRequest", "timestamp", "Companion", "data_debug"})
public class GroupLastRequestStore {
    private final com.example.data.local.entities.Request request = null;
    private final com.example.data.local.daos.LastRequestDao dao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.repository.lastrequests.GroupLastRequestStore.Companion Companion = null;
    private static final long DEFAULT_ID = 0L;
    
    public GroupLastRequestStore(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.LastRequestDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRequestInstant(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.threeten.bp.Instant> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isRequestExpired(@org.jetbrains.annotations.NotNull()
    org.threeten.bp.temporal.TemporalAmount threshold, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isRequestBefore(@org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant instant, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLastRequest(@org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invalidateLastRequest(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/repository/lastrequests/GroupLastRequestStore$Companion;", "", "()V", "DEFAULT_ID", "", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}