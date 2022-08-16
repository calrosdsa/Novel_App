package com.example.chapters.indice;

import android.util.Log;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.navigation.NavController;
import com.example.data.dto.chapters.ChapterX;
import com.example.data.dto.chapters.NovelX;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.util.Constants;
import com.example.novels.MainDestination;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001aM\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0001\u00a2\u0006\u0002\u0010\u0011\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u00a8\u0006\u0015"}, d2 = {"ChapterIndiceScreen", "", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/example/chapters/indice/ChaptersViewModel;", "ChapterItems", "chapterX", "Lcom/example/data/dto/chapters/ChapterX;", "index", "", "downLoad", "", "selectChapters", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "isSelect", "isDownload", "(Lcom/example/data/dto/chapters/ChapterX;ILandroidx/navigation/NavController;ZLandroidx/compose/runtime/snapshots/SnapshotStateList;ZLjava/lang/Boolean;)V", "NovelInfoChapters", "novel", "Lcom/example/data/dto/chapters/NovelX;", "ui-chapters_debug"})
public final class ChapterIndiceScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ChapterIndiceScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.chapters.indice.ChaptersViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NovelInfoChapters(@org.jetbrains.annotations.NotNull()
    com.example.data.dto.chapters.NovelX novel, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChapterItems(@org.jetbrains.annotations.NotNull()
    com.example.data.dto.chapters.ChapterX chapterX, int index, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, boolean downLoad, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> selectChapters, boolean isSelect, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDownload) {
    }
}