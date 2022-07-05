package com.example.domain.util;

import com.example.domain.resources.Resource;
import com.example.api.UiMessageManager;
import com.example.base.InvokeError;
import com.example.base.InvokeStarted;
import com.example.base.InvokeStatus;
import com.example.base.InvokeSuccess;
import kotlinx.coroutines.flow.Flow;
import java.util.concurrent.atomic.AtomicInteger;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/domain/util/ObservableLoadingCounter;", "", "()V", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "observable", "Lkotlinx/coroutines/flow/Flow;", "", "getObservable", "()Lkotlinx/coroutines/flow/Flow;", "addLoader", "", "removeLoader", "domain_debug"})
public final class ObservableLoadingCounter {
    private final java.util.concurrent.atomic.AtomicInteger count = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> loadingState = null;
    
    public ObservableLoadingCounter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getObservable() {
        return null;
    }
    
    public final void addLoader() {
    }
    
    public final void removeLoader() {
    }
}