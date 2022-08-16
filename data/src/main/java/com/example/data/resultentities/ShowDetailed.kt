package com.example.data.resultentities

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.local.entities.NovelImageEntity
import java.util.*

class HistoryDetailed {
    @Embedded
    lateinit var show: HistoryNovelEntity

    @Relation(parentColumn = "id", entityColumn = "novel_id")
    lateinit var images: List<NovelImageEntity>

//    @delegate:Ignore
//    val backdrop: NovelImageEntity? by lazy(LazyThreadSafetyMode.NONE) {
//        images[0]
//    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is HistoryDetailed -> show == other.show && images == other.images
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(show, images)
}
