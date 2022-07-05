package com.example.data.dto.searchNovel

data class SearchNovelDto(
    val current: Int,
    val next: String,
    val pages_count: Int,
    val previous: Any,
    val results: List<ResultSearch>,
    val title: Any
)