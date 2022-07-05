package com.example.discover

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.api.UiMessageManager
import com.example.data.dto.browse.BrowseDto
import com.example.data.dto.browse.Novel
import com.example.data.remote.ApiService
import com.example.data.util.Constants
import com.example.domain.interactors.UpdateCategory
import com.example.domain.observers.ObserverCategory
import com.example.domain.pagination.NovelBrowsePagination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.domain.useCases.GetBrowseResults
import com.example.domain.util.ObservableLoadingCounter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updateCategory: UpdateCategory,
    private val apiService: ApiService,
    observerCategory: ObserverCategory,
):ViewModel() {
    private val category: String? =  savedStateHandle.get<String>("category")
    private val status: String? =  savedStateHandle.get<String>("status")
    private val ordering: String? =  savedStateHandle.get<String>("ordering")

    private val uiMessageManager = UiMessageManager()
    private val loadingState = ObservableLoadingCounter()
    val filter = MutableStateFlow(FilterState())


    val pagingList:Flow<PagingData<Novel>> = filter.flatMapLatest { filter->
    Pager(
        config = PagingConfig(pageSize = 14, prefetchDistance = 2),
        pagingSourceFactory ={
            NovelBrowsePagination(
                apiService,
                filter.status,
                filter.ordering,
                filter.category,
            )
        }
    ).flow.distinctUntilChanged()
    }.cachedIn(viewModelScope)

    val state:StateFlow<DiscoverState> = combine(
        observerCategory.flow,
        loadingState.observable,
        uiMessageManager.message
    ) { category,loading,message->
        DiscoverState(
            categoryEntity = category,
            loading = loading,
            message = message
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DiscoverState()
    )

    init {
        viewModelScope.launch {
            this@DiscoverViewModel.filter.emit(filter.value.copy(
                status = status?.toInt(),
                ordering = ordering?:"-popular",
                category = category?.toInt()
            )
            )
        }
        getCategories()
        observerCategory(ObserverCategory.Params(20))
        viewModelScope.launch {
          filter.collect{ updatePagingQuery() }
        }

    }
//

    fun setStatus(status:Int){
        val newState = if (status == 1) null else status
        viewModelScope.launch {
            this@DiscoverViewModel.filter.emit(filter.value.copy(status = newState))
        }
    }

    fun setOrdering(ordering: String){
        viewModelScope.launch {
            this@DiscoverViewModel.filter.emit(filter.value.copy(ordering = ordering))
        }
    }

    fun setCategory(category: Int){
        val categorySet = if(category == 0) null else category
        viewModelScope.launch {
            this@DiscoverViewModel.filter.emit(filter.value.copy(category = categorySet))
        }
    }

    private fun updatePagingQuery(){
       FilterState(
           status = filter.value.status,
           ordering = filter.value.ordering,
           category = filter.value.category,
       )
    }

    private fun getCategories(){
        updateCategory(UpdateCategory.Params(Unit))
    }

    fun clearMessage(id:Long){
        viewModelScope.launch {
        uiMessageManager.clearMessage(id)
        }
    }
}