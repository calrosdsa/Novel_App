package com.example.screen.pagination;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import com.example.data.dto.novels.Popular;
import com.example.data.dto.novels.Rated;
import com.example.data.dto.novels.Trend;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001aF\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0001\u00a8\u0006\f"}, d2 = {"RankingNovels", "", "most_views", "", "Lcom/example/data/dto/novels/Popular;", "trends", "Lcom/example/data/dto/novels/Trend;", "rated", "Lcom/example/data/dto/novels/Rated;", "navToNovel", "Lkotlin/Function1;", "", "ui-novels_debug"})
public final class RankingNovelsKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void RankingNovels(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.novels.Popular> most_views, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.novels.Trend> trends, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.novels.Rated> rated, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navToNovel) {
    }
}