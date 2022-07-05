package com.example.screen.latestChapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.dto.chaptersLatest.Result
import com.example.domain.pagination.NovelPaginationImpl
import com.example.data.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@HiltViewModel
class LatestChaptersViewModel @Inject constructor(
    private val apiService: ApiService
):ViewModel() {

    val pager : Flow<PagingData<Result>> = Pager(
        config = PagingConfig(20,5 ),
        pagingSourceFactory = { NovelPaginationImpl(apiService = apiService) }
    ).flow.cachedIn(viewModelScope)



}