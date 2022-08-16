package com.example.chapters.indice;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.example.data.local.daos.ChapterDao;
import com.example.data.local.daos.NovelImageDao;
import com.example.data.remote.ApiService;
import com.example.data.repository.NovelUtil;
import com.example.domain.observers.ObserverChapter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChaptersViewModel_Factory implements Factory<ChaptersViewModel> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<ObserverChapter> observerChaptersProvider;

  private final Provider<NovelUtil> novelUtilProvider;

  private final Provider<Context> contextProvider;

  private final Provider<ChapterDao> chapterDaoProvider;

  private final Provider<NovelImageDao> novelImageDaoProvider;

  public ChaptersViewModel_Factory(Provider<ApiService> apiServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<ObserverChapter> observerChaptersProvider, Provider<NovelUtil> novelUtilProvider,
      Provider<Context> contextProvider, Provider<ChapterDao> chapterDaoProvider,
      Provider<NovelImageDao> novelImageDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.observerChaptersProvider = observerChaptersProvider;
    this.novelUtilProvider = novelUtilProvider;
    this.contextProvider = contextProvider;
    this.chapterDaoProvider = chapterDaoProvider;
    this.novelImageDaoProvider = novelImageDaoProvider;
  }

  @Override
  public ChaptersViewModel get() {
    return newInstance(apiServiceProvider.get(), savedStateHandleProvider.get(), observerChaptersProvider.get(), novelUtilProvider.get(), contextProvider.get(), chapterDaoProvider.get(), novelImageDaoProvider.get());
  }

  public static ChaptersViewModel_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<ObserverChapter> observerChaptersProvider, Provider<NovelUtil> novelUtilProvider,
      Provider<Context> contextProvider, Provider<ChapterDao> chapterDaoProvider,
      Provider<NovelImageDao> novelImageDaoProvider) {
    return new ChaptersViewModel_Factory(apiServiceProvider, savedStateHandleProvider, observerChaptersProvider, novelUtilProvider, contextProvider, chapterDaoProvider, novelImageDaoProvider);
  }

  public static ChaptersViewModel newInstance(ApiService apiService,
      SavedStateHandle savedStateHandle, ObserverChapter observerChapters, NovelUtil novelUtil,
      Context context, ChapterDao chapterDao, NovelImageDao novelImageDao) {
    return new ChaptersViewModel(apiService, savedStateHandle, observerChapters, novelUtil, context, chapterDao, novelImageDao);
  }
}
