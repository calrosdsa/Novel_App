package com.example.data;

import com.example.data.local.NovelDatabase;
import com.example.data.local.daos.FollowingDao;
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
public final class DatabaseDaoModule_ProvideNovelFollowingFactory implements Factory<FollowingDao> {
  private final Provider<NovelDatabase> dbProvider;

  public DatabaseDaoModule_ProvideNovelFollowingFactory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FollowingDao get() {
    return provideNovelFollowing(dbProvider.get());
  }

  public static DatabaseDaoModule_ProvideNovelFollowingFactory create(
      Provider<NovelDatabase> dbProvider) {
    return new DatabaseDaoModule_ProvideNovelFollowingFactory(dbProvider);
  }

  public static FollowingDao provideNovelFollowing(NovelDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseDaoModule.INSTANCE.provideNovelFollowing(db));
  }
}
