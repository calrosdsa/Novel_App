package com.example.data.store.following;

import android.content.Context;
import com.dropbox.android.external.store4.Store;
import com.example.data.local.daos.FollowingDao;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.remote.ApiService;
import com.example.data.repository.NovelUtil;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FollowingModule_ProvideFollowingModuleFactory implements Factory<Store<String, List<FollowingEntity>>> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<FollowingDao> followingDaoProvider;

  private final Provider<NovelUtil> novelUtilProvider;

  private final Provider<Context> contextProvider;

  public FollowingModule_ProvideFollowingModuleFactory(Provider<ApiService> apiServiceProvider,
      Provider<FollowingDao> followingDaoProvider, Provider<NovelUtil> novelUtilProvider,
      Provider<Context> contextProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.followingDaoProvider = followingDaoProvider;
    this.novelUtilProvider = novelUtilProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public Store<String, List<FollowingEntity>> get() {
    return provideFollowingModule(apiServiceProvider.get(), followingDaoProvider.get(), novelUtilProvider.get(), contextProvider.get());
  }

  public static FollowingModule_ProvideFollowingModuleFactory create(
      Provider<ApiService> apiServiceProvider, Provider<FollowingDao> followingDaoProvider,
      Provider<NovelUtil> novelUtilProvider, Provider<Context> contextProvider) {
    return new FollowingModule_ProvideFollowingModuleFactory(apiServiceProvider, followingDaoProvider, novelUtilProvider, contextProvider);
  }

  public static Store<String, List<FollowingEntity>> provideFollowingModule(ApiService apiService,
      FollowingDao followingDao, NovelUtil novelUtil, Context context) {
    return Preconditions.checkNotNullFromProvides(FollowingModule.INSTANCE.provideFollowingModule(apiService, followingDao, novelUtil, context));
  }
}
