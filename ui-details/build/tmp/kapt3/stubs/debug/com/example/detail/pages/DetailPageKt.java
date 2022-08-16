package com.example.detail.pages;

import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.example.data.dto.novel.Comment;
import com.example.detail.*;
import com.example.detail.R;
import com.example.novels.MainDestination;
import com.example.novels.Screen;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a?\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0014"}, d2 = {"CommentItem", "", "comment", "Lcom/example/data/dto/novel/Comment;", "NovelDetailPage", "viewModel", "Lcom/example/detail/NovelDetailViewModel;", "navController", "Landroidx/navigation/NavController;", "TagItem", "tag", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "navToCategory", "Lkotlin/Function0;", "TagItem-9LQNqLg", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function0;)V", "ui-details_debug"})
public final class DetailPageKt {
    
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
}