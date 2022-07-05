package com.example.data.store.history_search;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.daos.HistoryDao;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
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
public final class SearchModule_ProvideSearchModuleFactory implements Factory<Store<String, List<HistorySearchEntity>>> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<HistoryDao> historyDaoProvider;

  public SearchModule_ProvideSearchModuleFactory(Provider<ApiService> apiServiceProvider,
      Provider<HistoryDao> historyDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.historyDaoProvider = historyDaoProvider;
  }

  @Override
  public Store<String, List<HistorySearchEntity>> get() {
    return provideSearchModule(apiServiceProvider.get(), historyDaoProvider.get());
  }

  public static SearchModule_ProvideSearchModuleFactory create(
      Provider<ApiService> apiServiceProvider, Provider<HistoryDao> historyDaoProvider) {
    return new SearchModule_ProvideSearchModuleFactory(apiServiceProvider, historyDaoProvider);
  }

  public static Store<String, List<HistorySearchEntity>> provideSearchModule(ApiService apiService,
      HistoryDao historyDao) {
    return Preconditions.checkNotNullFromProvides(SearchModule.INSTANCE.provideSearchModule(apiService, historyDao));
  }
}
