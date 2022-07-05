package com.example.domain.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.dto.history.HistoryDtoItem
import com.example.data.mapper.toHistoryNovel
import com.example.data.remote.ApiService
import com.example.domain.UserAuth
import retrofit2.awaitResponse
import javax.inject.Inject

class NovelHistoryPagination @Inject constructor(
    private val apiService: ApiService,
    private val auth: UserAuth
):PagingSource<Int,HistoryDtoItem>() {
    private val authToken:String
    get() = auth.tokenValue.token
    override fun getRefreshKey(state: PagingState<Int, HistoryDtoItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HistoryDtoItem> {
        return  try {
            val prev = params.key ?: 1
            val response = apiService.getHistoryNovels(authToken,prev).awaitResponse()
            if (response.isSuccessful){
              Log.d("PARAM",prev.toString())
                val body = response.body()
                LoadResult.Page(
                    data = body!!.map { it },
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