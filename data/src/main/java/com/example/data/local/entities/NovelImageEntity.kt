package com.example.data.local.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName ="novel_images",
    indices = [
        Index(value = ["novel_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = HistoryNovelEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("novel_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class NovelImageEntity(
    @PrimaryKey override val id: Long = 0,
    @ColumnInfo(name = "novel_id") val novelId: Long,
    val image:Bitmap
):NovelEntity
