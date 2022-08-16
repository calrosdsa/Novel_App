package com.example.chapters.chapter_detail;

import com.example.data.dto.chapters.SingleChapterDto;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.resultentities.ChapterAndNovelImage;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rH\u00c6\u0003J[\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\rH\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/example/chapters/chapter_detail/ChapterState;", "", "chapter", "Lcom/example/data/dto/chapters/SingleChapterDto;", "chapterDownload", "Lcom/example/data/local/entities/ChapterEntity;", "chapterNovel", "Lcom/example/data/resultentities/ChapterAndNovelImage;", "loading", "", "message", "Lcom/example/api/UiMessage;", "previous", "", "next", "(Lcom/example/data/dto/chapters/SingleChapterDto;Lcom/example/data/local/entities/ChapterEntity;Lcom/example/data/resultentities/ChapterAndNovelImage;ZLcom/example/api/UiMessage;Ljava/lang/String;Ljava/lang/String;)V", "getChapter", "()Lcom/example/data/dto/chapters/SingleChapterDto;", "getChapterDownload", "()Lcom/example/data/local/entities/ChapterEntity;", "getChapterNovel", "()Lcom/example/data/resultentities/ChapterAndNovelImage;", "getLoading", "()Z", "getMessage", "()Lcom/example/api/UiMessage;", "getNext", "()Ljava/lang/String;", "getPrevious", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "ui-chapters_debug"})
public final class ChapterState {
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.dto.chapters.SingleChapterDto chapter = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.local.entities.ChapterEntity chapterDownload = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.resultentities.ChapterAndNovelImage chapterNovel = null;
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.example.api.UiMessage message = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String previous = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String next = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chapters.chapter_detail.ChapterState copy(@org.jetbrains.annotations.Nullable()
    com.example.data.dto.chapters.SingleChapterDto chapter, @org.jetbrains.annotations.Nullable()
    com.example.data.local.entities.ChapterEntity chapterDownload, @org.jetbrains.annotations.Nullable()
    com.example.data.resultentities.ChapterAndNovelImage chapterNovel, boolean loading, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message, @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @org.jetbrains.annotations.Nullable()
    java.lang.String next) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ChapterState() {
        super();
    }
    
    public ChapterState(@org.jetbrains.annotations.Nullable()
    com.example.data.dto.chapters.SingleChapterDto chapter, @org.jetbrains.annotations.Nullable()
    com.example.data.local.entities.ChapterEntity chapterDownload, @org.jetbrains.annotations.Nullable()
    com.example.data.resultentities.ChapterAndNovelImage chapterNovel, boolean loading, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message, @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @org.jetbrains.annotations.Nullable()
    java.lang.String next) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.chapters.SingleChapterDto component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.chapters.SingleChapterDto getChapter() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.local.entities.ChapterEntity component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.local.entities.ChapterEntity getChapterDownload() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.resultentities.ChapterAndNovelImage component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.resultentities.ChapterAndNovelImage getChapterNovel() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrevious() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNext() {
        return null;
    }
}