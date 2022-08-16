package com.example.chapters.indice

import android.content.Context
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.data.dto.chapters.ChaptersDto
import com.example.data.dto.chapters.DownLoadChapter
import com.example.data.local.daos.ChapterDao
import com.example.data.local.daos.NovelImageDao
import com.example.data.local.entities.ChapterEntity
import com.example.data.local.entities.NovelImageEntity
import com.example.data.mapper.toChapterEntity
import com.example.data.remote.ApiService
import com.example.data.remote.Ids
import com.example.data.repository.NovelUtil
import com.example.data.util.Constants
import com.example.domain.observers.ObserverChapter
import com.example.domain.resources.Resource
import com.example.domain.util.ObservableLoadingCounter
import com.example.domain.util.collectData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class   ChaptersViewModel @Inject constructor(
      private val apiService: ApiService,
      savedStateHandle: SavedStateHandle,
      private val observerChapters:ObserverChapter,
      private val  novelUtil: NovelUtil,
      @ApplicationContext private val context: Context,
      private val chapterDao: ChapterDao,
      private val novelImageDao: NovelImageDao
):ViewModel() {
    private val slug: String? =  savedStateHandle.get<String>(Constants.PARAM_NOVEL_SLUG)
    private val uiMessageManager = UiMessageManager()
    private val loadingState = ObservableLoadingCounter()
    private val results = MutableStateFlow<ChaptersDto?>(null)
    private val chapters = MutableStateFlow<List<DownLoadChapter>?>(null)


    val state:StateFlow<ChaptersState> = combine(
        loadingState.observable,
        uiMessageManager.message,
        results,
        chapters,
        observerChapters.flow
    ){ loading,message,results, chapters, chapterDownload->
        ChaptersState(
            loading = loading,
            message = message,
            results = results,
            chapters = chapters,
            chapterNovels = chapterDownload
        )
    }.stateIn(
       scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ChaptersState()
    )

    init {
        if(slug!=null){
       getAllChapters(slug)
        }
        viewModelScope.launch {
            results.collect{
                if(it != null){
//                    Log.d("CHAPTER_CONTENT",it.toString())
                    observerChapters(ObserverChapter.Params(it.novel.id.toLong()))
                }
            }
        }
    }


    fun getAllChapters(slug:String){
        viewModelScope.launch {
            flow{
                try{
                emit(Resource.Loading())
                val result = apiService.getAllChapters(slug)
                emit(Resource.Success(data = result))
                }catch (e:Throwable){
                emit(Resource.Error(message = e.localizedMessage?: "An unexpected error"))
                }
            }.collectData(loadingState,uiMessageManager,results)
        }
    }


    fun getAllChapterDownload(ids:List<Int>){
        Log.d("CHAPTER_CONTENT",ids.toString())
        val novel = results.value?.novel
        viewModelScope.launch(Dispatchers.IO) {
            flow{
                try{
                    emit(Resource.Loading())
                    val result = apiService.downloadChapters(Ids(ids))
                    Log.d("CHAPTER_CONTENT",result.toString())
                    emit(Resource.Success(data = result))
                }catch (e:Throwable){
                    e.localizedMessage?.let { Log.d("CHAPTER_CONTENT", it) }
                    emit(Resource.Error(message = e.localizedMessage?: "An unexpected error"))
                }
            }.collectData(loadingState,uiMessageManager,chapters)
//                        delay(1000)
                    if(novel != null){
                    val cover =  novelUtil.getImageBitmap(context,novel.cover)
                    val chapterDownload = chapters.value?.map { it.toChapterEntity() }?: emptyList()
                    chapterDao.insertChapters(chapterDownload)
                    novelImageDao.insert(NovelImageEntity(
                        id = novel.id.toLong(),
                        title = novel.title,
                        chapterCount = novel.chapters,
                        image = cover
                    ))
                    }
        }
    }

    fun isDownload(item:ChapterEntity):Boolean?{
        return state.value.chapterNovels?.chapters?.filter { it.id == item.id }?.first()?.id?.equals(item.id)
    }


}
