package com.example.domain.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/domain/util/NovelOption;", "", "()V", "All", "Completed", "Favorites", "Updated", "Lcom/example/domain/util/NovelOption$All;", "Lcom/example/domain/util/NovelOption$Updated;", "Lcom/example/domain/util/NovelOption$Favorites;", "Lcom/example/domain/util/NovelOption$Completed;", "domain_debug"})
public abstract class NovelOption {
    
    private NovelOption() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOption$All;", "Lcom/example/domain/util/NovelOption;", "()V", "domain_debug"})
    public static final class All extends com.example.domain.util.NovelOption {
        
        public All() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOption$Updated;", "Lcom/example/domain/util/NovelOption;", "()V", "domain_debug"})
    public static final class Updated extends com.example.domain.util.NovelOption {
        
        public Updated() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOption$Favorites;", "Lcom/example/domain/util/NovelOption;", "()V", "domain_debug"})
    public static final class Favorites extends com.example.domain.util.NovelOption {
        
        public Favorites() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/domain/util/NovelOption$Completed;", "Lcom/example/domain/util/NovelOption;", "()V", "domain_debug"})
    public static final class Completed extends com.example.domain.util.NovelOption {
        
        public Completed() {
            super();
        }
    }
}