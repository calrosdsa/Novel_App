package com.example.data.repository;

import com.example.data.remote.ApiService;
import com.example.domain.UserAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NovelRepositoryImpl_Factory implements Factory<NovelRepositoryImpl> {
  private final Provider<ApiService> apiProvider;

  private final Provider<UserAuth> authProvider;

  public NovelRepositoryImpl_Factory(Provider<ApiService> apiProvider,
      Provider<UserAuth> authProvider) {
    this.apiProvider = apiProvider;
    this.authProvider = authProvider;
  }

  @Override
  public NovelRepositoryImpl get() {
    return newInstance(apiProvider.get(), authProvider.get());
  }

  public static NovelRepositoryImpl_Factory create(Provider<ApiService> apiProvider,
      Provider<UserAuth> authProvider) {
    return new NovelRepositoryImpl_Factory(apiProvider, authProvider);
  }

  public static NovelRepositoryImpl newInstance(ApiService api, UserAuth auth) {
    return new NovelRepositoryImpl(api, auth);
  }
}
