package com.example.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.room.TypeConverter;
import com.example.data.local.entities.Request;
import com.google.gson.Gson;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import java.io.ByteArrayOutputStream;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bH\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001a\u001a\u00020\u0017H\u0007J\u0016\u0010\u001e\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000eH\u0007J\u0019\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0007\u00a2\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006%"}, d2 = {"Lcom/example/data/Converters;", "", "()V", "formatter", "Lorg/threeten/bp/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "requestValues", "", "Lcom/example/data/local/entities/Request;", "getRequestValues", "()[Lcom/example/data/local/entities/Request;", "requestValues$delegate", "Lkotlin/Lazy;", "fromBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "fromInstant", "", "date", "Lorg/threeten/bp/Instant;", "(Lorg/threeten/bp/Instant;)Ljava/lang/Long;", "fromOffsetDateTime", "", "Lorg/threeten/bp/OffsetDateTime;", "fromRequest", "value", "jsonStringToList", "", "", "listToJsonString", "toBitmap", "byteArray", "toInstant", "(Ljava/lang/Long;)Lorg/threeten/bp/Instant;", "toOffsetDateTime", "toRequest", "data_debug"})
public final class Converters {
    private final org.threeten.bp.format.DateTimeFormatter formatter = null;
    private final kotlin.Lazy requestValues$delegate = null;
    
    public Converters() {
        super();
    }
    
    private final com.example.data.local.entities.Request[] getRequestValues() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final org.threeten.bp.OffsetDateTime toOffsetDateTime(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String fromOffsetDateTime(@org.jetbrains.annotations.Nullable()
    org.threeten.bp.OffsetDateTime date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final org.threeten.bp.Instant toInstant(@org.jetbrains.annotations.Nullable()
    java.lang.Long value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.Long fromInstant(@org.jetbrains.annotations.Nullable()
    org.threeten.bp.Instant date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromRequest(@org.jetbrains.annotations.NotNull()
    com.example.data.local.entities.Request value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final com.example.data.local.entities.Request toRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String listToJsonString(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.util.List<java.lang.Integer> jsonStringToList(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final byte[] fromBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final android.graphics.Bitmap toBitmap(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
}