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
public final class ObserverChapter_Factory implements Factory<ObserverChapter> {
  private final Provider<ChapterDao> chapterDaoProvider;

  public ObserverChapter_Factory(Provider<ChapterDao> chapterDaoProvider) {
    this.chapterDaoProvider = chapterDaoProvider;
  }

  @Override
  public ObserverChapter get() {
    return newInstance(chapterDaoProvider.get());
  }

  public static ObserverChapter_Factory create(Provider<ChapterDao> chapterDaoProvider) {
    return new ObserverChapter_Factory(chapterDaoProvider);
  }

  public static ObserverChapter newInstance(ChapterDao chapterDao) {
    return new ObserverChapter(chapterDao);
  }
}
