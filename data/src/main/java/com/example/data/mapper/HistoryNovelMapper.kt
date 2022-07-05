package com.example.data.mapper

import com.example.data.dto.history.HistoryDtoItem
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.util.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryDtoToHistoryEntity @Inject constructor(): Mapper<HistoryDtoItem , HistoryNovelEntity> {
    override suspend fun map(from: HistoryDtoItem) =  HistoryNovelEntity(
        id = from.novel.toLong(),
        chapters = from.chapters,
     last_chapter = from.last_chapter,
     last_chapter_slug = from.last_chapter_slug,
     novel_cover = from.novel_cover,
     novel_title = from.novel_title,
     progress = from.progress,
     rank = from.rank,
     viewed_on = from.viewed_on,
        novel_slug = from.novel_slug
    )
}

fun HistoryDtoItem.toHistoryNovel():HistoryNovelEntity{
    return HistoryNovelEntity(
        id = novel.toLong(),
        chapters = chapters,
        last_chapter = last_chapter,
        last_chapter_slug = last_chapter_slug,
        novel_cover = novel_cover,
        novel_title = novel_title,
        progress = progress,
        rank = rank,
        viewed_on = viewed_on,
        novel_slug = novel_slug
    )
}






//fun HistoryDtoItem.toHistoryNovelEntity():HistoryNovelEntity{
//    return HistoryNovelEntity(
//        id = novel.toLong(),
//        chapters = chapters,
//     last_chapter = last_chapter,
//     last_chapter_slug = last_chapter_slug,
//     novel_cover = novel_cover,
//     novel_title = novel_title,
//     progress = progress,
//     rank = rank,
//     viewed_on = viewed_on,
//        novel_slug = novel_slug
//    )
//}