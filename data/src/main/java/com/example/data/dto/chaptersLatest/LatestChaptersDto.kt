package com.example.data.dto.chaptersLatest

data class LatestChaptersDto(
    val current: Int,
    val next: String,
    val pages_count: Int,
    val previous: Any,
    val results: List<Result>,
    val title: Any
)