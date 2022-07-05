package com.example.data.dto.library

data class Result(
    val added: String,
    val chapters: Int,
    val cover: String,
    val id: Int,
    val options: List<Int>,
    val progress: Int,
    val slug: String,
    val title: String,
    val updated: String
)