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

@com.google.accompanist.pager.ExperimentalPagerApi()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/recommended/pager/PagerScopeImpl;", "Lcom/example/recommended/pager/PagerScope;", "state", "Lcom/example/bookmark/pager/PagerStateCards;", "(Lcom/example/bookmark/pager/PagerStateCards;)V", "currentPage", "", "getCurrentPage", "()I", "currentPageOffset", "", "getCurrentPageOffset", "()F", "ui-recomended_debug"})
final class PagerScopeImpl implements com.example.recommended.pager.PagerScope {
    private final com.example.bookmark.pager.PagerStateCards state = null;
    
    public PagerScopeImpl(@org.jetbrains.annotations.NotNull()
    com.example.bookmark.pager.PagerStateCards state) {
        super();
    }
    
    @java.lang.Override()
    public int getCurrentPage() {
        return 0;
    }
    
    @java.lang.Override()
    public float getCurrentPageOffset() {
        return 0.0F;
    }
}