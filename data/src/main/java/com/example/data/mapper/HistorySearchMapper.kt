package com.example.data.mapper

import com.example.data.dto.searchNovel.ResultSearch
import com.example.data.local.entities.HistorySearchEntity

fun ResultSearch.toHistorySearchEntity():HistorySearchEntity{
    return HistorySearchEntity(
        title = title,
        slug = slug,
        label = label,
    )
}

