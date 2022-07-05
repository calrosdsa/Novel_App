package com.example.bookmark.pagination.pages;

import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import com.example.bookmark.FilterOption;
import com.example.data.local.entities.FollowingEntity;
import com.example.novels.MainDestination;
import com.example.novels.Screen;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001\u001a\u00a0\u0001\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\bH\u0007\u00a8\u0006\u0019"}, d2 = {"FollowingItems", "", "modifier", "Landroidx/compose/ui/Modifier;", "items", "", "Lcom/example/data/local/entities/FollowingEntity;", "setItem", "Lkotlin/Function1;", "visible", "", "navController", "Landroidx/navigation/NavController;", "setVisible", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "ReadingPage", "loading", "setFilterOption", "Lcom/example/bookmark/FilterOption;", "onClick", "Lkotlin/Function0;", "refresh", "token", "", "ui-bookshelf_debug"})
public final class ReadingKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ReadingPage(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean loading, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.data.local.entities.FollowingEntity, kotlin.Unit> setItem, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.lazy.LazyListState lazyListState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.bookmark.FilterOption, kotlin.Unit> setFilterOption, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.FollowingEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> refresh, @org.jetbrains.annotations.NotNull()
    java.lang.String token, boolean visible, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> setVisible) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FollowingItems(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.FollowingEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.data.local.entities.FollowingEntity, kotlin.Unit> setItem, boolean visible, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> setVisible, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.lazy.LazyListState lazyListState) {
    }
}