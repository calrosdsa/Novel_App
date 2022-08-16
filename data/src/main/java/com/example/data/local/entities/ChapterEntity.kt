package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "chapter_novel",
    )
data class ChapterEntity(
    @PrimaryKey val id:Int,
    val created_at: String,
    val novelId:Int,
//    val novel: Int,
//    val number: Int,
    val slug: String,
    val title: String,
    val chapter: String = "",
)