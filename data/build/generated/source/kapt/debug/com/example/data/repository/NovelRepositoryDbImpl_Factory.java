package com.example.data.repository;

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
public final class NovelRepositoryDbImpl_Factory implements Factory<NovelRepositoryDbImpl> {
  private final Provider<HistoryDao> historyDaoProvider;

  public NovelRepositoryDbImpl_Factory(Provider<HistoryDao> historyDaoProvider) {
    this.historyDaoProvider = historyDaoProvider;
  }

  @Override
  public NovelRepositoryDbImpl get() {
    return newInstance(historyDaoProvider.get());
  }

  public static NovelRepositoryDbImpl_Factory create(Provider<HistoryDao> historyDaoProvider) {
    return new NovelRepositoryDbImpl_Factory(historyDaoProvider);
  }

  public static NovelRepositoryDbImpl newInstance(HistoryDao historyDao) {
    return new NovelRepositoryDbImpl(historyDao);
  }
}
