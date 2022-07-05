package com.example.signup;

import android.widget.Toast;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0003\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0003\u001a$\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a\b\u0010\n\u001a\u00020\u0001H\u0003\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0003\u001a\b\u0010\f\u001a\u00020\u0001H\u0003\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003\u001a\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003\u00a8\u0006\u0015"}, d2 = {"DerivedStateOfExample", "", "DerivedStateOfSample2", "scrollState", "Landroidx/compose/foundation/lazy/LazyListState;", "DisposableEffectLifecycleButton", "DisposableEffectWithLifeCycle", "onResume", "Lkotlin/Function0;", "onPause", "ProduceStateExample", "ProduceStateSampleButton", "SideEffectExample", "SnapshotFlowExample", "loadNetworkImage", "Landroidx/compose/runtime/State;", "Lcom/example/signup/Result;", "url", "", "imageRepository", "Lcom/example/signup/ImageRepository;", "ui-signup_debug"})
public final class SideEffectsKt {
    
    @androidx.compose.runtime.Composable()
    private static final void DisposableEffectLifecycleButton() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DisposableEffectWithLifeCycle(kotlin.jvm.functions.Function0<kotlin.Unit> onResume, kotlin.jvm.functions.Function0<kotlin.Unit> onPause) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SideEffectExample() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProduceStateSampleButton() {
    }
    
    /**
     * produceState launches a coroutine scoped to the Composition that can push values into
     * a returned State. Use it to convert non-Compose state into Compose state,
     * for example bringing external subscription-driven
     * state such as Flow, LiveData, or RxJava into the Composition.
     *
     * The producer is launched when produceState enters the Composition,
     * and will be cancelled when it leaves the Composition. The returned State conflates;
     * setting the same value won't trigger a recomposition.
     * Even though produceState creates a coroutine, it can also be used to observe
     * non-suspending sources of data. To remove the subscription to that source,
     * use the awaitDispose function.
     */
    @androidx.compose.runtime.Composable()
    private static final void ProduceStateExample() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final androidx.compose.runtime.State<com.example.signup.Result> loadNetworkImage(java.lang.String url, com.example.signup.ImageRepository imageRepository) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DerivedStateOfExample() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DerivedStateOfSample2(androidx.compose.foundation.lazy.LazyListState scrollState) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SnapshotFlowExample(androidx.compose.foundation.lazy.LazyListState scrollState) {
    }
}