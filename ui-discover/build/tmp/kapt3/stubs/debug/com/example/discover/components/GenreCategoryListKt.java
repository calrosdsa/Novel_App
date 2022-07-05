package com.example.discover.components;

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import com.example.data.dto.novel.Category;
import com.example.data.local.entities.CategoryEntity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0001\u001a9\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0001\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"BoxSelectOption", "", "setCategory", "Lkotlin/Function1;", "", "id", "", "title", "", "current", "GenreCategoryList", "categories", "", "Lcom/example/data/local/entities/CategoryEntity;", "currentCategory", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "ui-discover_debug"})
public final class GenreCategoryListKt {
    
    @androidx.compose.runtime.Composable()
    public static final void GenreCategoryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.CategoryEntity> categories, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> setCategory, @org.jetbrains.annotations.Nullable()
    java.lang.Integer currentCategory) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BoxSelectOption(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> setCategory, long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int current) {
    }
}