package com.example.data;

import com.example.data.local.daos.HistoryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseDaoModule_ProvideNovelShowHistorySearchFactory implements Factory<HistoryDao> {
  private final Provider<NovelDatabaseDao> dbProvider;

  public DatabaseDaoModule_ProvideNovelShowHistorySearchFactory(
      Provider<NovelDatabaseDao> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public HistoryDao get() {
    return provideNovelShowHistorySearch(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideNovelShowHistorySearchFactory create(
      Provider<NovelDatabaseDao> dbProvider) {
    return new DatabaseDaoModule_ProvideNovelShowHistorySearchFactory(dbProvider);
  }

  public static HistoryDao provideNovelShowHistorySearch(NovelDatabaseDao db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideNovelShowHistorySearch(db));
  }
}
