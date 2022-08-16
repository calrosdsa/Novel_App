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
import com.example.data.dto.user.LoginRequest
import com.example.data.dto.user.LoginResponse
import com.example.data.dto.user.SignUpRequest
import com.example.data.dto.user.SignUpResponse
import com.example.data.remote.ApiService
import com.example.data.remote.NovelOption
import com.example.domain.UserAuth
import com.example.domain.UserData
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NovelRepositoryImpl @Inject constructor(
    private val api:ApiService,
    private val auth: UserAuth
):NovelRepository {

   private val token:String
       get() = auth.tokenValue.token

    override suspend fun getNovels(): NovelsDto {
        return api.getNovels()
    }

    override suspend fun getNovelBySlug(novelSlug: String): NovelDetailDto {
        return api.getNovelBySlug(novelSlug)
    }

    override suspend fun getNovelsChapters(novelSlug: String): NovelChaptersDto {
        return api.getChaptersNovel(novelSlug)
    }

    override suspend fun getReviewsNovel(novelSlug: String): ReviewsDto {
        return api.getReviewsNovel(novelSlug)
    }

    override suspend fun loginRequest(email: String, password: String): Response<LoginResponse> {

        val response = api.loginRequest(
            loginRequest = LoginRequest(
                email = email,
                password = password
            )
        )
      response.body()?.key?.let {
      auth.tokenValue = UserData(token = it)
      }
            //val dataUser= response.data
      return response

    }

    override suspend fun signUpRequest(
        username: String,
        email: String,
        password1: String,
        password2: String
    ): Response<SignUpResponse> {
        //      val body = response.body()
//        if(response.isSuccessful){
//        auth.tokenValue = UserData(token = body?.key!!)
//            //            .apply()
//        }
        val response = api.signUpRequest(
            signUpRequest = SignUpRequest(
                username = username,
                email = email,
                password1 = password1,
                password2 = password2
            )
        )
        response.body()?.key?.let {
            auth.tokenValue = UserData(token = it)
        }
        return response
    }

    override suspend fun getProfile(
        token:String
    ): ProfileDto {
        return api.getProfile(
            token
        )
    }

    override suspend fun getLibrary(
        token: String,
        options:Int,
        ordering:String
    ): BookMarkDto {
        return api.getLibrary(
            token,
    //        options,
      //      ordering
        )
    }

    override suspend fun getSearchNovels(): AllNovelsDto {
        return api.getSearchNovels()
    }

    override suspend fun getRecommended():Recommended {
        return api.getRecommended()
    }

    override suspend fun addToBookMark(token: String,novelId:Int): String {
        return api.addToBookMark(token,novelId)
    }

    override suspend fun setOption(novelId: Int, option: Int): String {
        return api.setOptionsBookMark(token,novelId, NovelOption(option = option))
    }

    override suspend fun searchNovel():List<ResultSearch> {
        return api.searchNovel()
    }

    override suspend fun getBrowseResults(
        page:Int,
        ordering: String,
        status: Int?,
        category: Int?): BrowseDto? {
        return api.filterNovels(page,status,ordering,category).body()
    }

}
