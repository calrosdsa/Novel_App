package com.example.bookmark.pager

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.recommended.pager.PagerCard
import com.example.recommended.pager.PagerScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import dev.chrisbanes.snapper.*


/**
 * Contains the default values used by [HorizontalPager] and [VerticalPager].
 */
@ExperimentalPagerApi
object PagerDefaults {
    /**
     * The default implementation for the `maximumFlingDistance` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @ExperimentalSnapperApi
    @Suppress("MemberVisibilityCanBePrivate")
    @Deprecated("MaximumFlingDistance has been deprecated in Snapper")
    val singlePageFlingDistance: (SnapperLayoutInfo) -> Float = { layoutInfo ->
        // We can scroll up to the scrollable size of the lazy layout
        layoutInfo.endScrollOffset - layoutInfo.startScrollOffset.toFloat()
    }

    /**
     * The default implementation for the `snapIndex` parameter of
     * [flingBehavior] which limits the fling distance to a single page.
     */
    @ExperimentalSnapperApi
    val singlePageSnapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int =
        { layoutInfo, startIndex, targetIndex ->
            targetIndex
                .coerceIn(startIndex - 1, startIndex + 1)
                .coerceIn(0, layoutInfo.totalItemsCount - 1)
        }

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param maximumFlingDistance Block which returns the maximum fling distance in pixels.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     */
    @Composable
    @ExperimentalSnapperApi
    @Deprecated("MaximumFlingDistance has been deprecated in Snapper, replaced with snapIndex")
    @Suppress("DEPRECATION")
    fun flingBehavior(
        state: PagerStateCards,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        maximumFlingDistance: (SnapperLayoutInfo) -> Float = singlePageFlingDistance,
        endContentPadding: Dp = 0.dp,
    ): FlingBehavior = rememberSnapperFlingBehavior(
        lazyListState = state.lazyListState,
        snapOffsetForItem = SnapOffsets.Center, // pages are full width, so we use the simplest
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = snapAnimationSpec,
        maximumFlingDistance = maximumFlingDistance,
        endContentPadding = endContentPadding,
    )

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     * @param snapIndex Block which returns the index to snap to. The block is provided with the
     * [SnapperLayoutInfo], the index where the fling started, and the index which Snapper has
     * determined is the correct target index. Callers can override this value to any valid index
     * for the layout. Some common use cases include limiting the fling distance, and rounding up/down
     * to achieve snapping to groups of items.
     */
    @Composable
    @ExperimentalSnapperApi
    fun flingBehavior(
        state: PagerStateCards,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        endContentPadding: Dp = 0.dp,
        snapIndex: (SnapperLayoutInfo, startIndex: Int, targetIndex: Int) -> Int,
    ): FlingBehavior = rememberSnapperFlingBehavior(
        lazyListState = state.lazyListState,
        //snapOffsetForItem = SnapOffsets.Start, // pages are full width, so we use the simplest
        snapOffsetForItem = SnapOffsets.Center, // pages are full width, so we use the simplest
        decayAnimationSpec = decayAnimationSpec,
        springAnimationSpec = snapAnimationSpec,
        endContentPadding = endContentPadding,
        snapIndex = snapIndex,
    )

    /**
     * Remember the default [FlingBehavior] that represents the scroll curve.
     *
     * Please remember to provide the correct [endContentPadding] if supplying your own
     * [FlingBehavior] to [VerticalPager] or [HorizontalPager]. See those functions for how they
     * calculate the value.
     *
     * @param state The [PagerState] to update.
     * @param decayAnimationSpec The decay animation spec to use for decayed flings.
     * @param snapAnimationSpec The animation spec to use when snapping.
     * @param endContentPadding The amount of content padding on the end edge of the lazy list
     * in pixels (end/bottom depending on the scrolling direction).
     */
    @Composable
    @ExperimentalSnapperApi
    fun flingBehavior(
        state: PagerStateCards,
        decayAnimationSpec: DecayAnimationSpec<Float> = rememberSplineBasedDecay(),
        snapAnimationSpec: AnimationSpec<Float> = SnapperFlingBehaviorDefaults.SpringAnimationSpec,
        endContentPadding: Dp = 0.dp,
    ): FlingBehavior {
        // You might be wondering this is function exists rather than a default value for snapIndex
        // above. It was done to remove overload ambiguity with the maximumFlingDistance overload
        // below. When that function is removed, we also remove this function and move to a default
        // param value.
        return flingBehavior(
            state = state,
            decayAnimationSpec = decayAnimationSpec,
            snapAnimationSpec = snapAnimationSpec,
            endContentPadding = endContentPadding,
            snapIndex = singlePageSnapIndex,
        )
    }
}


@OptIn(ExperimentalSnapperApi::class)
@ExperimentalPagerApi
@Composable
fun HorizontalPagerCard(
    count: Int,
    modifier: Modifier = Modifier,
    state: PagerStateCards = rememberPagerStateCards(),
    reverseLayout: Boolean = false,
    itemSpacing: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    flingBehavior: FlingBehavior = PagerDefaults.flingBehavior(
        state = state,
        endContentPadding = contentPadding.calculateEndPadding(LayoutDirection.Ltr),
    ),
    key: ((page: Int) -> Any)? = null,
    userScrollEnabled: Boolean = true,
    content: @Composable PagerScope.(page: Int) -> Unit,
) {
    PagerCard(
        count = count,
        state = state,
        modifier = modifier,
        isVertical = false,
        reverseLayout = reverseLayout,
        itemSpacing = itemSpacing,
        verticalAlignment = verticalAlignment,
        flingBehavior = flingBehavior,
        key = key,
        contentPadding = contentPadding,
        userScrollEnabled = userScrollEnabled,
        content = content
    )
}





