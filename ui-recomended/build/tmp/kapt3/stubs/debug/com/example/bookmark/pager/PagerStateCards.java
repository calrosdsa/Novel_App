package com.example.bookmark.pager;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.*;
import com.google.accompanist.pager.ExperimentalPagerApi;
import com.google.accompanist.pager.PagerState;

@androidx.compose.runtime.Stable()
@com.google.accompanist.pager.ExperimentalPagerApi()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001[B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010;\u001a\u00020<2\b\b\u0001\u0010=\u001a\u00020\u00032\b\b\u0003\u0010>\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?JI\u0010;\u001a\u00020<2\b\b\u0001\u0010=\u001a\u00020\u00032\b\b\u0003\u0010>\u001a\u00020\u001d2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001d0A2\b\b\u0002\u0010B\u001a\u00020\u001d2\b\b\u0002\u0010C\u001a\u00020.H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001dH\u0016J\r\u0010G\u001a\u00020<H\u0000\u00a2\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020KH\u0002JB\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020O2\'\u0010P\u001a#\b\u0001\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0S\u0012\u0006\u0012\u0004\u0018\u00010T0Q\u00a2\u0006\u0002\bUH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ%\u0010W\u001a\u00020<2\b\b\u0001\u0010=\u001a\u00020\u00032\b\b\u0003\u0010>\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?J\b\u0010X\u001a\u00020KH\u0016J\r\u0010Y\u001a\u00020<H\u0000\u00a2\u0006\u0002\bZR+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u001a\u0010\f\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u0004R/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038G@@X\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR?\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u0011\u0010)\u001a\u00020*8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010/R\u0014\u00100\u001a\u000201X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u00010\u00198@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u001b\u00106\u001a\u00020\u00038GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010!\u001a\u0004\b7\u0010\bR\u0011\u00109\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b:\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\\"}, d2 = {"Lcom/example/bookmark/pager/PagerStateCards;", "Lcom/example/bookmark/pager/ScrollableState;", "currentPage", "", "(I)V", "<set-?>", "_currentPage", "get_currentPage", "()I", "set_currentPage", "_currentPage$delegate", "Landroidx/compose/runtime/MutableState;", "afterContentPadding", "getAfterContentPadding$ui_recomended_debug", "setAfterContentPadding$ui_recomended_debug", "animationTargetPage", "getAnimationTargetPage", "()Ljava/lang/Integer;", "setAnimationTargetPage", "(Ljava/lang/Integer;)V", "animationTargetPage$delegate", "value", "getCurrentPage", "setCurrentPage$ui_recomended_debug", "currentPageLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getCurrentPageLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "currentPageOffset", "", "getCurrentPageOffset", "()F", "currentPageOffset$delegate", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "flingAnimationTarget", "getFlingAnimationTarget$ui_recomended_debug", "()Lkotlin/jvm/functions/Function0;", "setFlingAnimationTarget$ui_recomended_debug", "(Lkotlin/jvm/functions/Function0;)V", "flingAnimationTarget$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "", "()Z", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState$ui_recomended_debug", "()Landroidx/compose/foundation/lazy/LazyListState;", "mostVisiblePageLayoutInfo", "getMostVisiblePageLayoutInfo$ui_recomended_debug", "pageCount", "getPageCount", "pageCount$delegate", "targetPage", "getTargetPage", "animateScrollToPage", "", "page", "pageOffset", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "skipPages", "(IFLandroidx/compose/animation/core/AnimationSpec;FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "onScrollFinished", "onScrollFinished$ui_recomended_debug", "requireCurrentPage", "name", "", "requireCurrentPageOffset", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "toString", "updateCurrentPageBasedOnLazyListState", "updateCurrentPageBasedOnLazyListState$ui_recomended_debug", "Companion", "ui-recomended_debug"})
public final class PagerStateCards implements com.example.bookmark.pager.ScrollableState {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.foundation.lazy.LazyListState lazyListState = null;
    private final androidx.compose.runtime.MutableState _currentPage$delegate = null;
    private int afterContentPadding = 0;
    
    /**
     * The number of pages to display.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State pageCount$delegate = null;
    
    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State currentPageOffset$delegate = null;
    private final androidx.compose.runtime.MutableState animationTargetPage$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState flingAnimationTarget$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.bookmark.pager.PagerStateCards.Companion Companion = null;
    
    /**
     * The default [Saver] implementation for [PagerState].
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.runtime.saveable.Saver<com.example.bookmark.pager.PagerStateCards, ?> Saver = null;
    
    public PagerStateCards() {
        super();
    }
    
    public PagerStateCards(@androidx.annotation.IntRange(from = 0L)
    int currentPage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.foundation.lazy.LazyListState getLazyListState$ui_recomended_debug() {
        return null;
    }
    
    private final int get_currentPage() {
        return 0;
    }
    
    private final void set_currentPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.foundation.lazy.LazyListItemInfo getMostVisiblePageLayoutInfo$ui_recomended_debug() {
        return null;
    }
    
    public final int getAfterContentPadding$ui_recomended_debug() {
        return 0;
    }
    
    public final void setAfterContentPadding$ui_recomended_debug(int p0) {
    }
    
    private final androidx.compose.foundation.lazy.LazyListItemInfo getCurrentPageLayoutInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.foundation.interaction.InteractionSource getInteractionSource() {
        return null;
    }
    
    /**
     * The number of pages to display.
     */
    @androidx.annotation.IntRange(from = 0L)
    public final int getPageCount() {
        return 0;
    }
    
    @androidx.annotation.IntRange(from = 0L)
    public final int getCurrentPage() {
        return 0;
    }
    
    public final void setCurrentPage$ui_recomended_debug(int value) {
    }
    
    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    public final float getCurrentPageOffset() {
        return 0.0F;
    }
    
    private final java.lang.Integer getAnimationTargetPage() {
        return null;
    }
    
    private final void setAnimationTargetPage(java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<java.lang.Integer> getFlingAnimationTarget$ui_recomended_debug() {
        return null;
    }
    
    public final void setFlingAnimationTarget$ui_recomended_debug(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<java.lang.Integer> p0) {
    }
    
    public final int getTargetPage() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @java.lang.Deprecated()
    public final java.lang.Object animateScrollToPage(@androidx.annotation.IntRange(from = 0L)
    int page, @androidx.annotation.FloatRange(from = 0.0, to = 1.0)
    float pageOffset, @org.jetbrains.annotations.NotNull()
    androidx.compose.animation.core.AnimationSpec<java.lang.Float> animationSpec, float initialVelocity, boolean skipPages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object animateScrollToPage(@androidx.annotation.IntRange(from = 0L)
    int page, @androidx.annotation.FloatRange(from = 0.0, to = 1.0)
    float pageOffset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object scrollToPage(@androidx.annotation.IntRange(from = 0L)
    int page, @androidx.annotation.FloatRange(from = 0.0, to = 1.0)
    float pageOffset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void updateCurrentPageBasedOnLazyListState$ui_recomended_debug() {
    }
    
    public final void onScrollFinished$ui_recomended_debug() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object scroll(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.MutatePriority scrollPriority, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public float dispatchRawDelta(float delta) {
        return 0.0F;
    }
    
    @java.lang.Override()
    public boolean isScrollInProgress() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    private final void requireCurrentPage(int value, java.lang.String name) {
    }
    
    private final void requireCurrentPageOffset(float value, java.lang.String name) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/bookmark/pager/PagerStateCards$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/example/bookmark/pager/PagerStateCards;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-recomended_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.compose.runtime.saveable.Saver<com.example.bookmark.pager.PagerStateCards, ?> getSaver() {
            return null;
        }
    }
}