package com.example.data.dto.novels

data class Popular(
    val chapter_count: Int,
    val cover: String,
    val id: Int,
    val markeds: Int,
    val novel_views: Int,
    val slug: String,
    val title: String
)