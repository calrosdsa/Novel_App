package com.example.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.Constants
import com.example.domain.resources.Resource
import com.example.domain.resources.TimeAgo
import com.example.domain.useCases.GetChapters
import com.example.domain.useCases.GetNovelDetail
import com.example.domain.useCases.GetReviews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import javax.inject.Inject


@HiltViewModel
class NovelDetailViewModel @Inject constructor(
    private val getNovel: GetNovelDetail,
    private val getChapters: GetChapters,
    private val getReviews: GetReviews,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private val sdf = SimpleDateFormat("MM-dd-yyyy HH:mm:ss");



 //   private val intentDataStoreAsLiveData
 //           = savedStateHandle.getLiveData<String>(Constants.PARAM_NOVEL_SLUG)
    // Or we can just extract the original form of the data
  //  private val inteData = savedStateHandle.get<String>(Constants.PARAM_NOVEL_SLUG)

    private val _state = mutableStateOf(NovelState())
    val state: State<NovelState> = _state

    private val _stateChapters = mutableStateOf(NovelChaptersState())
    val chapters: State<NovelChaptersState> = _stateChapters

    private val _stateReview = mutableStateOf(NovelReviewsState())
    val reviews: State<NovelReviewsState> = _stateReview


    private val _isRefresh = mutableStateOf(false)
    val isRefresh :State<Boolean> = _isRefresh

    private val slug: String? =  savedStateHandle.get<String>(Constants.PARAM_NOVEL_SLUG)



    init {
        if (slug != null) {
            getNovelDetail(slug)
            getChaptersNovel(slug)
            getReviewsNovel(slug)
        }
    }

    fun refresh(){
        if (slug != null) {
            getNovel(slug).onEach { result ->
                when(result){
                    is Resource.Success->{
                        _state.value = NovelState(novel=result.data)
                        _isRefresh.value = false
                    }
                    is Resource.Loading->{
                        _isRefresh.value = true
                    }
                    is Resource.Error->{
                        _state.value = NovelState(error = result.message?:"An expected error occurred")
                        _isRefresh.value = false


                    }
                } }.launchIn(viewModelScope)
        }
    }


    private fun getNovelDetail(novelSlug:String){
        getNovel(novelSlug).onEach { result ->
            when(result){
                is Resource.Success->{
                    delay(300)
                    _state.value = NovelState(novel = result.data)
                }
                is Resource.Loading->{
                    _state.value = NovelState(is_loading = true)
                }
                is Resource.Error->{
                    _state.value = NovelState(error = result.message?:"An expected error ocurred")

                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getChaptersNovel(novelSlug:String){
        getChapters(novelSlug).onEach { result ->
            when(result){
                is Resource.Success->{
                    _stateChapters.value = NovelChaptersState(chapters = result.data)
                }
                is Resource.Loading->{
                    _stateChapters.value = NovelChaptersState(is_loading = true)
                }
                is Resource.Error->{
                    _stateChapters.value = NovelChaptersState(error = result.message?:"An expected error ocurred")

                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getReviewsNovel(novelSlug:String){
        getReviews(novelSlug).onEach { result ->
            when(result){
                is Resource.Success->{
                    _stateReview.value = NovelReviewsState(reviews = result.data)
                }
                is Resource.Loading->{
                    _stateReview.value = NovelReviewsState(is_loading = true)
                }
                is Resource.Error->{
                    _stateReview.value = NovelReviewsState(error = result.message?:"An expected error ocurred")

                }
            }
        }.launchIn(viewModelScope)
    }

    fun formatDate(date: String): String? {
        return TimeAgo.getTimeAgo(date) ?: "January ,04"
    }

}