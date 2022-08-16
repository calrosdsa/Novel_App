package com.example.data.resultentities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.local.entities.ChapterEntity
import com.example.data.local.entities.NovelImageEntity

data class ChapterAndNovelImage(
    @Embedded val novelImage:NovelImageEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "novelId"
    )
    val chapters:List<ChapterEntity>
)
