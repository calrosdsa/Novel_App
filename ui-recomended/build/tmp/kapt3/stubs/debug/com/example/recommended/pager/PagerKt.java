package com.example.recommended.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Dp;
import com.example.bookmark.pager.PagerStateCards;
import com.google.accompanist.pager.ExperimentalPagerApi;
import dev.chrisbanes.snapper.ExperimentalSnapperApi;
import dev.chrisbanes.snapper.SnapperFlingBehavior;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00c9\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b21\u0010\u001c\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u001d\u00a2\u0006\u0002\b\u001f\u00a2\u0006\u0002\b H\u0001\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"\u001a\u0014\u0010#\u001a\u00020$*\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0007\u001a)\u0010%\u001a\u00020&*\u00020&2\u0006\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010*\u001a)\u0010%\u001a\u00020+*\u00020+2\u0006\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b,\u0010*\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006-"}, d2 = {"PagerCard", "", "count", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/example/bookmark/pager/PagerStateCards;", "reverseLayout", "", "itemSpacing", "Landroidx/compose/ui/unit/Dp;", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "page", "", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "userScrollEnabled", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function2;", "Lcom/example/recommended/pager/PagerScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "PagerCard-Fsagccs", "(ILandroidx/compose/ui/Modifier;Lcom/example/bookmark/pager/PagerStateCards;ZFZLandroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;)V", "calculateCurrentOffsetForPage", "", "consume", "Landroidx/compose/ui/geometry/Offset;", "consumeHorizontal", "consumeVertical", "consume-9KIMszo", "(JZZ)J", "Landroidx/compose/ui/unit/Velocity;", "consume-BMRW4eQ", "ui-recomended_debug"})
public final class PagerKt {
    
    /**
     * Calculate the offset for the given [page] from the current scroll position. This is useful
     * when using the scroll position to apply effects or animations to items.
     *
     * The returned offset can positive or negative, depending on whether which direction the [page] is
     * compared to the current scroll position.
     *
     * @sample com.google.accompanist.sample.pager.HorizontalPagerWithOffsetTransition
     */
    @com.google.accompanist.pager.ExperimentalPagerApi()
    public static final float calculateCurrentOffsetForPage(@org.jetbrains.annotations.NotNull()
    com.example.recommended.pager.PagerScope $this$calculateCurrentOffsetForPage, int page) {
        return 0.0F;
    }
}