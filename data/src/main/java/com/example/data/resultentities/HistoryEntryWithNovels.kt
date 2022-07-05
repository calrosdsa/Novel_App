package com.example.data.resultentities

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.local.entities.HistoryNovelEntry
import com.example.data.local.entities.NovelImageEntity
import java.util.*

class HistoryEntryWithNovels : EntryWithHistoryNovels<HistoryNovelEntry>{
    @Embedded
    override lateinit var entry: HistoryNovelEntry

    @Relation(parentColumn = "novel_id", entityColumn = "id")
    override lateinit var relations: List<HistoryNovelEntity>

    @Relation(parentColumn = "novel_id", entityColumn = "novel_id")
    override lateinit var images: List<NovelImageEntity>

//    @delegate:Ignore
//    override val poster: NovelImageEntity? by lazy(LazyThreadSafetyMode.NONE) {
//        images[0]
//    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is HistoryEntryWithNovels -> {
            entry == other.entry && relations == other.relations && images == other.images
        }
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations, images)

}