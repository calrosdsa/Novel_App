package com.example.domain.pagination;

import com.example.data.remote.ApiService;
import com.example.domain.UserAuth;
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
public final class NovelHistoryPagination_Factory implements Factory<NovelHistoryPagination> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<UserAuth> authProvider;

  public NovelHistoryPagination_Factory(Provider<ApiService> apiServiceProvider,
      Provider<UserAuth> authProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.authProvider = authProvider;
  }

  @Override
  public NovelHistoryPagination get() {
    return newInstance(apiServiceProvider.get(), authProvider.get());
  }

  public static NovelHistoryPagination_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<UserAuth> authProvider) {
    return new NovelHistoryPagination_Factory(apiServiceProvider, authProvider);
  }

  public static NovelHistoryPagination newInstance(ApiService apiService, UserAuth auth) {
    return new NovelHistoryPagination(apiService, auth);
  }
}
