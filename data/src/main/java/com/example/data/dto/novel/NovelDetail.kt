package com.example.data.dto.novel

data class NovelDetailDto(
    val authors: String,
    val average: Double,
    val book_marked: List<Any>,
    val category: List<Category>,
    val chapters: Int,
    val comments: List<Comment>,
    val cover: String,
    val created: String,
    val description: String,
    val first: First,
    val id: Int,
    val novel_views: Int,
    val rank: Int,
    val reviews: Int,
    val slug: String,
    val statuss: String,
    val sub: String,
    val sumary: String,
    val tags: List<Tag>,
    val title: String,
    val updated: String,
    val user: List<Any>
)