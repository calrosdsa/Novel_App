package com.example.chapters.indice

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.daos.ChapterDao
import com.example.data.local.daos.NovelImageDao
import com.example.data.util.Constants
import com.example.domain.observers.ObserverChapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DownloadIndiceViewModel @Inject constructor(
    observerChapter: ObserverChapter,
    savedStateHandle: SavedStateHandle,
    private val chapterDao: ChapterDao,
    private val imageDao: NovelImageDao
):ViewModel() {
    private val id: String? =  savedStateHandle.get<String>(Constants.PARAM_CHAPTER)

    val state:StateFlow<ChapterDownloadState> = combine(
        observerChapter.flow
    ){chapterNovel->
        ChapterDownloadState(
            chapterNovels = chapterNovel[0]
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ChapterDownloadState()
    )

    init {
        if(id != null){
        observerChapter(ObserverChapter.Params(id.toLong()))
        }
    }
    fun deleteChapters(ids:List<Int>?,id:Long?){
        Log.d("CHAPTER_CONTENT",ids.toString())
            viewModelScope.launch {
                if (ids != null && id != null) {
                    chapterDao.deleteChapters(ids)
                    chapterDao.deleteImage(id)
                }
            }
    }
}