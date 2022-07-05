package com.example.recommended;

import android.content.Context;
import com.example.data.local.daos.FollowingDao;
import com.example.data.repository.NovelRepository;
import com.example.data.repository.NovelUtil;
import com.example.domain.UserAuth;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetRecommended;
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
public final class RecommendedViewModel_Factory implements Factory<RecommendedViewModel> {
  private final Provider<GetRecommended> getRecommendedProvider;

  private final Provider<GetChapters> getChaptersProvider;

  private final Provider<NovelRepository> novelRepositoryProvider;

  private final Provider<NovelUtil> novelUtilProvider;

  private final Provider<FollowingDao> followingDaoProvider;

  private final Provider<UserAuth> authProvider;

  private final Provider<Context> contextProvider;

  public RecommendedViewModel_Factory(Provider<GetRecommended> getRecommendedProvider,
      Provider<GetChapters> getChaptersProvider, Provider<NovelRepository> novelRepositoryProvider,
      Provider<NovelUtil> novelUtilProvider, Provider<FollowingDao> followingDaoProvider,
      Provider<UserAuth> authProvider, Provider<Context> contextProvider) {
    this.getRecommendedProvider = getRecommendedProvider;
    this.getChaptersProvider = getChaptersProvider;
    this.novelRepositoryProvider = novelRepositoryProvider;
    this.novelUtilProvider = novelUtilProvider;
    this.followingDaoProvider = followingDaoProvider;
    this.authProvider = authProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public RecommendedViewModel get() {
    return newInstance(getRecommendedProvider.get(), getChaptersProvider.get(), novelRepositoryProvider.get(), novelUtilProvider.get(), followingDaoProvider.get(), authProvider.get(), contextProvider.get());
  }

  public static RecommendedViewModel_Factory create(Provider<GetRecommended> getRecommendedProvider,
      Provider<GetChapters> getChaptersProvider, Provider<NovelRepository> novelRepositoryProvider,
      Provider<NovelUtil> novelUtilProvider, Provider<FollowingDao> followingDaoProvider,
      Provider<UserAuth> authProvider, Provider<Context> contextProvider) {
    return new RecommendedViewModel_Factory(getRecommendedProvider, getChaptersProvider, novelRepositoryProvider, novelUtilProvider, followingDaoProvider, authProvider, contextProvider);
  }

  public static RecommendedViewModel newInstance(GetRecommended getRecommended,
      GetChapters getChapters, NovelRepository novelRepository, NovelUtil novelUtil,
      FollowingDao followingDao, UserAuth auth, Context context) {
    return new RecommendedViewModel(getRecommended, getChapters, novelRepository, novelUtil, followingDao, auth, context);
  }
}
