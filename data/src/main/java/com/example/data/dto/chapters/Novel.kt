package com.example.data.dto.chapters

import com.google.gson.annotations.SerializedName

data class Novel(
    val chapters: Int,
    val cover: String,
    val id: Int,
    val rank: Int,
    val slug: String,
    //@SerializedName("statuss")
    val statuss: String,
    val title: String,
    val updated: String,
)