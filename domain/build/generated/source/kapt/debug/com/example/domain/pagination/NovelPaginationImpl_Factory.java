package com.example.domain.pagination;

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
public final class NovelPaginationImpl_Factory implements Factory<NovelPaginationImpl> {
  private final Provider<ApiService> apiServiceProvider;

  public NovelPaginationImpl_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public NovelPaginationImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static NovelPaginationImpl_Factory create(Provider<ApiService> apiServiceProvider) {
    return new NovelPaginationImpl_Factory(apiServiceProvider);
  }

  public static NovelPaginationImpl newInstance(ApiService apiService) {
    return new NovelPaginationImpl(apiService);
  }
}
