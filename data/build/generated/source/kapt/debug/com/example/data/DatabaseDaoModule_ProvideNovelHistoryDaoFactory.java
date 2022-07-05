package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.NovelHistoryDao;
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
public final class DatabaseDaoModule_ProvideNovelHistoryDaoFactory implements Factory<NovelHistoryDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideNovelHistoryDaoFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NovelHistoryDao get() {
    return provideNovelHistoryDao(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideNovelHistoryDaoFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideNovelHistoryDaoFactory(dbProvider);
  }

  public static NovelHistoryDao provideNovelHistoryDao(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideNovelHistoryDao(db));
  }
}
