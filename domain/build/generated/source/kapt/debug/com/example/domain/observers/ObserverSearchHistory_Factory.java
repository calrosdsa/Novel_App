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
public final class ObserverSearchHistory_Factory implements Factory<ObserverSearchHistory> {
  private final Provider<HistoryDao> historyDaoProvider;

  public ObserverSearchHistory_Factory(Provider<HistoryDao> historyDaoProvider) {
    this.historyDaoProvider = historyDaoProvider;
  }

  @Override
  public ObserverSearchHistory get() {
    return newInstance(historyDaoProvider.get());
  }

  public static ObserverSearchHistory_Factory create(Provider<HistoryDao> historyDaoProvider) {
    return new ObserverSearchHistory_Factory(historyDaoProvider);
  }

  public static ObserverSearchHistory newInstance(HistoryDao historyDao) {
    return new ObserverSearchHistory(historyDao);
  }
}
