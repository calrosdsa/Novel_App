package com.example.data.local.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/data/local/entities/NovelImage;", "Lcom/example/data/local/entities/NovelEntity;", "isPrimary", "", "()Z", "language", "", "getLanguage", "()Ljava/lang/String;", "path", "getPath", "rating", "", "getRating", "()F", "type", "Lcom/example/data/local/entities/ImageType;", "getType", "()Lcom/example/data/local/entities/ImageType;", "data_debug"})
public abstract interface NovelImage extends com.example.data.local.entities.NovelEntity {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getPath();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.entities.ImageType getType();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getLanguage();
    
    public abstract float getRating();
    
    public abstract boolean isPrimary();
}