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

/**
 * Scope for [HorizontalPager] content.
 */
@androidx.compose.runtime.Stable()
@com.google.accompanist.pager.ExperimentalPagerApi()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/recommended/pager/PagerScope;", "", "currentPage", "", "getCurrentPage", "()I", "currentPageOffset", "", "getCurrentPageOffset", "()F", "ui-recomended_debug"})
public abstract interface PagerScope {
    
    /**
     * Returns the current selected page
     */
    public abstract int getCurrentPage();
    
    /**
     * The current offset from the start of [currentPage], as a ratio of the page width.
     */
    public abstract float getCurrentPageOffset();
}