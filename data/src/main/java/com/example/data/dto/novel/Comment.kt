package com.example.data.dto.novel

data class Comment(
    val added_b: String,
    val added_by: Int,
    val body: String,
    val count_likes: Int,
    val count_reply: Int,
    val date_added: String,
    val id: Int,
    val image: String
)