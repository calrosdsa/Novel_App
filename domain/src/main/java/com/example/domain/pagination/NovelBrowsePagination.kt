package com.example.domain.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.api.UiMessage
import com.example.api.UiMessageManager
import com.example.data.dto.browse.Novel
import com.example.data.remote.ApiService
import javax.inject.Inject

class NovelBrowsePagination @Inject constructor(
    private val apiService: ApiService,
    private val status:Int? = null,
    private val ordering:String?=null,
    private val category:Int?=null,
):PagingSource<Int,Novel>() {
    override fun getRefreshKey(state: PagingState<Int, Novel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Novel> {
       return try{
        val prev = params.key ?: 1
        val response = apiService.filterNovels(prev,status,ordering,category)
        if (response.isSuccessful){
            val body = response.body()?.novels
            //Log.d("PARAMPAGE",category.toString())
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