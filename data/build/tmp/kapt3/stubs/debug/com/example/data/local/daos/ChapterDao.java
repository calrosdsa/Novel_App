package com.example.data.local.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import com.example.data.local.entities.ChapterEntity;
import com.example.data.resultentities.ChapterAndNovelImage;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u000eH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0016\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/data/local/daos/ChapterDao;", "", "()V", "deleteChapters", "", "ids", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteImage", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllChapters", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/data/resultentities/ChapterAndNovelImage;", "getAllChaptersById", "getChapterBySlug", "Lcom/example/data/local/entities/ChapterEntity;", "slug", "", "insertChapters", "chapters", "data_debug"})
public abstract class ChapterDao {
    
    public ChapterDao() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM novel_images")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.data.resultentities.ChapterAndNovelImage>> getAllChapters();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM novel_images WHERE id = :id")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.resultentities.ChapterAndNovelImage> getAllChaptersById(long id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM chapter_novel WHERE slug = :slug")
    public abstract kotlinx.coroutines.flow.Flow<com.example.data.local.entities.ChapterEntity> getChapterBySlug(@org.jetbrains.annotations.NotNull()
    java.lang.String slug);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertChapters(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.local.entities.ChapterEntity> chapters);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM chapter_novel WHERE id in (:ids)")
    public abstract java.lang.Object deleteChapters(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> ids, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM novel_images WHERE id = :id")
    public abstract java.lang.Object deleteImage(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}