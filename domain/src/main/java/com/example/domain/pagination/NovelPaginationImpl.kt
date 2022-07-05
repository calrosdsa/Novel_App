package com.example.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.dto.chaptersLatest.Result
import com.example.data.remote.ApiService
import javax.inject.Inject

class NovelPaginationImpl @Inject constructor(
    private val apiService: ApiService
): PagingSource<Int, Result>()  {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return  try {
            val prev = params.key ?: 1
            val response = apiService.getLatestChapters(prev)
            if (response.isSuccessful){

            val body = response.body()?.results
            LoadResult.Page(
                data = body!!,
                prevKey = if (prev == 1) null else prev - 1,
                nextKey = if (body.isEmpty()) null else  prev + 1
                //if (body.size < params.loadSize) null else prev + 1
            )
            }else{
                LoadResult.Error(Exception())
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}