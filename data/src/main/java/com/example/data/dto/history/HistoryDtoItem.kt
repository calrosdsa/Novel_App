package com.example.data.dto.history

data class HistoryDtoItem(
    val chapters: Int,
    val last_chapter: String,
    val last_chapter_slug: String,
    val novel: Int,
    val novel_cover: String,
    val novel_slug: String,
    val novel_title: String,
    val progress: Int,
    val rank: Int,
    val viewed_on: String
)