package com.example.data.repository

import com.example.data.dto.allNovels.AllNovelsDto
import com.example.data.dto.browse.BrowseDto
import com.example.data.dto.novel.NovelDetailDto
import com.example.data.dto.novels.NovelsDto
import com.example.data.dto.chapters.NovelChaptersDto
import com.example.data.dto.library.BookMarkDto
import com.example.data.dto.profile.ProfileDto
import com.example.data.dto.recommended.Recommended
import com.example.data.dto.reviews.ReviewsDto
import com.example.data.dto.searchNovel.ResultSearch
import com.example.data.dto.user.LoginResponse

interface NovelRepository {
     suspend fun getNovels(): NovelsDto
     suspend fun getNovelBySlug(novelSlug:String): NovelDetailDto
     suspend fun getNovelsChapters(novelSlug: String):NovelChaptersDto
     suspend fun getReviewsNovel(novelSlug: String):ReviewsDto
     suspend fun loginRequest(email:String,password:String): LoginResponse
     suspend fun signUpRequest(username:String,email: String,password1: String,password2: String): LoginResponse
     suspend fun getProfile(
         token:String
     ):ProfileDto
     suspend fun getLibrary(
          token:String,
          options:Int,
          ordering:String
     ):BookMarkDto
     suspend fun getSearchNovels():AllNovelsDto
     suspend fun getRecommended(): Recommended
     suspend fun addToBookMark(token: String,novelId:Int): String
     suspend fun setOption(
          //token:String,
          novelId:Int,
          option:Int
     ):String

     suspend fun searchNovel(): List<ResultSearch>
     suspend fun getBrowseResults(
          page:Int,
          ordering: String,
          status:Int?,
          category:Int?
     ):BrowseDto?

}