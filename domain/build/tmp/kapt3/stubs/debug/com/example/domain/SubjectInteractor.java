package com.example.domain;

import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.base.*;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.*;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\f\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/domain/SubjectInteractor;", "P", "", "T", "()V", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "paramState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "createObservable", "params", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "invoke", "", "(Ljava/lang/Object;)V", "domain_debug"})
public abstract class SubjectInteractor<P extends java.lang.Object, T extends java.lang.Object> {
    private final kotlinx.coroutines.flow.MutableSharedFlow<P> paramState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<T> flow = null;
    
    public SubjectInteractor() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<T> getFlow() {
        return null;
    }
    
    public final void invoke(@org.jetbrains.annotations.NotNull()
    P params) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlinx.coroutines.flow.Flow<T> createObservable(@org.jetbrains.annotations.NotNull()
    P params);
}