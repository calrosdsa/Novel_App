package com.example.domain.interactors;

import com.example.data.remote.ApiService;
import com.example.data.remote.NovelOption;
import com.example.data.store.following.FollowingStore;
import com.example.domain.Interactor;
import com.example.util.AppCoroutineDispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0002`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0002`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/domain/interactors/UpdatedOptionsBookMark;", "Lcom/example/domain/Interactor;", "Lcom/example/domain/interactors/UpdatedOptionsBookMark$Params;", "apiService", "Lcom/example/data/remote/ApiService;", "followingStore", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/FollowingEntity;", "Lcom/example/data/store/following/FollowingStore;", "dispatchers", "Lcom/example/util/AppCoroutineDispatchers;", "(Lcom/example/data/remote/ApiService;Lcom/dropbox/android/external/store4/Store;Lcom/example/util/AppCoroutineDispatchers;)V", "deleteAll", "", "params", "(Lcom/example/domain/interactors/UpdatedOptionsBookMark$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Params", "domain_debug"})
public final class UpdatedOptionsBookMark extends com.example.domain.Interactor<com.example.domain.interactors.UpdatedOptionsBookMark.Params> {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.dropbox.android.external.store4.Store<java.lang.String, java.util.List<com.example.data.local.entities.FollowingEntity>> followingStore = null;
    private final com.example.util.AppCoroutineDispatchers dispatchers = null;
    
    @javax.inject.Inject()
    public UpdatedOptionsBookMark(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.dropbox.android.external.store4.Store<java.lang.String, java.util.List<com.example.data.local.entities.FollowingEntity>> followingStore, @org.jetbrains.annotations.NotNull()
    com.example.util.AppCoroutineDispatchers dispatchers) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdatedOptionsBookMark.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdatedOptionsBookMark.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/domain/interactors/UpdatedOptionsBookMark$Params;", "", "token", "", "novelId", "", "option", "(Ljava/lang/String;II)V", "getNovelId", "()I", "getOption", "getToken", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "domain_debug"})
    public static final class Params {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String token = null;
        private final int novelId = 0;
        private final int option = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.interactors.UpdatedOptionsBookMark.Params copy(@org.jetbrains.annotations.NotNull()
        java.lang.String token, int novelId, int option) {
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
        java.lang.String token, int novelId, int option) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getToken() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int getNovelId() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getOption() {
            return 0;
        }
    }
}