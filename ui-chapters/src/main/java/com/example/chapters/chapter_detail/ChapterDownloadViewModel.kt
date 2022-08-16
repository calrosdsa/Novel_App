package com.example.chapters.chapter_detail


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.compose.ui.fonWeightOption
import com.example.data.dto.chapters.SingleChapterDto
import com.example.data.local.daos.ChapterDao
import com.example.data.local.entities.ChapterEntity
import com.example.data.remote.ApiService
import com.example.data.util.Constants
import com.example.domain.observers.ObserverChapter
import com.example.domain.observers.ObserverChapterDetail
import com.example.domain.observers.ObserverChapters
import com.example.domain.resources.Resource
import com.example.domain.util.ObservableLoadingCounter
import com.example.domain.util.collectData
import com.example.extensions.combine
import com.example.settings.AppTheme
import com.example.settings.FontOption
import com.example.settings.UserSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChapterDownloadViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userSettings: UserSettings,
     observerChapterDetail: ObserverChapterDetail,
     observerChapter: ObserverChapter
):ViewModel() {
    private val slug: String? =  savedStateHandle.get<String>(Constants.PARAM_NOVEL_SLUG)
    private val previous = MutableStateFlow<String?>(null)
    private val next = MutableStateFlow<String?>(null)
    private val loadingState = ObservableLoadingCounter()
    private val uiMessageManager = UiMessageManager()
    val brightness = userSettings.brightStream
    val brillo = userSettings.brightness
    val theme = userSettings.themeStream
    val scrollStream = userSettings.scrollStream
    val fontSizeStream = userSettings.fontStream
    val weightStream = userSettings.weightStream
    val state = combine(
        loadingState.observable,
        uiMessageManager.message,
//        chapter,
        observerChapterDetail.flow,
        observerChapter.flow,
        previous,
        next
    ){loading,message,
      download, chapterNovel,
      previous, next->
        ChapterState(
            loading = loading,
            message = message,
//            chapter = chapter,
            chapterDownload = download,
            chapterNovel = chapterNovel,
            previous = previous,
            next = next
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ChapterState(),

        )

    init {
        if(slug!=null){
//            Log.d("CHAPTER_CONTENT", slug)
//            getChapter(slug)
                observerChapterDetail(ObserverChapterDetail.Params(slug))
            viewModelScope.launch {
                observerChapterDetail.flow.collect{
                    observerChapter(ObserverChapter.Params(it.novelId.toLong()))
                }
            }
            viewModelScope.launch {
                state.collect{chapters->
                    val next = chapters.chapterNovel?.chapters?.firstOrNull { it.id > chapters.chapterDownload?.id!! }?.slug
                    val previous = chapters.chapterNovel?.chapters?.lastOrNull() { it.id < chapters.chapterDownload?.id!! }?.slug
                    this@ChapterDownloadViewModel.next.emit(next)
                    this@ChapterDownloadViewModel.previous.emit(previous)
//                    Log.d("CHAPTER_CONTENT", next.toString())
                }
            }
        }
    }

//    private fun getChapter(slug:String){
//        viewModelScope.launch {
//            flow {
//                try {
//                    emit(Resource.Loading())
//                    val result = apiService.getChapterSingle(slug)
//                    Log.d("CHAPTER_CONTENT", result.toString())
//                    emit(Resource.Success(result))
//                }catch (e:Throwable){
//                    Log.d("CHAPTER_CONTENT", e.localizedMessage?:"An unexpected error")
//                    emit(Resource.Error(message = e.localizedMessage?:"An unexpected error"))
//                }
//            }.collectData(loadingState,uiMessageManager,chapter)
//        }
//    }

    fun setBrightness(value:Float){
        userSettings.brightness = value
    }
    fun onChangeMode(value: AppTheme) {
        userSettings.theme = AppTheme.fromOrdinal(value.ordinal)
    }
    fun setScrollSpeed(value:Float){
        userSettings.scrollSpeed = value
    }
    fun setFontSize(value:Float){
        userSettings.fontSizeValue = value
    }
    fun setWeightStream(value: FontOption){
        userSettings.fontWieght = value
    }

}