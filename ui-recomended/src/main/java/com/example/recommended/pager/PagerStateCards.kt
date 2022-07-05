package com.example.bookmark.pager

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.roundToInt


@ExperimentalPagerApi
@Composable
fun rememberPagerStateCards(
    @IntRange(from = 0) initialPage: Int = 0,
): PagerStateCards = rememberSaveable(saver = PagerStateCards.Saver) {
    PagerStateCards(
        currentPage = initialPage,
    )
}


@ExperimentalPagerApi
@Stable
class PagerStateCards(
    @IntRange(from = 0) currentPage: Int = 0,
) :ScrollableState {
     internal  val lazyListState = LazyListState(firstVisibleItemIndex = currentPage)

    private var _currentPage by mutableStateOf(currentPage)

    internal val mostVisiblePageLayoutInfo: LazyListItemInfo?
        get() {
            val layoutInfo = lazyListState.layoutInfo
            return layoutInfo.visibleItemsInfo.maxByOrNull {
                val start = maxOf(it.offset, 0)
                val end = minOf(it.offset + it.size, layoutInfo.viewportEndOffset - afterContentPadding)
                end - start
            }
        }
    internal var afterContentPadding = 0

    private val currentPageLayoutInfo: LazyListItemInfo?
        get() = lazyListState.layoutInfo.visibleItemsInfo.lastOrNull {
            it.index == currentPage
        }

    /**
     * [InteractionSource] that will be used to dispatch drag events when this
     * list is being dragged. If you want to know whether the fling (or animated scroll) is in
     * progress, use [isScrollInProgress].
     */
    val interactionSource: InteractionSource
        get() = lazyListState.interactionSource

    /**
     * The number of pages to display.
     */
    @get:IntRange(from = 0)
    val pageCount: Int by derivedStateOf {
        lazyListState.layoutInfo.totalItemsCount
    }

    /**
     * The index of the currently selected page. This may not be the page which is
     * currently displayed on screen.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    @get:IntRange(from = 0)
    var currentPage: Int
        get() = _currentPage
        internal set(value) {
            if (value != _currentPage) {
                _currentPage = value
            }
        }

    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     *
     * To update the scroll position, use [scrollToPage] or [animateScrollToPage].
     */
    val currentPageOffset: Float by derivedStateOf {
        currentPageLayoutInfo?.let {
            // We coerce since itemSpacing can make the offset > 1f.
            // We don't want to count spacing in the offset so cap it to 1f
            (-it.offset / it.size.toFloat()).coerceIn(-1f, 1f)
        } ?: 0f
    }

    private var animationTargetPage: Int? by mutableStateOf(null)

    internal var flingAnimationTarget: (() -> Int?)? by mutableStateOf(null)

    val targetPage: Int
        get() = animationTargetPage
            ?: flingAnimationTarget?.invoke()
            ?: when {
                // If a scroll isn't in progress, return the current page
                !isScrollInProgress -> currentPage
                // If the offset is 0f (or very close), return the current page
                currentPageOffset.absoluteValue < 0.001f -> currentPage
                // If we're offset towards the start, guess the previous page
                currentPageOffset < 0f -> (currentPage - 1).coerceAtLeast(0)
                // If we're offset towards the end, guess the next page
                else -> (currentPage + 1).coerceAtMost(pageCount - 1)
            }

    @Deprecated(
        "Replaced with animateScrollToPage(page, pageOffset)",
        ReplaceWith("animateScrollToPage(page = page, pageOffset = pageOffset)")
    )
    @Suppress("UNUSED_PARAMETER")
    suspend fun animateScrollToPage(
        @IntRange(from = 0) page: Int,
        @FloatRange(from = 0.0, to = 1.0) pageOffset: Float = 0f,
        animationSpec: AnimationSpec<Float> = spring(),
        initialVelocity: Float = 0f,
        skipPages: Boolean = true,
    ) {
        animateScrollToPage(page = page, pageOffset = pageOffset)
    }


    suspend fun animateScrollToPage(
        @IntRange(from = 0) page: Int,
        @FloatRange(from = 0.0, to = 1.0) pageOffset: Float = 0f,
    ) {
        requireCurrentPage(page, "page")
        requireCurrentPageOffset(pageOffset, "pageOffset")
        try {
            animationTargetPage = page
//          oldPage = 5
            //page = 4
            // pre-jump to nearby item for long jumps as an optimization
            // the same trick is done in ViewPager2
            val oldPage = lazyListState.firstVisibleItemIndex
            val isReverse = oldPage - page == 2
  //          if (isTwoPage){
//                lazyListState.animateScrollToItem(page,20)
  //          }
            if(isReverse){
                lazyListState.animateScrollToItem(page)
            }
            lazyListState.scrollToItem(page)


        } finally {
            // We need to manually call this, as the `animateScrollToItem` call above will happen
            // in 1 frame, which is usually too fast for the LaunchedEffect in Pager to detect
            // the change. This is especially true when running unit tests.
            onScrollFinished()
        }
    }


    suspend fun scrollToPage(
        @IntRange(from = 0) page: Int,
        @FloatRange(from = 0.0, to = 1.0) pageOffset: Float = 0f,
    ) {
        requireCurrentPage(page, "page")
        requireCurrentPageOffset(pageOffset, "pageOffset")
        try {
            animationTargetPage = page

            // First scroll to the given page. It will now be laid out at offset 0
            lazyListState.scrollToItem(index = page)
            updateCurrentPageBasedOnLazyListState()

            // If we have a start spacing, we need to offset (scroll) by that too
            if (pageOffset > 0.0001f) {
                scroll {
                    currentPageLayoutInfo?.let {
                        scrollBy(it.size * pageOffset)
                    }
                }
            }
        } finally {
            // We need to manually call this, as the `scroll` call above will happen in 1 frame,
            // which is usually too fast for the LaunchedEffect in Pager to detect the change.
            // This is especially true when running unit tests.
            onScrollFinished()
        }
    }

    internal fun updateCurrentPageBasedOnLazyListState() {
        // Then update the current page to our layout page
        mostVisiblePageLayoutInfo?.let {
            currentPage = it.index
        }
    }

    internal fun onScrollFinished() {
        // Clear the animation target page
        animationTargetPage = null
    }

    override suspend fun scroll(
        scrollPriority: MutatePriority,
        block: suspend ScrollScope.() -> Unit
    ) = lazyListState.scroll(scrollPriority, block)

    override fun dispatchRawDelta(delta: Float): Float {
        return lazyListState.dispatchRawDelta(delta)
    }

    override val isScrollInProgress: Boolean
        get() = lazyListState.isScrollInProgress

    override fun toString(): String = "PagerState(" +
            "pageCount=$pageCount, " +
            "currentPage=$currentPage, " +
            "currentPageOffset=$currentPageOffset" +
            ")"

    private fun requireCurrentPage(value: Int, name: String) {
        if (pageCount == 0) {
            require(value == 0) { "$name must be 0 when pageCount is 0" }
        } else {
            require(value in 0 until pageCount) {
                "$name[$value] must be >= 0 and < pageCount"
            }
        }
    }

    private fun requireCurrentPageOffset(value: Float, name: String) {
        if (pageCount == 0) {
            require(value == 0f) { "$name must be 0f when pageCount is 0" }
        } else {
            require(value in 0f..1f) { "$name must be >= 0 and <= 1" }
        }
    }

    companion object {
        /**
         * The default [Saver] implementation for [PagerState].
         */
        val Saver: Saver<PagerStateCards, *> = listSaver(
            save = {
                listOf<Any>(
                    it.currentPage,
                )
            },
            restore = {
                PagerStateCards(
                    currentPage = it[0] as Int,
                )
            }
        )

}
}