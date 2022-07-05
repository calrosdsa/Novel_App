package com.example.data.dto.novels

data class NovelsDto(
    val chapters: List<Chapter>,
    val completed: List<Completed>,
    val popular: List<Popular>,
    val posts: List<Post>,
    val rated: List<Rated>,
    val trends: List<Trend>,
    val weekly: List<Weekly>
)