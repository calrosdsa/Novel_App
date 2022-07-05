package com.example.search.pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.local.entities.HistorySearchEntity
import com.example.domain.observers.ObserverPagedHistorySearch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HistorySearchViewModel @Inject constructor(
       pagingInteractor: ObserverPagedHistorySearch
) : ViewModel(){
    val pagedList: Flow<PagingData<HistorySearchEntity>> =
        pagingInteractor.flow.cachedIn(viewModelScope)

    init {
        pagingInteractor(ObserverPagedHistorySearch.Params(PAGING_CONFIG))
    }

    companion object {
        val PAGING_CONFIG = PagingConfig(
            pageSize = 15,
            initialLoadSize = 15
        )
    }
}