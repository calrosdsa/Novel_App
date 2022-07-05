package com.example.data.dto.recommended

data class RecommendedItem(
    val average: Double,
    val cover: String,
    val id: Int,
    val rank: Double,
    val slug: String,
    val sumary: String,
    val title: String
)