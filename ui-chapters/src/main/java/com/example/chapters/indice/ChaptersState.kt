package com.example.chapters.indice

import com.example.api.UiMessage
import com.example.data.dto.chapters.Chapter
import com.example.data.dto.chapters.ChaptersDto
import com.example.data.dto.chapters.DownLoadChapter
import com.example.data.resultentities.ChapterAndNovelImage

data class ChaptersState(
    val loading:Boolean = false,
    val message:UiMessage? = null,
    val results: ChaptersDto? = null,
    val chapters:List<DownLoadChapter>? = null,
    val chapterNovels:ChapterAndNovelImage? = null,
)


data class ChapterDownloadState(
    val chapterNovels:ChapterAndNovelImage? = null,
    )
