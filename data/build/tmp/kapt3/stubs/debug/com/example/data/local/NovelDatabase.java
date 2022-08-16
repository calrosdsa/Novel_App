package com.example.data.local;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.data.util.Converters;
import com.example.data.NovelDatabaseDao;
import com.example.data.local.entities.*;

@androidx.room.TypeConverters(value = {com.example.data.util.Converters.class})
@androidx.room.Database(entities = {com.example.data.local.entities.HistorySearchEntity.class, com.example.data.local.entities.FollowingEntity.class, com.example.data.local.entities.CategoryEntity.class, com.example.data.local.entities.LastRequest.class, com.example.data.local.entities.HistoryNovelEntry.class, com.example.data.local.entities.HistoryNovelEntity.class, com.example.data.local.entities.NovelImageEntity.class, com.example.data.local.entities.ChapterEntity.class}, version = 2, autoMigrations = {@androidx.room.AutoMigration(from = 1, to = 2)})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001\u0004B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/local/NovelDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/example/data/NovelDatabaseDao;", "()V", "Companion", "data_debug"})
public abstract class NovelDatabase extends androidx.room.RoomDatabase implements com.example.data.NovelDatabaseDao {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.data.local.NovelDatabase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "novel.db";
    
    public NovelDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/data/local/NovelDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}