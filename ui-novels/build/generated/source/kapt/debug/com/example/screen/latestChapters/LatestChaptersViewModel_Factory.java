package com.example.screen.latestChapters;

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
public final class LatestChaptersViewModel_Factory implements Factory<LatestChaptersViewModel> {
  private final Provider<ApiService> apiServiceProvider;

  public LatestChaptersViewModel_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public LatestChaptersViewModel get() {
    return newInstance(apiServiceProvider.get());
  }

  public static LatestChaptersViewModel_Factory create(Provider<ApiService> apiServiceProvider) {
    return new LatestChaptersViewModel_Factory(apiServiceProvider);
  }

  public static LatestChaptersViewModel newInstance(ApiService apiService) {
    return new LatestChaptersViewModel(apiService);
  }
}
