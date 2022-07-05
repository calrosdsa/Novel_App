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
public final class NovelBrowsePagination_Factory implements Factory<NovelBrowsePagination> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<Integer> statusProvider;

  private final Provider<String> orderingProvider;

  private final Provider<Integer> categoryProvider;

  public NovelBrowsePagination_Factory(Provider<ApiService> apiServiceProvider,
      Provider<Integer> statusProvider, Provider<String> orderingProvider,
      Provider<Integer> categoryProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.statusProvider = statusProvider;
    this.orderingProvider = orderingProvider;
    this.categoryProvider = categoryProvider;
  }

  @Override
  public NovelBrowsePagination get() {
    return newInstance(apiServiceProvider.get(), statusProvider.get(), orderingProvider.get(), categoryProvider.get());
  }

  public static NovelBrowsePagination_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<Integer> statusProvider, Provider<String> orderingProvider,
      Provider<Integer> categoryProvider) {
    return new NovelBrowsePagination_Factory(apiServiceProvider, statusProvider, orderingProvider, categoryProvider);
  }

  public static NovelBrowsePagination newInstance(ApiService apiService, Integer status,
      String ordering, Integer category) {
    return new NovelBrowsePagination(apiService, status, ordering, category);
  }
}
