package com.example.data.local.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.example.data.local.entities.PaginatedEntry
import com.example.data.resultentities.EntryWithHistoryNovels

//abstract class PaginatedEntryDao<EC : PaginatedEntry, LI : EntryWithHistoryResult<EC>> : EntryDao<EC, LI>() {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract override suspend fun insert(entity: EC): Long
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract override suspend fun insertAll(vararg entity: EC)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract override suspend fun insertAll(entities: List<EC>)
//
//    abstract suspend fun deletePage(page: Int)
//    abstract suspend fun getLastPage(): Int?
//
//    @Transaction
//    open suspend fun updatePage(page: Int, entities: List<EC>) {
//        deletePage(page)
//        insertAll(entities)
//    }
//}
abstract class PaginatedNovelsEntryDao<EC : PaginatedEntry, LI : EntryWithHistoryNovels<EC>> : EntryDao<EC, LI>() {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: EC):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insertAll(vararg entity: EC)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insertAll(entities: List<EC>)

    abstract suspend fun deletePage(page: Int)
    abstract suspend fun getLastPage(): Int?

    @Transaction
    open suspend fun updatePage(page: Int, entities: List<EC>) {
        deletePage(page)
        insertAll(entities)
    }
}