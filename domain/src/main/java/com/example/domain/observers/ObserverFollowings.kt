package com.example.domain.observers

import com.dropbox.android.external.store4.get
import com.example.data.local.daos.FollowingDao
import com.example.data.local.entities.FollowingEntity
import com.example.data.store.following.FollowingStore
import com.example.domain.SubjectInteractor
import com.example.domain.UserAuth
import com.example.domain.resources.SortedBy
import com.example.domain.util.NovelOrder
import com.example.domain.util.OrderType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserverFollowings @Inject constructor(
    //private val followingStore: FollowingStore,
    private val followingDao: FollowingDao
//    private val auth: UserAuth,
) :SubjectInteractor<ObserverFollowings.Params, List<FollowingEntity>>(){
//    private val token:String
  //  get() = auth.tokenValue.token

    override fun createObservable(params: Params): Flow<List<FollowingEntity>> {
        val novelsD = followingDao.getAllFollowings().map { novels->
                    when(params.ordering){
                        is NovelOrder.Updated -> novels.sortedByDescending { it.updated }
                        is NovelOrder.Added -> novels.sortedByDescending { it.added }
                    }
        }
             return novelsD.map { list ->
                 list.filter { it.options.contains(params.option) }
             }
    }
    data class Params(
        val option:Int,
        val ordering:NovelOrder = NovelOrder.Updated,
    )
}