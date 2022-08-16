package com.example.chapters.indice;

import com.example.data.dto.chapters.Chapter;
import com.example.data.dto.chapters.ChaptersDto;
import com.example.data.dto.chapters.DownLoadChapter;
import com.example.data.resultentities.ChapterAndNovelImage;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u00c6\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/example/chapters/indice/ChaptersState;", "", "loading", "", "message", "Lcom/example/api/UiMessage;", "results", "Lcom/example/data/dto/chapters/ChaptersDto;", "chapters", "", "Lcom/example/data/dto/chapters/DownLoadChapter;", "chapterNovels", "Lcom/example/data/resultentities/ChapterAndNovelImage;", "(ZLcom/example/api/UiMessage;Lcom/example/data/dto/chapters/ChaptersDto;Ljava/util/List;Lcom/example/data/resultentities/ChapterAndNovelImage;)V", "getChapterNovels", "()Lcom/example/data/resultentities/ChapterAndNovelImage;", "getChapters", "()Ljava/util/List;", "getLoading", "()Z", "getMessage", "()Lcom/example/api/UiMessage;", "getResults", "()Lcom/example/data/dto/chapters/ChaptersDto;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "ui-chapters_debug"})
public final class ChaptersState {
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.example.api.UiMessage message = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.dto.chapters.ChaptersDto results = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.example.data.dto.chapters.DownLoadChapter> chapters = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.resultentities.ChapterAndNovelImage chapterNovels = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chapters.indice.ChaptersState copy(boolean loading, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message, @org.jetbrains.annotations.Nullable()
    com.example.data.dto.chapters.ChaptersDto results, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.dto.chapters.DownLoadChapter> chapters, @org.jetbrains.annotations.Nullable()
    com.example.data.resultentities.ChapterAndNovelImage chapterNovels) {
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
    
    public ChaptersState() {
        super();
    }
    
    public ChaptersState(boolean loading, @org.jetbrains.annotations.Nullable()
    com.example.api.UiMessage message, @org.jetbrains.annotations.Nullable()
    com.example.data.dto.chapters.ChaptersDto results, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.dto.chapters.DownLoadChapter> chapters, @org.jetbrains.annotations.Nullable()
    com.example.data.resultentities.ChapterAndNovelImage chapterNovels) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.api.UiMessage getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.chapters.ChaptersDto component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.chapters.ChaptersDto getResults() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.dto.chapters.DownLoadChapter> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.dto.chapters.DownLoadChapter> getChapters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.resultentities.ChapterAndNovelImage component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.resultentities.ChapterAndNovelImage getChapterNovels() {
        return null;
    }
}