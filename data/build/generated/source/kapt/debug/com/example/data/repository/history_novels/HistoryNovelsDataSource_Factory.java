package com.example.data.repository.history_novels;

import com.example.data.mapper.HistoryDtoToHistoryEntity;
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
public final class HistoryNovelsDataSource_Factory implements Factory<HistoryNovelsDataSource> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<HistoryDtoToHistoryEntity> historyDtoToHistoryEntityProvider;

  private final Provider<UserAuth> authProvider;

  public HistoryNovelsDataSource_Factory(Provider<ApiService> apiServiceProvider,
      Provider<HistoryDtoToHistoryEntity> historyDtoToHistoryEntityProvider,
      Provider<UserAuth> authProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.historyDtoToHistoryEntityProvider = historyDtoToHistoryEntityProvider;
    this.authProvider = authProvider;
  }

  @Override
  public HistoryNovelsDataSource get() {
    return newInstance(apiServiceProvider.get(), historyDtoToHistoryEntityProvider.get(), authProvider.get());
  }

  public static HistoryNovelsDataSource_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<HistoryDtoToHistoryEntity> historyDtoToHistoryEntityProvider,
      Provider<UserAuth> authProvider) {
    return new HistoryNovelsDataSource_Factory(apiServiceProvider, historyDtoToHistoryEntityProvider, authProvider);
  }

  public static HistoryNovelsDataSource newInstance(ApiService apiService,
      HistoryDtoToHistoryEntity historyDtoToHistoryEntity, UserAuth auth) {
    return new HistoryNovelsDataSource(apiService, historyDtoToHistoryEntity, auth);
  }
}
