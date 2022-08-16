package com.example.domain.observers

import com.example.data.local.daos.ChapterDao
import com.example.data.local.entities.ChapterEntity
import com.example.data.resultentities.ChapterAndNovelImage
import com.example.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverChapter @Inject constructor(
    private val chapterDao: ChapterDao
):SubjectInteractor<ObserverChapter.Params, ChapterAndNovelImage>() {


    override fun createObservable(params: Params): Flow<ChapterAndNovelImage> {
       return chapterDao.getAllChaptersById(params.id)
    }

    data class Params(
        val id:Long
    )


}


class ObserverChapters @Inject constructor(
    private val chapterDao: ChapterDao
):SubjectInteractor<ObserverChapters.Params, List<ChapterAndNovelImage>>() {


    override fun createObservable(params: Params): Flow<List<ChapterAndNovelImage>> {
        return chapterDao.getAllChapters()
    }

    data class Params(
        val id:Long
    )
}


class ObserverChapterDetail @Inject constructor(
    private val chapterDao: ChapterDao
):SubjectInteractor<ObserverChapterDetail.Params, ChapterEntity>() {


    override fun createObservable(params: Params): Flow<ChapterEntity> {
        return chapterDao.getChapterBySlug(params.slug)
    }

    data class Params(
        val slug:String
    )

}