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
public final class ObserverChapterDetail_Factory implements Factory<ObserverChapterDetail> {
  private final Provider<ChapterDao> chapterDaoProvider;

  public ObserverChapterDetail_Factory(Provider<ChapterDao> chapterDaoProvider) {
    this.chapterDaoProvider = chapterDaoProvider;
  }

  @Override
  public ObserverChapterDetail get() {
    return newInstance(chapterDaoProvider.get());
  }

  public static ObserverChapterDetail_Factory create(Provider<ChapterDao> chapterDaoProvider) {
    return new ObserverChapterDetail_Factory(chapterDaoProvider);
  }

  public static ObserverChapterDetail newInstance(ChapterDao chapterDao) {
    return new ObserverChapterDetail(chapterDao);
  }
}
