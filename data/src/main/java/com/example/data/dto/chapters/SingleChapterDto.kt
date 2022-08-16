package com.example.data.dto.chapters

data class SingleChapterDto(
    val chapter: String,
    val created_at: String,
    val id: Int,
    val next: Next?,
    val novel: Int,
    val novel_slug: String,
    val novel_title: String,
    val previous: Previous?,
    val title: String
)