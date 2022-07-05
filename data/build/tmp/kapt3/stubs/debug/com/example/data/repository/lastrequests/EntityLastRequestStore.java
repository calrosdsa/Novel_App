package com.example.data.repository.lastrequests;

import com.example.data.local.daos.LastRequestDao;
import com.example.data.local.entities.LastRequest;
import com.example.data.local.entities.Request;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.TemporalAmount;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/data/repository/lastrequests/EntityLastRequestStore;", "", "request", "Lcom/example/data/local/entities/Request;", "dao", "Lcom/example/data/local/daos/LastRequestDao;", "(Lcom/example/data/local/entities/Request;Lcom/example/data/local/daos/LastRequestDao;)V", "getRequestInstant", "Lorg/threeten/bp/Instant;", "entityId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasBeenRequested", "", "invalidateLastRequest", "", "isRequestBefore", "instant", "(JLorg/threeten/bp/Instant;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRequestExpired", "threshold", "Lorg/threeten/bp/temporal/TemporalAmount;", "(JLorg/threeten/bp/temporal/TemporalAmount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastRequest", "timestamp", "data_debug"})
public class EntityLastRequestStore {
    private final com.example.data.local.entities.Request request = null;
    private final com.example.data.local.daos.LastRequestDao dao = null;
    
    public EntityLastRequestStore(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.LastRequestDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRequestInstant(long entityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super org.threeten.bp.Instant> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isRequestExpired(long entityId, @org.jetbrains.annotations.NotNull()
    org.threeten.bp.temporal.TemporalAmount threshold, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object hasBeenRequested(long entityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isRequestBefore(long entityId, @org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant instant, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLastRequest(long entityId, @org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invalidateLastRequest(long entityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}