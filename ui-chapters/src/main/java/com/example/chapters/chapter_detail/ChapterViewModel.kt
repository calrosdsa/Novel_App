package com.example.chapters.chapter_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.data.dto.chapters.SingleChapterDto
import com.example.data.remote.ApiService
import com.example.data.util.Constants
import com.example.domain.resources.Resource
import com.example.domain.util.ObservableLoadingCounter
import com.example.domain.util.collectData
import com.example.settings.AppTheme
import com.example.settings.FontOption
import com.example.settings.UserSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChapterViewModel @Inject constructor(
     private val apiService: ApiService,
     savedStateHandle: SavedStateHandle,
     private val userSettings: UserSettings,
//     private val auth: UserAuth
//     observerChapterDetail: ObserverChapterDetail,
//     observerChapter: ObserverChapter
):ViewModel() {
//    private val token :String
//    get() = auth.tokenValue.token
    private val slug: String? =  savedStateHandle.get<String>(Constants.PARAM_NOVEL_SLUG)
    private val chapter = MutableStateFlow<SingleChapterDto?>(null)
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
        chapter,
//        observerChapterDetail.flow,
//        observerChapter.flow,
        previous,
        next
    ){loading,message,chapter,
//      download, chapterNovel,
      previous, next->
        ChapterState(
            loading = loading,
            message = message,
            chapter = chapter,
//            chapterDownload = download,
//            chapterNovel = chapterNovel,
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
            Log.d("CHAPTER_CONTENT", slug)
//            Log.d("CHAPTER_CONTENT", "tokenn $token")
            getChapter(slug)
        }
    }

    private fun getChapter(slug:String){
       viewModelScope.launch {
           flow {
               try {
                   emit(Resource.Loading())
                   val result = apiService.getChapterSingle(slug)
                   Log.d("CHAPTER_CONTENT", result.toString())
                   emit(Resource.Success(result))
               }catch (e:Throwable){
                   Log.d("CHAPTER_CONTENT", e.localizedMessage?:"An unexpected error")
                   emit(Resource.Error(message = e.localizedMessage?:"An unexpected error"))
               }
           }.collectData(loadingState,uiMessageManager,chapter)
       }
    }

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