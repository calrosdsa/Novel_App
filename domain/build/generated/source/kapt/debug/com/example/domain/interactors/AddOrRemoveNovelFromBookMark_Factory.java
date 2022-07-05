package com.example.domain.interactors;

import com.example.data.local.daos.FollowingDao;
import com.example.data.remote.ApiService;
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
public final class AddOrRemoveNovelFromBookMark_Factory implements Factory<AddOrRemoveNovelFromBookMark> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<FollowingDao> followingDaoProvider;

  public AddOrRemoveNovelFromBookMark_Factory(Provider<ApiService> apiServiceProvider,
      Provider<FollowingDao> followingDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.followingDaoProvider = followingDaoProvider;
  }

  @Override
  public AddOrRemoveNovelFromBookMark get() {
    return newInstance(apiServiceProvider.get(), followingDaoProvider.get());
  }

  public static AddOrRemoveNovelFromBookMark_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<FollowingDao> followingDaoProvider) {
    return new AddOrRemoveNovelFromBookMark_Factory(apiServiceProvider, followingDaoProvider);
  }

  public static AddOrRemoveNovelFromBookMark newInstance(ApiService apiService,
      FollowingDao followingDao) {
    return new AddOrRemoveNovelFromBookMark(apiService, followingDao);
  }
}
