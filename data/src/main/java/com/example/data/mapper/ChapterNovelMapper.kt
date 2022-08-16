package com.example.data.mapper

import androidx.room.PrimaryKey
import com.example.data.dto.chapters.ChapterX
import com.example.data.dto.chapters.DownLoadChapter
import com.example.data.local.entities.ChapterEntity

fun DownLoadChapter.toChapterEntity():ChapterEntity{
    return ChapterEntity(
         id = id,
         created_at = created_at,
        novelId = novelId,
        slug = slug,
        title = title,
        chapter = chapter
    )
}


fun ChapterX.toChapterEntity():ChapterEntity{
    return ChapterEntity(
        id = id,
        created_at = created_at,
        novelId = novelId,
        slug = slug,
        title = title,
        chapter = title
    )
}