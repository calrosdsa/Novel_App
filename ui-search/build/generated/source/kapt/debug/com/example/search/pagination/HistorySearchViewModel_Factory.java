package com.example.search.pagination;

import com.example.domain.observers.ObserverPagedHistorySearch;
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
public final class HistorySearchViewModel_Factory implements Factory<HistorySearchViewModel> {
  private final Provider<ObserverPagedHistorySearch> pagingInteractorProvider;

  public HistorySearchViewModel_Factory(
      Provider<ObserverPagedHistorySearch> pagingInteractorProvider) {
    this.pagingInteractorProvider = pagingInteractorProvider;
  }

  @Override
  public HistorySearchViewModel get() {
    return newInstance(pagingInteractorProvider.get());
  }

  public static HistorySearchViewModel_Factory create(
      Provider<ObserverPagedHistorySearch> pagingInteractorProvider) {
    return new HistorySearchViewModel_Factory(pagingInteractorProvider);
  }

  public static HistorySearchViewModel newInstance(ObserverPagedHistorySearch pagingInteractor) {
    return new HistorySearchViewModel(pagingInteractor);
  }
}
