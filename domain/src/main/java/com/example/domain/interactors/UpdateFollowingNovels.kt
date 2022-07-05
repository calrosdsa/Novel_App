package com.example.domain.interactors

import com.example.data.fetch
import com.example.data.store.following.FollowingStore
import com.example.domain.Interactor
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateFollowingNovels @Inject constructor(
      private val followingStore: FollowingStore,
      private val dispatchers: AppCoroutineDispatchers,
):Interactor<UpdateFollowingNovels.Params>() {

      override suspend fun doWork(params: Params) {
            withContext(dispatchers.io){
            //if(params.query.isNotBlank()){
                  if(params.query.isNotBlank()){
                  followingStore.fetch(params.query,params.forceRefresh)
                  }
            //}
            }
      }

      override suspend fun deleteAll(params:Params) {
                  withContext(dispatchers.io) {
                        followingStore.clear(
                                    params.query,
                              )
            }
      }

      data class Params(val query:String ,
                        val forceRefresh: Boolean = false,
            )
}
