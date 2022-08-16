package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.ChapterDao;
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
public final class DatabaseDaoModule_ProvideChapterNovelDaoFactory implements Factory<ChapterDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideChapterNovelDaoFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ChapterDao get() {
    return provideChapterNovelDao(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideChapterNovelDaoFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideChapterNovelDaoFactory(dbProvider);
  }

  public static ChapterDao provideChapterNovelDao(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideChapterNovelDao(db));
  }
}
