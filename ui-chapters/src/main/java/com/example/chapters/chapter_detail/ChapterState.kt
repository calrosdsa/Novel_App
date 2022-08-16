package com.example.chapters.chapter_detail

import com.example.api.UiMessage
import com.example.data.dto.chapters.SingleChapterDto
import com.example.data.local.entities.ChapterEntity
import com.example.data.resultentities.ChapterAndNovelImage

data class ChapterState(
    val chapter: SingleChapterDto? = null,
    val chapterDownload:ChapterEntity? = null,
    val chapterNovel:ChapterAndNovelImage? = null,
    val loading:Boolean = false,
    val message: UiMessage? = null,
    val previous:String? = null,
    val next:String? = null
)
