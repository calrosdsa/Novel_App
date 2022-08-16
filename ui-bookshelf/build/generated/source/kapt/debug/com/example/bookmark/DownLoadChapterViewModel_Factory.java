package com.example.bookmark;

import com.example.domain.observers.ObserverChapters;
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
public final class DownLoadChapterViewModel_Factory implements Factory<DownLoadChapterViewModel> {
  private final Provider<ObserverChapters> observerChapterProvider;

  public DownLoadChapterViewModel_Factory(Provider<ObserverChapters> observerChapterProvider) {
    this.observerChapterProvider = observerChapterProvider;
  }

  @Override
  public DownLoadChapterViewModel get() {
    return newInstance(observerChapterProvider.get());
  }

  public static DownLoadChapterViewModel_Factory create(
      Provider<ObserverChapters> observerChapterProvider) {
    return new DownLoadChapterViewModel_Factory(observerChapterProvider);
  }

  public static DownLoadChapterViewModel newInstance(ObserverChapters observerChapter) {
    return new DownLoadChapterViewModel(observerChapter);
  }
}
