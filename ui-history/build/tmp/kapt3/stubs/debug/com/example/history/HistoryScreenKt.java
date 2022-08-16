package com.example.history;

import android.util.Log;
import android.widget.Toast;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.paging.LoadState;
import com.example.data.dto.history.HistoryDtoItem;
import com.example.novels.MainDestination;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\u001a\u001a\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"HistoryNovelItem", "", "item", "Lcom/example/data/dto/history/HistoryDtoItem;", "getDate", "Lkotlin/Function0;", "", "navToNovel", "navToChapter", "HistoryNovelScreen", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/example/history/HistoryViewModel;", "bodyWidth", "Landroidx/compose/ui/Modifier;", "ui-history_debug"})
public final class HistoryScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HistoryNovelScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.history.HistoryViewModel viewModel) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.Modifier bodyWidth(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier $this$bodyWidth) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HistoryNovelItem(@org.jetbrains.annotations.NotNull()
    com.example.data.dto.history.HistoryDtoItem item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.lang.CharSequence> getDate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navToNovel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navToChapter) {
    }
}