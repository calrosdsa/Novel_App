package com.example.domain.util;

import com.example.domain.resources.Resource;
import com.example.api.UiMessageManager;
import com.example.base.InvokeError;
import com.example.base.InvokeStarted;
import com.example.base.InvokeStatus;
import com.example.base.InvokeSuccess;
import kotlinx.coroutines.flow.Flow;
import java.util.concurrent.atomic.AtomicInteger;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a/\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"collectData", "", "T", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/domain/resources/Resource;", "counter", "Lcom/example/domain/util/ObservableLoadingCounter;", "uiMessageManager", "Lcom/example/api/UiMessageManager;", "data", "Lkotlinx/coroutines/flow/MutableStateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lcom/example/domain/util/ObservableLoadingCounter;Lcom/example/api/UiMessageManager;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectStatus", "Lcom/example/base/InvokeStatus;", "(Lkotlinx/coroutines/flow/Flow;Lcom/example/domain/util/ObservableLoadingCounter;Lcom/example/api/UiMessageManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public final class ObservableLoadingCounterKt {
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object collectStatus(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends com.example.base.InvokeStatus> $this$collectStatus, @org.jetbrains.annotations.NotNull()
    com.example.domain.util.ObservableLoadingCounter counter, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessageManager uiMessageManager, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object collectData(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends com.example.domain.resources.Resource<T>> $this$collectData, @org.jetbrains.annotations.NotNull()
    com.example.domain.util.ObservableLoadingCounter counter, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessageManager uiMessageManager, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<T> data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p4) {
        return null;
    }
}