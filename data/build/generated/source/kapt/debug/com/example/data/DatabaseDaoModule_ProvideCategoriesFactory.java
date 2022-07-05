package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.CategoryDao;
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
public final class DatabaseDaoModule_ProvideCategoriesFactory implements Factory<CategoryDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideCategoriesFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CategoryDao get() {
    return provideCategories(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideCategoriesFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideCategoriesFactory(dbProvider);
  }

  public static CategoryDao provideCategories(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideCategories(db));
  }
}
