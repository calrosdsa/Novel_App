package com.example.data.resultentities

import com.example.data.local.entities.ChapterEntity
import com.example.data.local.entities.Entry
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.local.entities.NovelImageEntity
import java.util.Objects

//interface EntryWithHistoryResult<ET : Entry> {
//    var entry: ET
//    var relations: List<HistorySearchEntity>
//
//    val history: HistorySearchEntity
//        get() {
//            check(relations.size == 1)
//            return relations[0]
//        }
//
//
//    fun generateStableId(): Long {
//        return Objects.hash(entry::class.java.name, entry.novelId).toLong()
//    }
//}

interface EntryWithHistoryNovels<ET : Entry> {
    var entry: ET
    var relations: List<HistoryNovelEntity>
    var images: List<NovelImageEntity>


    val novel: HistoryNovelEntity
        get() {
            check(relations.size == 1)
            return relations[0]
        }
//    val poster: NovelImageEntity?


    fun generateStableId(): Long {
        return Objects.hash(entry::class.java.name, entry.novelId).toLong()
    }
}


