package com.example.data.dto.browse

data class BrowseDto(
    val category_: Any,
    val current: Int,
    val next: Any,
    val novels: List<Novel>,
    val ordering: Any,
    val pages_count: Int,
    val previous: Any,
    val products_count: Int,
    val status: List<Statu>,
    val status_: String
)