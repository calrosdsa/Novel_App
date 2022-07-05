package com.example.domain.observers;

import com.example.data.local.daos.HistoryDao;
import com.example.util.AppCoroutineDispatchers;
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
public final class ObserverSearchResults_Factory implements Factory<ObserverSearchResults> {
  private final Provider<HistoryDao> historyDaoProvider;

  private final Provider<AppCoroutineDispatchers> dispatchersProvider;

  public ObserverSearchResults_Factory(Provider<HistoryDao> historyDaoProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    this.historyDaoProvider = historyDaoProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public ObserverSearchResults get() {
    return newInstance(historyDaoProvider.get(), dispatchersProvider.get());
  }

  public static ObserverSearchResults_Factory create(Provider<HistoryDao> historyDaoProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    return new ObserverSearchResults_Factory(historyDaoProvider, dispatchersProvider);
  }

  public static ObserverSearchResults newInstance(HistoryDao historyDao,
      AppCoroutineDispatchers dispatchers) {
    return new ObserverSearchResults(historyDao, dispatchers);
  }
}
