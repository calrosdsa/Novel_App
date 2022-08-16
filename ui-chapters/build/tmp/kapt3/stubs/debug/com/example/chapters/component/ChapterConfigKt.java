package com.example.chapters.component;

import android.view.Window;
import android.view.WindowManager;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.example.settings.AppTheme;
import com.example.settings.FontOption;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u00c4\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a&\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u00a8\u0006\u001d"}, d2 = {"ChapterSheetModal", "", "_window", "Landroid/view/Window;", "brightStream", "Lkotlinx/coroutines/flow/StateFlow;", "", "setBrightness", "Lkotlin/Function1;", "setTheme", "Lcom/example/settings/AppTheme;", "currentTheme", "autoScroll", "Lkotlin/Function0;", "setScrollSpeed", "scroll", "fontSize", "setFontSize", "showChapters", "setFontWeight", "Lcom/example/settings/FontOption;", "fontWeightValue", "Landroidx/compose/ui/text/font/FontWeight;", "RowItemChapter", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "", "onClick", "ui-chapters_debug"})
public final class ChapterConfigKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ChapterSheetModal(@org.jetbrains.annotations.NotNull()
    android.view.Window _window, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<java.lang.Float> brightStream, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> setBrightness, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.settings.AppTheme, kotlin.Unit> setTheme, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<? extends com.example.settings.AppTheme> currentTheme, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> autoScroll, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> setScrollSpeed, float scroll, float fontSize, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> setFontSize, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> showChapters, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.settings.FontOption, kotlin.Unit> setFontWeight, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.text.font.FontWeight fontWeightValue) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RowItemChapter(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector imageVector, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}