package com.example.data.dto.reviews

data class ReviewsDto(
    val avg: String,
    val cover: String,
    val id: Int,
    val rank: Int,
    val reviews: List<Review>,
    val slug: String,
    val title: String,
    val update_at: String
)