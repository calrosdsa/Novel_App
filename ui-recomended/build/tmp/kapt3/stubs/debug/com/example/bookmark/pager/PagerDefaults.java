package com.example.bookmark.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.example.recommended.pager.PagerScope;
import com.google.accompanist.pager.ExperimentalPagerApi;
import com.google.accompanist.pager.PagerState;
import dev.chrisbanes.snapper.*;

/**
 * Contains the default values used by [HorizontalPager] and [VerticalPager].
 */
@com.google.accompanist.pager.ExperimentalPagerApi()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J]\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 JG\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"J\u0085\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2<\u0010#\u001a8\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000bH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tRR\u0010\n\u001a8\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2 = {"Lcom/example/bookmark/pager/PagerDefaults;", "", "()V", "singlePageFlingDistance", "Lkotlin/Function1;", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "", "getSinglePageFlingDistance$annotations", "getSinglePageFlingDistance", "()Lkotlin/jvm/functions/Function1;", "singlePageSnapIndex", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "startIndex", "targetIndex", "getSinglePageSnapIndex$annotations", "getSinglePageSnapIndex", "()Lkotlin/jvm/functions/Function3;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "state", "Lcom/example/bookmark/pager/PagerStateCards;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "maximumFlingDistance", "endContentPadding", "Landroidx/compose/ui/unit/Dp;", "flingBehavior-M2VBTUQ", "(Lcom/example/bookmark/pager/PagerStateCards;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;F)Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior-eqLRuRQ", "(Lcom/example/bookmark/pager/PagerStateCards;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;F)Landroidx/compose/foundation/gestures/FlingBehavior;", "snapIndex", "flingBehavior-2lqI77k", "(Lcom/example/bookmark/pager/PagerStateCards;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/gestures/FlingBehavior;", "ui-recomended_debug"})
public final class PagerDefaults {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.bookmark.pager.PagerDefaults INSTANCE = null;
    
    /**
     * The default implementation for the `maximumFlingDistance` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    private static final kotlin.jvm.functions.Function1<dev.chrisbanes.snapper.SnapperLayoutInfo, java.lang.Float> singlePageFlingDistance = null;
    
    /**
     * The default implementation for the `snapIndex` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function3<dev.chrisbanes.snapper.SnapperLayoutInfo, java.lang.Integer, java.lang.Integer, java.lang.Integer> singlePageSnapIndex = null;
    
    private PagerDefaults() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public final kotlin.jvm.functions.Function1<dev.chrisbanes.snapper.SnapperLayoutInfo, java.lang.Float> getSinglePageFlingDistance() {
        return null;
    }
    
    /**
     * The default implementation for the `maximumFlingDistance` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @kotlin.Suppress(names = {"MemberVisibilityCanBePrivate"})
    @dev.chrisbanes.snapper.ExperimentalSnapperApi()
    @java.lang.Deprecated()
    public static void getSinglePageFlingDistance$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<dev.chrisbanes.snapper.SnapperLayoutInfo, java.lang.Integer, java.lang.Integer, java.lang.Integer> getSinglePageSnapIndex() {
        return null;
    }
    
    /**
     * The default implementation for the `snapIndex` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @dev.chrisbanes.snapper.ExperimentalSnapperApi()
    @java.lang.Deprecated()
    public static void getSinglePageSnapIndex$annotations() {
    }
}