package com.example.data.remote;

import com.example.data.dto.allNovels.AllNovelsDto;
import com.example.data.dto.browse.BrowseDto;
import com.example.data.dto.chapters.*;
import com.example.data.dto.novel.NovelDetailDto;
import com.example.data.dto.novels.NovelsDto;
import com.example.data.dto.chaptersLatest.LatestChaptersDto;
import com.example.data.dto.history.HistoryDtoItem;
import com.example.data.dto.library.BookMarkDto;
import com.example.data.dto.novel.Category;
import com.example.data.dto.profile.ProfileDto;
import com.example.data.dto.recommended.Recommended;
import com.example.data.dto.reviews.ReviewsDto;
import com.example.data.dto.searchNovel.ResultSearch;
import com.example.data.dto.user.LoginRequest;
import com.example.data.dto.user.LoginResponse;
import com.example.data.dto.user.SignUpRequest;
import com.example.data.dto.user.SignUpResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010JE\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u00062\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u001e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010!\u001a\u00020\"2\b\b\u0001\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\t0$2\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0006H\'J!\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\u001b\u0010)\u001a\u00020*2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010+\u001a\u00020,2\b\b\u0001\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010-\u001a\u00020.H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001b\u0010/\u001a\u0002002\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u00101\u001a\u000202H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001b\u00103\u001a\u0002042\b\b\u0001\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u00105\u001a\u000206H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ!\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00122\b\b\u0001\u00107\u001a\u000209H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ/\u0010=\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010>\u001a\u00020?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J!\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00122\b\b\u0001\u0010A\u001a\u00020CH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006E"}, d2 = {"Lcom/example/data/remote/ApiService;", "", "addToBookMark", "", "token", "novelId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAllChapters", "", "Lcom/example/data/dto/chapters/DownLoadChapter;", "novelSlug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadChapters", "ids", "Lcom/example/data/remote/Ids;", "(Lcom/example/data/remote/Ids;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNovels", "Lretrofit2/Response;", "Lcom/example/data/dto/browse/BrowseDto;", "page", "status", "ordering", "category", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Lcom/example/data/dto/novel/Category;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllChapters", "Lcom/example/data/dto/chapters/ChaptersDto;", "slug", "getChapterSingle", "Lcom/example/data/dto/chapters/SingleChapterDto;", "getChaptersNovel", "Lcom/example/data/dto/chapters/NovelChaptersDto;", "getHistoryNovels", "Lretrofit2/Call;", "Lcom/example/data/dto/history/HistoryDtoItem;", "getLatestChapters", "Lcom/example/data/dto/chaptersLatest/LatestChaptersDto;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLibrary", "Lcom/example/data/dto/library/BookMarkDto;", "getNovelBySlug", "Lcom/example/data/dto/novel/NovelDetailDto;", "getNovels", "Lcom/example/data/dto/novels/NovelsDto;", "getProfile", "Lcom/example/data/dto/profile/ProfileDto;", "getRecommended", "Lcom/example/data/dto/recommended/Recommended;", "getReviewsNovel", "Lcom/example/data/dto/reviews/ReviewsDto;", "getSearchNovels", "Lcom/example/data/dto/allNovels/AllNovelsDto;", "loginRequest", "Lcom/example/data/dto/user/LoginResponse;", "Lcom/example/data/dto/user/LoginRequest;", "(Lcom/example/data/dto/user/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchNovel", "Lcom/example/data/dto/searchNovel/ResultSearch;", "setOptionsBookMark", "option", "Lcom/example/data/remote/NovelOption;", "(Ljava/lang/String;ILcom/example/data/remote/NovelOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUpRequest", "Lcom/example/data/dto/user/SignUpResponse;", "Lcom/example/data/dto/user/SignUpRequest;", "(Lcom/example/data/dto/user/SignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/ranking/")
    public abstract java.lang.Object getNovels(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.novels.NovelsDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/detail/{novelSlug}/")
    public abstract java.lang.Object getNovelBySlug(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "novelSlug")
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.novel.NovelDetailDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/novel_chapter/{novelSlug}/")
    public abstract java.lang.Object getChaptersNovel(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "novelSlug")
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.chapters.NovelChaptersDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/postreview/{novelSlug}/")
    public abstract java.lang.Object getReviewsNovel(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "novelSlug")
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.reviews.ReviewsDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/categories/updates")
    public abstract java.lang.Object getLatestChapters(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.chaptersLatest.LatestChaptersDto>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/filter/")
    public abstract java.lang.Object filterNovels(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "status")
    java.lang.Integer status, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "ordering")
    java.lang.String ordering, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "category")
    java.lang.Integer category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.browse.BrowseDto>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/v1/users/auth/login/")
    public abstract java.lang.Object loginRequest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.data.dto.user.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.user.LoginResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/v1/users/auth/register/")
    public abstract java.lang.Object signUpRequest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.data.dto.user.SignUpRequest signUpRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.user.SignUpResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/profile/me")
    public abstract java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.profile.ProfileDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/library")
    public abstract java.lang.Object getLibrary(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.library.BookMarkDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/search/")
    public abstract java.lang.Object getSearchNovels(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.allNovels.AllNovelsDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/recommended/")
    public abstract java.lang.Object getRecommended(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.recommended.Recommended> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/novels/favorites-products/update/{novelId}/")
    public abstract java.lang.Object addToBookMark(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Path(value = "novelId")
    int novelId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "/novels/option/{novelId}/")
    public abstract java.lang.Object setOptionsBookMark(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Path(value = "novelId")
    int novelId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.data.remote.NovelOption option, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/searchAll/")
    public abstract java.lang.Object searchNovel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.dto.searchNovel.ResultSearch>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/categories/")
    public abstract java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.dto.novel.Category>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/profile/detail")
    public abstract retrofit2.Call<java.util.List<com.example.data.dto.history.HistoryDtoItem>> getHistoryNovels(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Query(value = "page")
    int page);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/single_chapter/{slug}/")
    public abstract java.lang.Object getChapterSingle(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "slug")
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.chapters.SingleChapterDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/all_chapters/{slug}/")
    public abstract java.lang.Object getAllChapters(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "slug")
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.chapters.ChaptersDto> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/novels/chapters/")
    public abstract java.lang.Object downloadChapters(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.data.remote.Ids ids, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.dto.chapters.DownLoadChapter>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/novels/chapters/{novelSlug}/")
    public abstract java.lang.Object downloadAllChapters(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "novelSlug")
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.dto.chapters.DownLoadChapter>> continuation);
}