package com.example.data;

import com.example.data.local.daos.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/data/NovelDatabaseDao;", "", "historyNovelsDao", "Lcom/example/data/local/daos/HistoryNovelDao;", "lastRequestDao", "Lcom/example/data/local/daos/LastRequestDao;", "novelHistoryDao", "Lcom/example/data/local/daos/NovelHistoryDao;", "novelImageDao", "Lcom/example/data/local/daos/NovelImageDao;", "showCategories", "Lcom/example/data/local/daos/CategoryDao;", "showFollowings", "Lcom/example/data/local/daos/FollowingDao;", "showHistorySearch", "Lcom/example/data/local/daos/HistoryDao;", "data_debug"})
public abstract interface NovelDatabaseDao {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.HistoryDao showHistorySearch();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.FollowingDao showFollowings();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.CategoryDao showCategories();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.LastRequestDao lastRequestDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.HistoryNovelDao historyNovelsDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.NovelHistoryDao novelHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.data.local.daos.NovelImageDao novelImageDao();
}