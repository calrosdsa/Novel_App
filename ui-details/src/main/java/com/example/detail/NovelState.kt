package com.example.detail

import com.example.data.dto.novel.NovelDetailDto
import com.example.data.dto.chapters.NovelChaptersDto
import com.example.data.dto.reviews.ReviewsDto

data class NovelState(
    val is_loading:Boolean = false,
    val novel: NovelDetailDto? = null,
    val error:String = ""
)

data class NovelChaptersState(
    val chapters:NovelChaptersDto? =  null,
    val is_loading:Boolean = false,
    val error:String = ""
)

data class NovelReviewsState(
    val reviews:ReviewsDto? = null,
    val is_loading: Boolean = false,
    val error: String= ""
)