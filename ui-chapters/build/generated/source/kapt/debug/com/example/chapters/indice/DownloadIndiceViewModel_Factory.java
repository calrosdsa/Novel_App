package com.example.chapters.indice;

import androidx.lifecycle.SavedStateHandle;
import com.example.data.local.daos.ChapterDao;
import com.example.data.local.daos.NovelImageDao;
import com.example.domain.observers.ObserverChapter;
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
public final class DownloadIndiceViewModel_Factory implements Factory<DownloadIndiceViewModel> {
  private final Provider<ObserverChapter> observerChapterProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<ChapterDao> chapterDaoProvider;

  private final Provider<NovelImageDao> imageDaoProvider;

  public DownloadIndiceViewModel_Factory(Provider<ObserverChapter> observerChapterProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<ChapterDao> chapterDaoProvider,
      Provider<NovelImageDao> imageDaoProvider) {
    this.observerChapterProvider = observerChapterProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.chapterDaoProvider = chapterDaoProvider;
    this.imageDaoProvider = imageDaoProvider;
  }

  @Override
  public DownloadIndiceViewModel get() {
    return newInstance(observerChapterProvider.get(), savedStateHandleProvider.get(), chapterDaoProvider.get(), imageDaoProvider.get());
  }

  public static DownloadIndiceViewModel_Factory create(
      Provider<ObserverChapter> observerChapterProvider,
      Provider<SavedStateHandle> savedStateHandleProvider, Provider<ChapterDao> chapterDaoProvider,
      Provider<NovelImageDao> imageDaoProvider) {
    return new DownloadIndiceViewModel_Factory(observerChapterProvider, savedStateHandleProvider, chapterDaoProvider, imageDaoProvider);
  }

  public static DownloadIndiceViewModel newInstance(ObserverChapter observerChapter,
      SavedStateHandle savedStateHandle, ChapterDao chapterDao, NovelImageDao imageDao) {
    return new DownloadIndiceViewModel(observerChapter, savedStateHandle, chapterDao, imageDao);
  }
}
