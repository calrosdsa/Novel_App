package com.example.data.dto.chapters

data class Chapter(
    val created_at: String,
    val id: Int,
    val novel: Int,
    val number: Int,
    val slug: String,
    val title: String,
    val chapter: String
)