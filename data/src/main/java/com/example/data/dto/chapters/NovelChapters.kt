package com.example.data.dto.chapters

data class NovelChaptersDto(
    val next: Any,
    val novel: Novel,
    val pages_count: Int,
    val previous: Any,
    val products_count: Int,
    val chapters: List<Chapter>
)