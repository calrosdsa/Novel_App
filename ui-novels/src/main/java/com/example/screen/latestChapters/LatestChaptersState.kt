package com.example.screen.latestChapters

import com.example.data.dto.chaptersLatest.Result

data class LatestChaptersState (
    val chapters : List<Result> = emptyList(),
    val is_loading: Boolean = false,
    val error:String = ""
)

