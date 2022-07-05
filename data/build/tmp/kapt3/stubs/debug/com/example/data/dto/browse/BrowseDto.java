package com.example.data.dto.browse;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0001H\u00c6\u0003J\t\u0010!\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0004H\u00c6\u0003J\t\u0010#\u001a\u00020\u0001H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0001H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0001H\u00c6\u0003J\t\u0010(\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u00c6\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00042\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0004H\u00d6\u0001J\t\u0010/\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00060"}, d2 = {"Lcom/example/data/dto/browse/BrowseDto;", "", "category_", "current", "", "next", "novels", "", "Lcom/example/data/dto/browse/Novel;", "ordering", "pages_count", "previous", "products_count", "status", "Lcom/example/data/dto/browse/Statu;", "status_", "", "(Ljava/lang/Object;ILjava/lang/Object;Ljava/util/List;Ljava/lang/Object;ILjava/lang/Object;ILjava/util/List;Ljava/lang/String;)V", "getCategory_", "()Ljava/lang/Object;", "getCurrent", "()I", "getNext", "getNovels", "()Ljava/util/List;", "getOrdering", "getPages_count", "getPrevious", "getProducts_count", "getStatus", "getStatus_", "()Ljava/lang/String;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class BrowseDto {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object category_ = null;
    private final int current = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object next = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.data.dto.browse.Novel> novels = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object ordering = null;
    private final int pages_count = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object previous = null;
    private final int products_count = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.data.dto.browse.Statu> status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status_ = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.dto.browse.BrowseDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.Object category_, int current, @org.jetbrains.annotations.NotNull()
    java.lang.Object next, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.browse.Novel> novels, @org.jetbrains.annotations.NotNull()
    java.lang.Object ordering, int pages_count, @org.jetbrains.annotations.NotNull()
    java.lang.Object previous, int products_count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.browse.Statu> status, @org.jetbrains.annotations.NotNull()
    java.lang.String status_) {
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
    
    public BrowseDto(@org.jetbrains.annotations.NotNull()
    java.lang.Object category_, int current, @org.jetbrains.annotations.NotNull()
    java.lang.Object next, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.browse.Novel> novels, @org.jetbrains.annotations.NotNull()
    java.lang.Object ordering, int pages_count, @org.jetbrains.annotations.NotNull()
    java.lang.Object previous, int products_count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.browse.Statu> status, @org.jetbrains.annotations.NotNull()
    java.lang.String status_) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getCategory_() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCurrent() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.dto.browse.Novel> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.dto.browse.Novel> getNovels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getOrdering() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getPages_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getPrevious() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getProducts_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.dto.browse.Statu> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.data.dto.browse.Statu> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus_() {
        return null;
    }
}