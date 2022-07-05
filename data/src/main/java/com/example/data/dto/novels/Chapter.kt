package com.example.data.dto.novels

data class Chapter(
    val created_at: String,
    val id: Int,
    val novel_cover: String,
    val novel_slug: String,
    val novel_title: String,
    val slug: String,
    val title: String
)