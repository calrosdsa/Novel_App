package com.example.data.mapper

import com.example.data.dto.novels.Completed
import com.example.data.dto.novels.Post
import com.example.data.dto.novels.Weekly


fun Completed.toNovelItem(): NovelItem {
    return NovelItem(average, chapters, cover, id, rank, slug, title)
}


fun Post.toNovelItem(): NovelItem {
    return NovelItem(average, chapters, cover, id, rank, slug, title)
}

fun Weekly.toNovelItem(): NovelItem {
    return NovelItem(average, chapters, cover, id, rank, slug, title)
}


data class NovelItem(
    val average: Double,
    val chapters: Int,
    val cover: String,
    val id: String,
    val rank: Double,
    val slug: String,
    val title: String
)