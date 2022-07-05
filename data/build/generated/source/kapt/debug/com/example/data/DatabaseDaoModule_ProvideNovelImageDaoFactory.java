package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.NovelImageDao;
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
public final class DatabaseDaoModule_ProvideNovelImageDaoFactory implements Factory<NovelImageDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideNovelImageDaoFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NovelImageDao get() {
    return provideNovelImageDao(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideNovelImageDaoFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideNovelImageDaoFactory(dbProvider);
  }

  public static NovelImageDao provideNovelImageDao(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideNovelImageDao(db));
  }
}
