package com.example.domain;

import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.base.*;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.*;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/domain/SuspendingWorkInteractor;", "P", "", "T", "Lcom/example/domain/SubjectInteractor;", "()V", "createObservable", "Lkotlinx/coroutines/flow/Flow;", "params", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "doWork", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public abstract class SuspendingWorkInteractor<P extends java.lang.Object, T extends java.lang.Object> extends com.example.domain.SubjectInteractor<P, T> {
    
    public SuspendingWorkInteractor() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlinx.coroutines.flow.Flow<T> createObservable(@org.jetbrains.annotations.NotNull()
    P params) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    P params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> continuation);
}