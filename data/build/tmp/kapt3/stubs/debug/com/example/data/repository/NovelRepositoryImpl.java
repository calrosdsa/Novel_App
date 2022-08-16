package com.example.data.repository;

import com.example.data.dto.allNovels.AllNovelsDto;
import com.example.data.dto.browse.BrowseDto;
import com.example.data.dto.novel.NovelDetailDto;
import com.example.data.dto.novels.NovelsDto;
import com.example.data.dto.chapters.NovelChaptersDto;
import com.example.data.dto.library.BookMarkDto;
import com.example.data.dto.profile.ProfileDto;
import com.example.data.dto.recommended.Recommended;
import com.example.data.dto.reviews.ReviewsDto;
import com.example.data.dto.searchNovel.ResultSearch;
import com.example.data.dto.user.LoginRequest;
import com.example.data.dto.user.LoginResponse;
import com.example.data.dto.user.SignUpRequest;
import com.example.data.dto.user.SignUpResponse;
import com.example.data.remote.ApiService;
import com.example.data.remote.NovelOption;
import com.example.domain.UserAuth;
import com.example.domain.UserData;
import retrofit2.Call;
import retrofit2.Response;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ7\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010%\u001a\u00020&H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010\'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0011\u0010)\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J!\u00104\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J7\u00107\u001a\b\u0012\u0004\u0012\u0002080,2\u0006\u00109\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lcom/example/data/repository/NovelRepositoryImpl;", "Lcom/example/data/repository/NovelRepository;", "api", "Lcom/example/data/remote/ApiService;", "auth", "Lcom/example/domain/UserAuth;", "(Lcom/example/data/remote/ApiService;Lcom/example/domain/UserAuth;)V", "token", "", "getToken", "()Ljava/lang/String;", "addToBookMark", "novelId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBrowseResults", "Lcom/example/data/dto/browse/BrowseDto;", "page", "ordering", "status", "category", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLibrary", "Lcom/example/data/dto/library/BookMarkDto;", "options", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNovelBySlug", "Lcom/example/data/dto/novel/NovelDetailDto;", "novelSlug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNovels", "Lcom/example/data/dto/novels/NovelsDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNovelsChapters", "Lcom/example/data/dto/chapters/NovelChaptersDto;", "getProfile", "Lcom/example/data/dto/profile/ProfileDto;", "getRecommended", "Lcom/example/data/dto/recommended/Recommended;", "getReviewsNovel", "Lcom/example/data/dto/reviews/ReviewsDto;", "getSearchNovels", "Lcom/example/data/dto/allNovels/AllNovelsDto;", "loginRequest", "Lretrofit2/Response;", "Lcom/example/data/dto/user/LoginResponse;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchNovel", "", "Lcom/example/data/dto/searchNovel/ResultSearch;", "setOption", "option", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUpRequest", "Lcom/example/data/dto/user/SignUpResponse;", "username", "password1", "password2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@javax.inject.Singleton()
public final class NovelRepositoryImpl implements com.example.data.repository.NovelRepository {
    private final com.example.data.remote.ApiService api = null;
    private final com.example.domain.UserAuth auth = null;
    
    @javax.inject.Inject()
    public NovelRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService api, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth) {
        super();
    }
    
    private final java.lang.String getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNovels(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.novels.NovelsDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNovelBySlug(@org.jetbrains.annotations.NotNull()
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.novel.NovelDetailDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNovelsChapters(@org.jetbrains.annotations.NotNull()
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.chapters.NovelChaptersDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getReviewsNovel(@org.jetbrains.annotations.NotNull()
    java.lang.String novelSlug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.reviews.ReviewsDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loginRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.user.LoginResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object signUpRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password1, @org.jetbrains.annotations.NotNull()
    java.lang.String password2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.data.dto.user.SignUpResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.profile.ProfileDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getLibrary(@org.jetbrains.annotations.NotNull()
    java.lang.String token, int options, @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.library.BookMarkDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getSearchNovels(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.allNovels.AllNovelsDto> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getRecommended(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.recommended.Recommended> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addToBookMark(@org.jetbrains.annotations.NotNull()
    java.lang.String token, int novelId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setOption(int novelId, int option, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object searchNovel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.data.dto.searchNovel.ResultSearch>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBrowseResults(int page, @org.jetbrains.annotations.NotNull()
    java.lang.String ordering, @org.jetbrains.annotations.Nullable()
    java.lang.Integer status, @org.jetbrains.annotations.Nullable()
    java.lang.Integer category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.data.dto.browse.BrowseDto> continuation) {
        return null;
    }
}