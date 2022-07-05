package com.example.data.store.following

import android.content.Context
import android.util.Log
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.data.local.daos.FollowingDao
import com.example.data.local.entities.FollowingEntity
import com.example.data.mapper.toFollowingEntity
import com.example.data.remote.ApiService
import com.example.data.repository.NovelUtil
import com.example.domain.UserAuth
import com.example.util.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Singleton

typealias FollowingStore = Store<String, List<FollowingEntity>>



@InstallIn(SingletonComponent::class)
@Module
internal object FollowingModule{
    @Provides
    @Singleton
    fun provideFollowingModule(
        apiService: ApiService,
        followingDao: FollowingDao,
        novelUtil: NovelUtil,
        @ApplicationContext context: Context
    ):FollowingStore = StoreBuilder.from(
        fetcher = Fetcher.of {
            apiService.getLibrary(it).results
        },
        sourceOfTruth = SourceOfTruth.of(
            reader = {
                followingDao.getAllFollowings()
                    .map { entries ->
                        when {
                            // Store only treats null as 'no value', so convert to null
                            entries.isEmpty() -> null
                            // If the request is expired, our data is stale
                            //         lastRequestStore.isRequestExpired(Duration.ofHours(3)) -> null
                            // Otherwise, our data is fresh and valid
                            else -> entries
                        }
                    }
            },
            writer = {_,entries ->
            //    withContext(dispatchers.io){
                val results = entries.map { it.toFollowingEntity().copy(
                  cover = novelUtil.getImageBitmap(context,it.cover),
                ) }
                followingDao.insertFollowings(results)
              //  }
            },
            delete = followingDao::deleteNovel,
            deleteAll = followingDao::deleteAll,
        )
    ).build()
}