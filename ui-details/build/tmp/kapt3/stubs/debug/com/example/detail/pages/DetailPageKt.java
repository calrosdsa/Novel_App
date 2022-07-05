package com.example.detail.pages;

import androidx.annotation.StringRes;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.example.data.dto.novel.Comment;
import com.example.detail.*;
import com.example.detail.R;
import com.example.novels.Screen;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000^\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a?\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0003\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006 "}, d2 = {"listOfBottomItems", "", "Lcom/example/detail/pages/BottomItem$ImageVectorIcon;", "CommentItem", "", "comment", "Lcom/example/data/dto/novel/Comment;", "NovelDetailPage", "viewModel", "Lcom/example/detail/NovelDetailViewModel;", "navController", "Landroidx/navigation/NavController;", "TagItem", "tag", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "navToCategory", "Lkotlin/Function0;", "TagItem-9LQNqLg", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function0;)V", "rememberScrollConection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "toolbarOffsetHeightPx", "Landroidx/compose/runtime/MutableState;", "", "toolbarHeightPx", "isScrollingUp", "", "Landroidx/compose/foundation/lazy/LazyListState;", "ui-details_debug"})
public final class DetailPageKt {
    private static final java.util.List<com.example.detail.pages.BottomItem.ImageVectorIcon> listOfBottomItems = null;
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void NovelDetailPage(@org.jetbrains.annotations.NotNull()
    com.example.detail.NovelDetailViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CommentItem(@org.jetbrains.annotations.NotNull()
    com.example.data.dto.novel.Comment comment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.compose.runtime.Composable()
    public static final androidx.compose.ui.input.nestedscroll.NestedScrollConnection rememberScrollConection(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Float> toolbarOffsetHeightPx, float toolbarHeightPx) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final boolean isScrollingUp(androidx.compose.foundation.lazy.LazyListState $this$isScrollingUp) {
        return false;
    }
}