package com.example.domain.interactors

import com.example.data.local.daos.FollowingDao
import com.example.data.remote.ApiService
import com.example.domain.Interactor
import javax.inject.Inject

class AddOrRemoveNovelFromBookMark @Inject constructor(
    private val apiService: ApiService,
    private val followingDao: FollowingDao
):Interactor<AddOrRemoveNovelFromBookMark.Params>() {
    override suspend fun doWork(params: Params) {
        if(params.token.isBlank()) return
        apiService.addToBookMark(params.token,params.novelId)
        followingDao.deleteNovel(params.novelTitle)
    }

    override suspend fun deleteAll(params: Params) {
        TODO("Not yet implemented")
    }

    data class Params(
        val token:String,
        val novelId:Int,
        val novelTitle:String
    )
}