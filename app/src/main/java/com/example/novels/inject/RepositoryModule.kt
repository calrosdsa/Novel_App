package com.example.novels.inject

import com.example.data.repository.*
import com.example.domain.UserAuth
import com.example.domain.repository.UserAuthImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNovelRepository(novelRepositoryImpl: NovelRepositoryImpl): NovelRepository

    @Binds
    @Singleton
    abstract fun bindUserAuth(userAuthImpl: UserAuthImpl):UserAuth

    @Binds
    @Singleton
    abstract fun bindNovelRepositoryDb(novelRepositoryDbImpl: NovelRepositoryDbImpl):NovelRepositoryDb

    @Binds
    @Singleton
    abstract fun bindNovelUtil(novelUtilImpl: NovelUtilImpl):NovelUtil

}
