package com.example.domain.interactors;

import com.example.data.local.daos.HistoryNovelDao;
import com.example.data.store.history_novels.HistoryNovelsStore;
import com.example.domain.Interactor;
import com.example.util.AppCoroutineDispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B5\b\u0007\u0012\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/domain/interactors/UpdatedHistoryNovels;", "Lcom/example/domain/Interactor;", "Lcom/example/domain/interactors/UpdatedHistoryNovels$Params;", "historyNovelsStore", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/HistoryNovelEntry;", "Lcom/example/data/store/history_novels/HistoryNovelsStore;", "dispatchers", "Lcom/example/util/AppCoroutineDispatchers;", "historyNovelDao", "Lcom/example/data/local/daos/HistoryNovelDao;", "(Lcom/dropbox/android/external/store4/Store;Lcom/example/util/AppCoroutineDispatchers;Lcom/example/data/local/daos/HistoryNovelDao;)V", "deleteAll", "", "params", "(Lcom/example/domain/interactors/UpdatedHistoryNovels$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Params", "domain_debug"})
public final class UpdatedHistoryNovels extends com.example.domain.Interactor<com.example.domain.interactors.UpdatedHistoryNovels.Params> {
    private final com.dropbox.android.external.store4.Store<java.lang.Integer, java.util.List<com.example.data.local.entities.HistoryNovelEntry>> historyNovelsStore = null;
    private final com.example.util.AppCoroutineDispatchers dispatchers = null;
    private final com.example.data.local.daos.HistoryNovelDao historyNovelDao = null;
    
    @javax.inject.Inject()
    public UpdatedHistoryNovels(@org.jetbrains.annotations.NotNull()
    com.dropbox.android.external.store4.Store<java.lang.Integer, java.util.List<com.example.data.local.entities.HistoryNovelEntry>> historyNovelsStore, @org.jetbrains.annotations.NotNull()
    com.example.util.AppCoroutineDispatchers dispatchers, @org.jetbrains.annotations.NotNull()
    com.example.data.local.daos.HistoryNovelDao historyNovelDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdatedHistoryNovels.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdatedHistoryNovels.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/domain/interactors/UpdatedHistoryNovels$Params;", "", "page", "", "forceRefresh", "", "(IZ)V", "getForceRefresh", "()Z", "getPage", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "domain_debug"})
    public static final class Params {
        private final int page = 0;
        private final boolean forceRefresh = false;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.interactors.UpdatedHistoryNovels.Params copy(int page, boolean forceRefresh) {
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
        
        public Params(int page, boolean forceRefresh) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getPage() {
            return 0;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean getForceRefresh() {
            return false;
        }
    }
}