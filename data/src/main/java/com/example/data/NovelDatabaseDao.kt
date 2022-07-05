package com.example.data

import com.example.data.local.daos.*

interface NovelDatabaseDao {
    fun showHistorySearch(): HistoryDao
    fun showFollowings():FollowingDao
    fun showCategories():CategoryDao
    fun lastRequestDao(): LastRequestDao
    fun historyNovelsDao(): HistoryNovelDao
    fun novelHistoryDao():NovelHistoryDao
    fun novelImageDao():NovelImageDao

}