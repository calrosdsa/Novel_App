package com.example.domain.observers;

import com.example.data.local.daos.HistoryDao;
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
public final class ObserverPagedHistorySearch_Factory implements Factory<ObserverPagedHistorySearch> {
  private final Provider<HistoryDao> historyDaoProvider;

  public ObserverPagedHistorySearch_Factory(Provider<HistoryDao> historyDaoProvider) {
    this.historyDaoProvider = historyDaoProvider;
  }

  @Override
  public ObserverPagedHistorySearch get() {
    return newInstance(historyDaoProvider.get());
  }

  public static ObserverPagedHistorySearch_Factory create(Provider<HistoryDao> historyDaoProvider) {
    return new ObserverPagedHistorySearch_Factory(historyDaoProvider);
  }

  public static ObserverPagedHistorySearch newInstance(HistoryDao historyDao) {
    return new ObserverPagedHistorySearch(historyDao);
  }
}
