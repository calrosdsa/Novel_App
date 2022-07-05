package com.example.data.local.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import org.threeten.bp.Instant;

@androidx.room.Entity(tableName = "last_requests", indices = {@androidx.room.Index(unique = true, value = {"request", "entity_id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/example/data/local/entities/LastRequest;", "Lcom/example/data/local/entities/NovelEntity;", "id", "", "request", "Lcom/example/data/local/entities/Request;", "entityId", "timestamp", "Lorg/threeten/bp/Instant;", "(JLcom/example/data/local/entities/Request;JLorg/threeten/bp/Instant;)V", "getEntityId", "()J", "getId", "getRequest", "()Lcom/example/data/local/entities/Request;", "getTimestamp", "()Lorg/threeten/bp/Instant;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_debug"})
public final class LastRequest implements com.example.data.local.entities.NovelEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "request")
    private final com.example.data.local.entities.Request request = null;
    @androidx.room.ColumnInfo(name = "entity_id")
    private final long entityId = 0L;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "timestamp")
    private final org.threeten.bp.Instant timestamp = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.LastRequest copy(long id, @org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, long entityId, @org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant timestamp) {
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
    
    public LastRequest(long id, @org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request request, long entityId, @org.jetbrains.annotations.NotNull()
    org.threeten.bp.Instant timestamp) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.Request component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.Request getRequest() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getEntityId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.threeten.bp.Instant component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.threeten.bp.Instant getTimestamp() {
        return null;
    }
}