package com.example.bookmark;

import com.example.data.repository.NovelRepository;
import com.example.domain.UserAuth;
import com.example.domain.interactors.AddOrRemoveNovelFromBookMark;
import com.example.domain.interactors.UpdateFollowingNovels;
import com.example.domain.interactors.UpdatedOptionsBookMark;
import com.example.domain.observers.ObserverFollowings;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BookMarkedViewModel_Factory implements Factory<BookMarkedViewModel> {
  private final Provider<NovelRepository> novelRepositoryProvider;

  private final Provider<ObserverFollowings> observerFollowingsProvider;

  private final Provider<UpdateFollowingNovels> updateFollowingNovelsProvider;

  private final Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider;

  private final Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider;

  private final Provider<UserAuth> userAuthProvider;

  public BookMarkedViewModel_Factory(Provider<NovelRepository> novelRepositoryProvider,
      Provider<ObserverFollowings> observerFollowingsProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider,
      Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider,
      Provider<UserAuth> userAuthProvider) {
    this.novelRepositoryProvider = novelRepositoryProvider;
    this.observerFollowingsProvider = observerFollowingsProvider;
    this.updateFollowingNovelsProvider = updateFollowingNovelsProvider;
    this.updatedOptionsBookMarkProvider = updatedOptionsBookMarkProvider;
    this.addOrRemoveNovelFromBookMarkProvider = addOrRemoveNovelFromBookMarkProvider;
    this.userAuthProvider = userAuthProvider;
  }

  @Override
  public BookMarkedViewModel get() {
    return newInstance(novelRepositoryProvider.get(), observerFollowingsProvider.get(), updateFollowingNovelsProvider.get(), updatedOptionsBookMarkProvider.get(), addOrRemoveNovelFromBookMarkProvider.get(), userAuthProvider.get());
  }

  public static BookMarkedViewModel_Factory create(
      Provider<NovelRepository> novelRepositoryProvider,
      Provider<ObserverFollowings> observerFollowingsProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider,
      Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider,
      Provider<UserAuth> userAuthProvider) {
    return new BookMarkedViewModel_Factory(novelRepositoryProvider, observerFollowingsProvider, updateFollowingNovelsProvider, updatedOptionsBookMarkProvider, addOrRemoveNovelFromBookMarkProvider, userAuthProvider);
  }

  public static BookMarkedViewModel newInstance(NovelRepository novelRepository,
      ObserverFollowings observerFollowings, UpdateFollowingNovels updateFollowingNovels,
      UpdatedOptionsBookMark updatedOptionsBookMark,
      AddOrRemoveNovelFromBookMark addOrRemoveNovelFromBookMark, UserAuth userAuth) {
    return new BookMarkedViewModel(novelRepository, observerFollowings, updateFollowingNovels, updatedOptionsBookMark, addOrRemoveNovelFromBookMark, userAuth);
  }
}
