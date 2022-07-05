package com.example.domain.interactors

import com.dropbox.android.external.store4.fresh
import com.example.data.fetch
import com.example.data.remote.ApiService
import com.example.data.remote.NovelOption
import com.example.data.store.following.FollowingStore
import com.example.domain.Interactor
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdatedOptionsBookMark @Inject constructor(
    private val apiService: ApiService,
    private val followingStore: FollowingStore,
    private val dispatchers: AppCoroutineDispatchers
):Interactor<UpdatedOptionsBookMark.Params>() {

    override suspend fun doWork(params: Params) {
        if (params.token.isBlank()) return
        withContext(dispatchers.io){
                apiService.setOptionsBookMark(
                    params.token,
                    params.novelId,
                    NovelOption(option = params.option)
                )
            followingStore.fresh(params.token)
        }
    }

    override suspend fun deleteAll(params: Params) {
        TODO("Not yet implemented")
    }
    data class Params(
        val token:String,
        val novelId:Int,
        val option:Int,
    )
}