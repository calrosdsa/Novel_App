package com.example.data.dto.novels

data class Rated(
    val average: Double,
    val cover: String,
    val reviews: Int,
    val slug: String,
    val title: String
)