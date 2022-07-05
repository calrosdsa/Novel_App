package com.example.detail;

import androidx.lifecycle.SavedStateHandle;
import com.example.domain.useCases.GetChapters;
import com.example.domain.useCases.GetNovelDetail;
import com.example.domain.useCases.GetReviews;
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
public final class NovelDetailViewModel_Factory implements Factory<NovelDetailViewModel> {
  private final Provider<GetNovelDetail> getNovelProvider;

  private final Provider<GetChapters> getChaptersProvider;

  private final Provider<GetReviews> getReviewsProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public NovelDetailViewModel_Factory(Provider<GetNovelDetail> getNovelProvider,
      Provider<GetChapters> getChaptersProvider, Provider<GetReviews> getReviewsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getNovelProvider = getNovelProvider;
    this.getChaptersProvider = getChaptersProvider;
    this.getReviewsProvider = getReviewsProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public NovelDetailViewModel get() {
    return newInstance(getNovelProvider.get(), getChaptersProvider.get(), getReviewsProvider.get(), savedStateHandleProvider.get());
  }

  public static NovelDetailViewModel_Factory create(Provider<GetNovelDetail> getNovelProvider,
      Provider<GetChapters> getChaptersProvider, Provider<GetReviews> getReviewsProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new NovelDetailViewModel_Factory(getNovelProvider, getChaptersProvider, getReviewsProvider, savedStateHandleProvider);
  }

  public static NovelDetailViewModel newInstance(GetNovelDetail getNovel, GetChapters getChapters,
      GetReviews getReviews, SavedStateHandle savedStateHandle) {
    return new NovelDetailViewModel(getNovel, getChapters, getReviews, savedStateHandle);
  }
}
