package com.example.recommended

import com.example.data.dto.allNovels.Popular
import com.example.data.dto.chapters.NovelChaptersDto
import com.example.data.dto.recommended.Recommended

data class RecommendedState(
    val recommended: Recommended?= null,
    val error:String = "",
    val isLoading:Boolean = false,
    val popular: Popular? = null,
)



data class NovelChaptersState(
    val chapters: NovelChaptersDto? =  null,
    val is_loading:Boolean = false,
    val error:String = ""
)