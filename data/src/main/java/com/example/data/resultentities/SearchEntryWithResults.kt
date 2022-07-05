package com.example.data.resultentities

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.data.local.entities.HistorySearchEntity
import java.util.*
//
//
//class SearchEntryWithResults : EntryWithHistoryResult<SearchEntriesEntity> {
//    @Embedded
//    override lateinit var entry: SearchEntriesEntity
//
//    @Relation(parentColumn = "show_id", entityColumn = "id")
//    override lateinit var relations: List<HistorySearchEntity>
//
//
//
//    override fun equals(other: Any?): Boolean = when {
//        other === this -> true
//        other is SearchEntryWithResults -> {
//            entry == other.entry && relations == other.relations
//        }
//        else -> false
//    }
//
//    override fun hashCode(): Int = Objects.hash(entry, relations)
//}
