package com.example.domain.observers;

import com.example.data.local.daos.ChapterDao;
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
public final class ObserverChapters_Factory implements Factory<ObserverChapters> {
  private final Provider<ChapterDao> chapterDaoProvider;

  public ObserverChapters_Factory(Provider<ChapterDao> chapterDaoProvider) {
    this.chapterDaoProvider = chapterDaoProvider;
  }

  @Override
  public ObserverChapters get() {
    return newInstance(chapterDaoProvider.get());
  }

  public static ObserverChapters_Factory create(Provider<ChapterDao> chapterDaoProvider) {
    return new ObserverChapters_Factory(chapterDaoProvider);
  }

  public static ObserverChapters newInstance(ChapterDao chapterDao) {
    return new ObserverChapters(chapterDao);
  }
}
