package com.example.domain.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/example/domain/util/NovelOrder;", "", "()V", "compare", "", "novelOrder", "Added", "Updated", "Lcom/example/domain/util/NovelOrder$Added;", "Lcom/example/domain/util/NovelOrder$Updated;", "domain_debug"})
public abstract class NovelOrder {
    
    private NovelOrder() {
        super();
    }
    
    public final boolean compare(@org.jetbrains.annotations.NotNull()
    com.example.domain.util.NovelOrder novelOrder) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOrder$Added;", "Lcom/example/domain/util/NovelOrder;", "()V", "domain_debug"})
    public static final class Added extends com.example.domain.util.NovelOrder {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.domain.util.NovelOrder.Added INSTANCE = null;
        
        private Added() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOrder$Updated;", "Lcom/example/domain/util/NovelOrder;", "()V", "domain_debug"})
    public static final class Updated extends com.example.domain.util.NovelOrder {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.domain.util.NovelOrder.Updated INSTANCE = null;
        
        private Updated() {
            super();
        }
    }
}