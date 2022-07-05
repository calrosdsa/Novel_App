package com.example.data.repository.history_novels;

import com.example.data.local.daos.LastRequestDao;
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
public final class HistoryNovelShowsLastRequestStore_Factory implements Factory<HistoryNovelShowsLastRequestStore> {
  private final Provider<LastRequestDao> daoProvider;

  public HistoryNovelShowsLastRequestStore_Factory(Provider<LastRequestDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public HistoryNovelShowsLastRequestStore get() {
    return newInstance(daoProvider.get());
  }

  public static HistoryNovelShowsLastRequestStore_Factory create(
      Provider<LastRequestDao> daoProvider) {
    return new HistoryNovelShowsLastRequestStore_Factory(daoProvider);
  }

  public static HistoryNovelShowsLastRequestStore newInstance(LastRequestDao dao) {
    return new HistoryNovelShowsLastRequestStore(dao);
  }
}
