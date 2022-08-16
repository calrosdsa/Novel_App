package com.example.screen;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import androidx.paging.LoadState;
import com.example.data.dto.novels.Completed;
import com.example.novels.MainDestination;
import com.example.novels.Screen;
import com.example.screen.novels.NovelsViewModel;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u001a$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "ListGridNovel", "", "novels", "", "Lcom/example/data/dto/novels/Completed;", "NovelPage", "navController", "Landroidx/navigation/NavController;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/example/screen/novels/NovelsViewModel;", "ui-novels_debug"})
public final class NovelPageKt {
    private static final androidx.compose.foundation.shape.RoundedCornerShape shape = null;
    
    @androidx.compose.runtime.Composable()
    public static final void NovelPage(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.screen.novels.NovelsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ListGridNovel(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.dto.novels.Completed> novels) {
    }
}