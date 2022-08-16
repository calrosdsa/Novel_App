package com.example.data.remote

import com.example.data.dto.allNovels.AllNovelsDto
import com.example.data.dto.browse.BrowseDto
import com.example.data.dto.chapters.*
import com.example.data.dto.novel.NovelDetailDto
import com.example.data.dto.novels.NovelsDto
import com.example.data.dto.chaptersLatest.LatestChaptersDto
import com.example.data.dto.history.HistoryDtoItem
import com.example.data.dto.library.BookMarkDto
import com.example.data.dto.novel.Category
import com.example.data.dto.profile.ProfileDto
import com.example.data.dto.recommended.Recommended
import com.example.data.dto.reviews.ReviewsDto
import com.example.data.dto.searchNovel.ResultSearch
import com.example.data.dto.user.LoginRequest
import com.example.data.dto.user.LoginResponse
import com.example.data.dto.user.SignUpRequest
import com.example.data.dto.user.SignUpResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/novels/ranking/")
    suspend fun getNovels(): NovelsDto
    @GET("/novels/detail/{novelSlug}/")
    suspend fun getNovelBySlug(@Path("novelSlug") novelSlug:String): NovelDetailDto
    @GET("/novels/novel_chapter/{novelSlug}/")
    suspend fun getChaptersNovel(
        @Path("novelSlug") novelSlug:String,
    ): NovelChaptersDto
    @GET("/novels/postreview/{novelSlug}/")
    suspend fun getReviewsNovel(@Path("novelSlug") novelSlug:String):ReviewsDto
    @GET("/categories/updates")
    suspend fun getLatestChapters(@Query("page") page: Int): Response<LatestChaptersDto>

    @GET("/novels/filter/")
    suspend fun filterNovels(
        @Query("page") page: Int,
        @Query("status") status:Int?,
        @Query("ordering") ordering:String?,
        @Query("category") category:Int?,
    ):Response<BrowseDto>

    @POST("/api/v1/users/auth/login/")
    suspend fun loginRequest(@Body loginRequest:LoginRequest):Response<LoginResponse>

    @POST("/api/v1/users/auth/register/")
    suspend fun  signUpRequest(@Body signUpRequest: SignUpRequest):Response<SignUpResponse>
    @GET("/profile/me")
    suspend fun getProfile(
        @Header("Authorization") token: String
    ):ProfileDto
    @GET("/novels/library")
    suspend fun getLibrary(
        @Header("Authorization") token: String,
  //      @Query("options")options:Int,
  //      @Query("ordering")ordering:String
    ):BookMarkDto
    @GET("/novels/search/")
    suspend fun getSearchNovels(): AllNovelsDto
    @GET("/novels/recommended/")
    suspend fun getRecommended(): Recommended
    @POST("/novels/favorites-products/update/{novelId}/")
    suspend fun addToBookMark(
        @Header("Authorization") token: String,
        @Path("novelId")novelId:Int):String

    @PUT("/novels/option/{novelId}/")
    suspend fun setOptionsBookMark(
        @Header("Authorization") token: String,
        @Path("novelId") novelId:Int,
        @Body option: NovelOption,
    ):String

    @GET("/novels/searchAll/")
    suspend fun searchNovel(): List<ResultSearch>

    @GET("/categories/")
    suspend fun getAllCategories():List<Category>

    @GET("/profile/detail")
    fun getHistoryNovels(
        @Header("Authorization") token: String,
        @Query("page") page:Int
        ):Call<List<HistoryDtoItem>>


    @GET("/novels/single_chapter/{slug}/")
    suspend fun getChapterSingle(
//        @Header("Authorization") token: String,
        @Path("slug") slug:String
    ):SingleChapterDto

    @GET("/novels/all_chapters/{slug}/")
    suspend fun getAllChapters(
        @Path("slug") slug:String,
    ):ChaptersDto

    @POST("/novels/chapters/")
    suspend fun downloadChapters(@Body ids:Ids):List<DownLoadChapter>

    @GET("/novels/chapters/{novelSlug}/")
    suspend fun downloadAllChapters(
        @Path("novelSlug") novelSlug:String,
    ): List<DownLoadChapter>
}

data class NovelOption(
    val option: Int
)
data class Ids(
    val ids:List<Int>
)
