package com.example.bookmark;

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
  private final Provider<ObserverFollowings> observerFollowingsProvider;

  private final Provider<UpdateFollowingNovels> updateFollowingNovelsProvider;

  private final Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider;

  private final Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider;

  private final Provider<UserAuth> userAuthProvider;

  public BookMarkedViewModel_Factory(Provider<ObserverFollowings> observerFollowingsProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider,
      Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider,
      Provider<UserAuth> userAuthProvider) {
    this.observerFollowingsProvider = observerFollowingsProvider;
    this.updateFollowingNovelsProvider = updateFollowingNovelsProvider;
    this.updatedOptionsBookMarkProvider = updatedOptionsBookMarkProvider;
    this.addOrRemoveNovelFromBookMarkProvider = addOrRemoveNovelFromBookMarkProvider;
    this.userAuthProvider = userAuthProvider;
  }

  @Override
  public BookMarkedViewModel get() {
    return newInstance(observerFollowingsProvider.get(), updateFollowingNovelsProvider.get(), updatedOptionsBookMarkProvider.get(), addOrRemoveNovelFromBookMarkProvider.get(), userAuthProvider.get());
  }

  public static BookMarkedViewModel_Factory create(
      Provider<ObserverFollowings> observerFollowingsProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<UpdatedOptionsBookMark> updatedOptionsBookMarkProvider,
      Provider<AddOrRemoveNovelFromBookMark> addOrRemoveNovelFromBookMarkProvider,
      Provider<UserAuth> userAuthProvider) {
    return new BookMarkedViewModel_Factory(observerFollowingsProvider, updateFollowingNovelsProvider, updatedOptionsBookMarkProvider, addOrRemoveNovelFromBookMarkProvider, userAuthProvider);
  }

  public static BookMarkedViewModel newInstance(ObserverFollowings observerFollowings,
      UpdateFollowingNovels updateFollowingNovels, UpdatedOptionsBookMark updatedOptionsBookMark,
      AddOrRemoveNovelFromBookMark addOrRemoveNovelFromBookMark, UserAuth userAuth) {
    return new BookMarkedViewModel(observerFollowings, updateFollowingNovels, updatedOptionsBookMark, addOrRemoveNovelFromBookMark, userAuth);
  }
}
