package com.example.recommended.pagination;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.TextAlign;
import com.example.bookmark.pager.PagerStateCards;
import com.example.data.dto.recommended.RecommendedItem;
import com.google.accompanist.pager.ExperimentalPagerApi;
import com.google.accompanist.pager.PagerState;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a8\u0006\u0015"}, d2 = {"Content", "", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "pagerStateCards", "Lcom/example/bookmark/pager/PagerStateCards;", "changeContent", "Lkotlin/Function1;", "", "seeMore", "currentPage", "", "recommended", "", "Lcom/example/data/dto/recommended/RecommendedItem;", "modifier", "Landroidx/compose/ui/Modifier;", "getChapters", "", "setCurrentId", "navigateToNovel", "ui-recomended_debug"})
public final class ContentKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void Content(@org.jetbrains.annotations.NotNull()
    com.google.accompanist.pager.PagerState pagerState, @org.jetbrains.annotations.NotNull()
    com.example.bookmark.pager.PagerStateCards pagerStateCards, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> changeContent, boolean seeMore, int currentPage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.recommended.RecommendedItem> recommended, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> getChapters, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> setCurrentId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToNovel) {
    }
}