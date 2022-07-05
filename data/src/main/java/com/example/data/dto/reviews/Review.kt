package com.example.data.dto.reviews

data class Review(
    val avatar: String,
    val date_added: String,
    val id: Int,
    val like: Int,
    val novel: Int,
    val rating: Int,
    val review: String,
    val user: String
)