package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(
    tableName = "novel_history"
)
data class HistoryNovelEntity(
    @PrimaryKey  override val id: Long = 0,
    val chapters: Int,
    val last_chapter: String,
    val last_chapter_slug: String,
    val novel_cover: String,
    val novel_slug: String,
    val novel_title: String,
    val progress: Int,
    val rank: Int,
    val viewed_on: String,
):NovelEntity