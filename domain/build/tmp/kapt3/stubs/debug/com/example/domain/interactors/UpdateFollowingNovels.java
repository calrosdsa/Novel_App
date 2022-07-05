package com.example.domain.interactors;

import com.example.data.store.following.FollowingStore;
import com.example.domain.Interactor;
import com.example.util.AppCoroutineDispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B-\b\u0007\u0012\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/domain/interactors/UpdateFollowingNovels;", "Lcom/example/domain/Interactor;", "Lcom/example/domain/interactors/UpdateFollowingNovels$Params;", "followingStore", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/FollowingEntity;", "Lcom/example/data/store/following/FollowingStore;", "dispatchers", "Lcom/example/util/AppCoroutineDispatchers;", "(Lcom/dropbox/android/external/store4/Store;Lcom/example/util/AppCoroutineDispatchers;)V", "deleteAll", "", "params", "(Lcom/example/domain/interactors/UpdateFollowingNovels$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Params", "domain_debug"})
public final class UpdateFollowingNovels extends com.example.domain.Interactor<com.example.domain.interactors.UpdateFollowingNovels.Params> {
    private final com.dropbox.android.external.store4.Store<java.lang.String, java.util.List<com.example.data.local.entities.FollowingEntity>> followingStore = null;
    private final com.example.util.AppCoroutineDispatchers dispatchers = null;
    
    @javax.inject.Inject()
    public UpdateFollowingNovels(@org.jetbrains.annotations.NotNull()
    com.dropbox.android.external.store4.Store<java.lang.String, java.util.List<com.example.data.local.entities.FollowingEntity>> followingStore, @org.jetbrains.annotations.NotNull()
    com.example.util.AppCoroutineDispatchers dispatchers) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateFollowingNovels.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateFollowingNovels.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/domain/interactors/UpdateFollowingNovels$Params;", "", "query", "", "forceRefresh", "", "(Ljava/lang/String;Z)V", "getForceRefresh", "()Z", "getQuery", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "domain_debug"})
    public static final class Params {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String query = null;
        private final boolean forceRefresh = false;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.interactors.UpdateFollowingNovels.Params copy(@org.jetbrains.annotations.NotNull()
        java.lang.String query, boolean forceRefresh) {
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
        
        public Params(@org.jetbrains.annotations.NotNull()
        java.lang.String query, boolean forceRefresh) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQuery() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean getForceRefresh() {
            return false;
        }
    }
}