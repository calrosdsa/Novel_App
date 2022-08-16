package com.example.data.store.category


import android.content.Context
import android.util.Log
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.SourceOfTruth
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.example.data.local.daos.CategoryDao
import com.example.data.local.daos.FollowingDao
import com.example.data.local.entities.CategoryEntity
import com.example.data.mapper.toCategoryEntity
import com.example.data.remote.ApiService
import com.example.data.repository.NovelUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

typealias   CategoryStore = Store<Unit, List<CategoryEntity>>



@InstallIn(SingletonComponent::class)
@Module
internal object CategoryModule{
    @Provides
    @Singleton
    fun provideCategoryModule(
        apiService: ApiService,
        categoryDao: CategoryDao,
    ):CategoryStore = StoreBuilder.from(
        fetcher = Fetcher.of {
            apiService.getAllCategories()
        },
        sourceOfTruth = SourceOfTruth.of(
            reader = {
                 categoryDao.getCategoryList().map { entries->
                     when {
                         // Store only treats null as 'no value', so convert to null
                         entries.isEmpty() -> null
                         // If the request is expired, our data is stale
                 //        lastRequestStore.isRequestExpired(Duration.ofHours(6)) -> null
                         // Otherwise, our data is fresh and valid
                         else -> entries
                     }
                 }
            },
            writer = {_:Unit,response ->
                val entries = response.map { it.toCategoryEntity() }
                    categoryDao.insertAll(entries)
            },
            delete = {
                categoryDao.deleteAll()
                     },
                deleteAll = categoryDao::deleteAll,
                )
                ).build()
            }
