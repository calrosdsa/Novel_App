package com.example.chapters.chapter_detail;

import androidx.lifecycle.SavedStateHandle;
import com.example.data.remote.ApiService;
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
public final class ChapterViewModel_Factory implements Factory<ChapterViewModel> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UserSettings> userSettingsProvider;

  public ChapterViewModel_Factory(Provider<ApiService> apiServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserSettings> userSettingsProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.userSettingsProvider = userSettingsProvider;
  }

  @Override
  public ChapterViewModel get() {
    return newInstance(apiServiceProvider.get(), savedStateHandleProvider.get(), userSettingsProvider.get());
  }

  public static ChapterViewModel_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UserSettings> userSettingsProvider) {
    return new ChapterViewModel_Factory(apiServiceProvider, savedStateHandleProvider, userSettingsProvider);
  }

  public static ChapterViewModel newInstance(ApiService apiService,
      SavedStateHandle savedStateHandle, UserSettings userSettings) {
    return new ChapterViewModel(apiService, savedStateHandle, userSettings);
  }
}
