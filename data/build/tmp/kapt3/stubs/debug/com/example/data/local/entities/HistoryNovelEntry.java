package com.example.data.local.entities;

import androidx.room.*;

@androidx.room.Entity(tableName = "history_entries", indices = {@androidx.room.Index(unique = true, value = {"novel_id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/example/data/local/entities/HistoryNovelEntry;", "Lcom/example/data/local/entities/PaginatedEntry;", "id", "", "novelId", "page", "", "pageOrder", "(JJII)V", "getId", "()J", "getNovelId", "getPage", "()I", "getPageOrder", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "data_debug"})
public final class HistoryNovelEntry implements com.example.data.local.entities.PaginatedEntry {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @androidx.room.ColumnInfo(name = "novel_id")
    private final long novelId = 0L;
    @androidx.room.ColumnInfo(name = "page")
    private final int page = 0;
    @androidx.room.ColumnInfo(name = "page_order")
    private final int pageOrder = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.entities.HistoryNovelEntry copy(long id, long novelId, int page, int pageOrder) {
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
    
    public HistoryNovelEntry(long id, long novelId, int page, int pageOrder) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getId() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @java.lang.Override()
    public long getNovelId() {
        return 0L;
    }
    
    public final int component3() {
        return 0;
    }
    
    @java.lang.Override()
    public int getPage() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getPageOrder() {
        return 0;
    }
}