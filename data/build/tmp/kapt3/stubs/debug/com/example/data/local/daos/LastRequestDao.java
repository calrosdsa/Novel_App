package com.example.data.local.daos;

import androidx.room.*;
import com.example.data.local.entities.LastRequest;
import com.example.data.local.entities.Request;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/data/local/daos/LastRequestDao;", "Lcom/example/data/local/daos/EntityDao;", "Lcom/example/data/local/entities/LastRequest;", "()V", "insert", "", "entity", "(Lcom/example/data/local/entities/LastRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lastRequest", "request", "Lcom/example/data/local/entities/Request;", "entityId", "(Lcom/example/data/local/entities/Request;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCount", "", "data_debug"})
public abstract class LastRequestDao extends com.example.data.local.daos.EntityDao<com.example.data.local.entities.LastRequest> {
    
    public LastRequestDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM last_requests WHERE request = :request AND entity_id = :entityId")
    public abstract java.lang.Object lastRequest(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, long entityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.local.entities.LastRequest> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM last_requests WHERE request = :request AND entity_id = :entityId")
    public abstract java.lang.Object requestCount(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, long entityId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    @androidx.room.Transaction()
    @java.lang.Override()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.LastRequest entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
}