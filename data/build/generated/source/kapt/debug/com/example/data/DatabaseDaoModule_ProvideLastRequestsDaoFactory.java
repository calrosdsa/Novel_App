package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.LastRequestDao;
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
public final class DatabaseDaoModule_ProvideLastRequestsDaoFactory implements Factory<LastRequestDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideLastRequestsDaoFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public LastRequestDao get() {
    return provideLastRequestsDao(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideLastRequestsDaoFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideLastRequestsDaoFactory(dbProvider);
  }

  public static LastRequestDao provideLastRequestsDao(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideLastRequestsDao(db));
  }
}
