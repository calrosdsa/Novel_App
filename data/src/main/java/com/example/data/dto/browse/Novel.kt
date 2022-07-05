package com.example.data.dto.browse

import com.google.gson.annotations.SerializedName

data class Novel(
    val average: Double,
    val chapters: Int,
    @SerializedName("comentarios") val comments: Int,
    val cover: String,
    val id: Int,
    val rank: Int,
    val reviews: Int,
    val slug: String,
    val status_name: String,
    val title: String,
    val updated: String
)