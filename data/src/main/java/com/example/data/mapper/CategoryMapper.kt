package com.example.data.mapper

import com.example.data.dto.novel.Category
import com.example.data.local.entities.CategoryEntity

fun Category.toCategoryEntity():CategoryEntity{
    return CategoryEntity(
        title = title,
        id = id.toLong()
    )
}