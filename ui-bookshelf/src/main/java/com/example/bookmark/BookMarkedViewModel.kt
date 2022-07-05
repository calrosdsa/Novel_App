package com.example.bookmark

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.data.local.entities.FollowingEntity
import com.example.data.repository.NovelRepository
import com.example.domain.StateRefresh
import com.example.domain.UserAuth
import com.example.domain.interactors.AddOrRemoveNovelFromBookMark
import com.example.domain.interactors.UpdateFollowingNovels
import com.example.domain.interactors.UpdatedOptionsBookMark
import com.example.domain.observers.ObserverFollowings
import com.example.domain.util.NovelOrder
import com.example.domain.util.ObservableLoadingCounter
import com.example.domain.util.collectStatus
import com.example.extensions.combine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class
BookMarkedViewModel @Inject constructor(
    private val novelRepository:NovelRepository,
    private val observerFollowings: ObserverFollowings,
    private val updateFollowingNovels: UpdateFollowingNovels,
    private  val updatedOptionsBookMark: UpdatedOptionsBookMark,
    private val addOrRemoveNovelFromBookMark: AddOrRemoveNovelFromBookMark,
    private val userAuth: UserAuth,
    ) : ViewModel() {
    private val uiMessageManager = UiMessageManager()
    private val loadingState = ObservableLoadingCounter()
    private val option = MutableStateFlow(0)
    private val ordering = MutableStateFlow<NovelOrder?>(null)
    private val filterType = MutableStateFlow<FilterOption?>(null)
    private val currentItem = MutableStateFlow<FollowingEntity?>(null)

    val token:String
        get() = userAuth.tokenValue.token

    val state: StateFlow<FollowingState> = combine(
        loadingState.observable,
        observerFollowings.flow,
        option,
        ordering,
        filterType,
        currentItem,
        uiMessageManager.message,
    ){loading, following,option,ordering,filterType,currentItem,message ->
        FollowingState(
            loading = loading,
            followings = following,
            option = option,
            ordering = ordering,
            filterType = filterType,
            currentItem = currentItem,
            message = message
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = FollowingState()
    )

    init {
        if(userAuth.refresh == StateRefresh.REFRESH){
        getFollowings(true)
            userAuth.refresh = StateRefresh.INITIAL
        }else{
            getFollowings()
        }
        observerFollowings(ObserverFollowings.Params(0,
            ordering.value?:NovelOrder.Updated,))
        viewModelScope.launch {
            option.collect { updateDataSource() }
        }
        viewModelScope.launch {
            ordering.collect { updateDataSource() }
        }
        viewModelScope.launch {
            currentItem.collect { updateDataSource() }
        }
    }


    private fun updateDataSource() {
        observerFollowings(
            ObserverFollowings.Params(
                option = option.value,
                ordering = ordering.value?:NovelOrder.Updated,
  //              orderType = orderType.value?:OrderType.Descending
            )
        )
    }

    fun setCurrentItem(item:FollowingEntity){
        viewModelScope.launch {
            this@BookMarkedViewModel.currentItem.emit(item)
        }
    }

    fun removeNovel(novelId: Int,title:String) {
        viewModelScope.launch {
            addOrRemoveNovelFromBookMark(
                AddOrRemoveNovelFromBookMark.Params(
                    token = token, novelId = novelId, novelTitle = title
                )
            ).collectStatus(loadingState, uiMessageManager)
        }
    }

    fun setAction(novelId:Int,option:Int){
        viewModelScope.launch {
            updatedOptionsBookMark(
                UpdatedOptionsBookMark.Params(
                    token,
                    novelId,
                    option
                )
            ).collectStatus(loadingState,uiMessageManager)
            }
    }

    fun setOption(option:Int){
       viewModelScope.launch {
           this@BookMarkedViewModel.option.emit(option)
       }
    }

    fun setOrdering(novelOrder: NovelOrder){
       viewModelScope.launch {
           this@BookMarkedViewModel.ordering.emit(novelOrder)
       }
    }

    private fun getFollowings(refresh:Boolean = false){
        viewModelScope.launch {
            updateFollowingNovels(
                UpdateFollowingNovels.Params(token,refresh)
            )
                .collectStatus(loadingState,uiMessageManager)
        }
    }

    fun refresh(){
        viewModelScope.launch {
            updateFollowingNovels(
                UpdateFollowingNovels.Params(token, true)
            )
                .collectStatus(loadingState,uiMessageManager)
        }
    }

    fun setFIlter(optionFilter:FilterOption){
         filterType.value = optionFilter
             //FilterOption.Filter<List<String>>(value = listOf("Updated","Favorites","Completed"))
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }

}