package com.example.data.repository;

import android.content.Context;
import android.graphics.Bitmap;
import java.time.OffsetDateTime;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/data/repository/NovelUtil;", "", "formatDateOffset", "Ljava/time/OffsetDateTime;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "imageUrl", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface NovelUtil {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getImageBitmap(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.graphics.Bitmap> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object formatDateOffset(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.time.OffsetDateTime> continuation);
}