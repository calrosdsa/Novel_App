package com.example.domain.interactors;

import com.example.data.store.category.CategoryStore;
import com.example.domain.Interactor;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB%\b\u0007\u0012\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\b\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR$\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0002`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/domain/interactors/UpdateCategory;", "Lcom/example/domain/Interactor;", "Lcom/example/domain/interactors/UpdateCategory$Params;", "categoryStore", "Lcom/dropbox/android/external/store4/Store;", "", "", "Lcom/example/data/local/entities/CategoryEntity;", "Lcom/example/data/store/category/CategoryStore;", "(Lcom/dropbox/android/external/store4/Store;)V", "deleteAll", "params", "(Lcom/example/domain/interactors/UpdateCategory$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Params", "domain_debug"})
public final class UpdateCategory extends com.example.domain.Interactor<com.example.domain.interactors.UpdateCategory.Params> {
    private final com.dropbox.android.external.store4.Store<kotlin.Unit, java.util.List<com.example.data.local.entities.CategoryEntity>> categoryStore = null;
    
    @javax.inject.Inject()
    public UpdateCategory(@org.jetbrains.annotations.NotNull()
    com.dropbox.android.external.store4.Store<kotlin.Unit, java.util.List<com.example.data.local.entities.CategoryEntity>> categoryStore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateCategory.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateCategory.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0018\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0013\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/example/domain/interactors/UpdateCategory$Params;", "", "it", "", "(Lkotlin/Unit;)V", "getIt", "()Lkotlin/Unit;", "Lkotlin/Unit;", "component1", "copy", "(Lkotlin/Unit;)Lcom/example/domain/interactors/UpdateCategory$Params;", "equals", "", "other", "hashCode", "", "toString", "", "domain_debug"})
    public static final class Params {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.Unit it = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.interactors.UpdateCategory.Params copy(@org.jetbrains.annotations.NotNull()
        kotlin.Unit it) {
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
        kotlin.Unit it) {
            super();
        }
        
        public final void component1() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.Unit getIt() {
            return null;
        }
    }
}