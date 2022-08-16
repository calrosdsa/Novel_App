package com.example.detail;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.example.data.local.daos.FollowingDao;
import com.example.data.repository.NovelRepository;
import com.example.data.repository.NovelUtil;
import com.example.domain.UserAuth;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetNovelDetail;
import com.example.domain.useCases.GetReviews;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NovelDetailViewModel_Factory implements Factory<NovelDetailViewModel> {
  private final Provider<GetNovelDetail> getNovelProvider;

  private final Provider<NovelRepository> novelRepositoryProvider;

  private final Provider<GetChapters> getChaptersProvider;

  private final Provider<GetReviews> getReviewsProvider;

  private final Provider<NovelUtil> novelUtilProvider;

  private final Provider<UserAuth> authProvider;

  private final Provider<FollowingDao> followingDaoProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<Context> contextProvider;

  public NovelDetailViewModel_Factory(Provider<GetNovelDetail> getNovelProvider,
      Provider<NovelRepository> novelRepositoryProvider, Provider<GetChapters> getChaptersProvider,
      Provider<GetReviews> getReviewsProvider, Provider<NovelUtil> novelUtilProvider,
      Provider<UserAuth> authProvider, Provider<FollowingDao> followingDaoProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<Context> contextProvider) {
    this.getNovelProvider = getNovelProvider;
    this.novelRepositoryProvider = novelRepositoryProvider;
    this.getChaptersProvider = getChaptersProvider;
    this.getReviewsProvider = getReviewsProvider;
    this.novelUtilProvider = novelUtilProvider;
    this.authProvider = authProvider;
    this.followingDaoProvider = followingDaoProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public NovelDetailViewModel get() {
    return newInstance(getNovelProvider.get(), novelRepositoryProvider.get(), getChaptersProvider.get(), getReviewsProvider.get(), novelUtilProvider.get(), authProvider.get(), followingDaoProvider.get(), savedStateHandleProvider.get(), contextProvider.get());
  }

  public static NovelDetailViewModel_Factory create(Provider<GetNovelDetail> getNovelProvider,
      Provider<NovelRepository> novelRepositoryProvider, Provider<GetChapters> getChaptersProvider,
      Provider<GetReviews> getReviewsProvider, Provider<NovelUtil> novelUtilProvider,
      Provider<UserAuth> authProvider, Provider<FollowingDao> followingDaoProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<Context> contextProvider) {
    return new NovelDetailViewModel_Factory(getNovelProvider, novelRepositoryProvider, getChaptersProvider, getReviewsProvider, novelUtilProvider, authProvider, followingDaoProvider, savedStateHandleProvider, contextProvider);
  }

  public static NovelDetailViewModel newInstance(GetNovelDetail getNovel,
      NovelRepository novelRepository, GetChapters getChapters, GetReviews getReviews,
      NovelUtil novelUtil, UserAuth auth, FollowingDao followingDao,
      SavedStateHandle savedStateHandle, Context context) {
    return new NovelDetailViewModel(getNovel, novelRepository, getChapters, getReviews, novelUtil, auth, followingDao, savedStateHandle, context);
  }
}
