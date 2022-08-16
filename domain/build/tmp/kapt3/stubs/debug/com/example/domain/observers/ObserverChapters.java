package com.example.domain.observers;

import com.example.data.local.daos.ChapterDao;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.resultentities.ChapterAndNovelImage;
import com.example.domain.SubjectInteractor;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/domain/observers/ObserverChapters;", "Lcom/example/domain/SubjectInteractor;", "Lcom/example/domain/observers/ObserverChapters$Params;", "", "Lcom/example/data/resultentities/ChapterAndNovelImage;", "chapterDao", "Lcom/example/data/local/daos/ChapterDao;", "(Lcom/example/data/local/daos/ChapterDao;)V", "createObservable", "Lkotlinx/coroutines/flow/Flow;", "params", "Params", "domain_debug"})
public final class ObserverChapters extends com.example.domain.SubjectInteractor<com.example.domain.observers.ObserverChapters.Params, java.util.List<? extends com.example.data.resultentities.ChapterAndNovelImage>> {
    private final com.example.data.local.daos.ChapterDao chapterDao = null;
    
    @javax.inject.Inject()
    public ObserverChapters(@org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.ChapterDao chapterDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.resultentities.ChapterAndNovelImage>> createObservable(@org.jetbrains.annotations.NotNull()
    com.example.domain.observers.ObserverChapters.Params params) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/domain/observers/ObserverChapters$Params;", "", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_debug"})
    public static final class Params {
        private final long id = 0L;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.observers.ObserverChapters.Params copy(long id) {
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
        
        public Params(long id) {
            super();
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long getId() {
            return 0L;
        }
    }
}