package com.example.chapters.chapter_detail;

import androidx.lifecycle.SavedStateHandle;
import com.example.domain.observers.ObserverChapter;
import com.example.domain.observers.ObserverChapterDetail;
import com.example.settings.UserSettings;
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
public final class ChapterDownloadViewModel_Factory implements Factory<ChapterDownloadViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UserSettings> userSettingsProvider;

  private final Provider<ObserverChapterDetail> observerChapterDetailProvider;

  private final Provider<ObserverChapter> observerChapterProvider;

  public ChapterDownloadViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserSettings> userSettingsProvider,
      Provider<ObserverChapterDetail> observerChapterDetailProvider,
      Provider<ObserverChapter> observerChapterProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.userSettingsProvider = userSettingsProvider;
    this.observerChapterDetailProvider = observerChapterDetailProvider;
    this.observerChapterProvider = observerChapterProvider;
  }

  @Override
  public ChapterDownloadViewModel get() {
    return newInstance(savedStateHandleProvider.get(), userSettingsProvider.get(), observerChapterDetailProvider.get(), observerChapterProvider.get());
  }

  public static ChapterDownloadViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserSettings> userSettingsProvider,
      Provider<ObserverChapterDetail> observerChapterDetailProvider,
      Provider<ObserverChapter> observerChapterProvider) {
    return new ChapterDownloadViewModel_Factory(savedStateHandleProvider, userSettingsProvider, observerChapterDetailProvider, observerChapterProvider);
  }

  public static ChapterDownloadViewModel newInstance(SavedStateHandle savedStateHandle,
      UserSettings userSettings, ObserverChapterDetail observerChapterDetail,
      ObserverChapter observerChapter) {
    return new ChapterDownloadViewModel(savedStateHandle, userSettings, observerChapterDetail, observerChapter);
  }
}
