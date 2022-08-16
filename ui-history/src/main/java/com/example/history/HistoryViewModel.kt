package com.example.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.data.dto.history.HistoryDtoItem
import com.example.data.remote.ApiService
import com.example.domain.UserAuth
import com.example.domain.observers.ObservableHistoryNovels
import com.example.domain.pagination.NovelHistoryPagination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@HiltViewModel
class HistoryViewModel @Inject constructor(
       private val apiService: ApiService,
       private val auth: UserAuth,
    pagingInteractor: ObservableHistoryNovels,
):ViewModel() {
     val pager:Flow<PagingData<HistoryDtoItem>> = Pager(
         config = PagingConfig(20,2 ),
         pagingSourceFactory = { NovelHistoryPagination(apiService = apiService,auth =auth) }
     ).flow.cachedIn(viewModelScope)
//    val pager: Flow<PagingData<HistoryEntryWithNovels>> =
//        pagingInteractor.flow.cachedIn(viewModelScope)

    init {
        pagingInteractor(ObservableHistoryNovels.Params(PAGING_CONFIG))
    }

    companion object {
        val PAGING_CONFIG = PagingConfig(
            pageSize =20,
            prefetchDistance = 4,
            initialLoadSize = 20,
        )
    }
}