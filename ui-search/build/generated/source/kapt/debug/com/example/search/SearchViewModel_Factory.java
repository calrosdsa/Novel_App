package com.example.search;

import com.example.data.repository.NovelRepositoryDb;
import com.example.domain.interactors.UpdateSearchHistory;
import com.example.domain.observers.ObserverSearchHistory;
import com.example.domain.observers.ObserverSearchResults;
import com.example.domain.useCases.GetSearchNovels;
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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<GetSearchNovels> getSearchNovelsProvider;

  private final Provider<NovelRepositoryDb> novelRepositoryDbProvider;

  private final Provider<ObserverSearchHistory> observerSearchHistoryProvider;

  private final Provider<UpdateSearchHistory> updateSearchHistoryProvider;

  private final Provider<ObserverSearchResults> observerSearchResultsProvider;

  public SearchViewModel_Factory(Provider<GetSearchNovels> getSearchNovelsProvider,
      Provider<NovelRepositoryDb> novelRepositoryDbProvider,
      Provider<ObserverSearchHistory> observerSearchHistoryProvider,
      Provider<UpdateSearchHistory> updateSearchHistoryProvider,
      Provider<ObserverSearchResults> observerSearchResultsProvider) {
    this.getSearchNovelsProvider = getSearchNovelsProvider;
    this.novelRepositoryDbProvider = novelRepositoryDbProvider;
    this.observerSearchHistoryProvider = observerSearchHistoryProvider;
    this.updateSearchHistoryProvider = updateSearchHistoryProvider;
    this.observerSearchResultsProvider = observerSearchResultsProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(getSearchNovelsProvider.get(), novelRepositoryDbProvider.get(), observerSearchHistoryProvider.get(), updateSearchHistoryProvider.get(), observerSearchResultsProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<GetSearchNovels> getSearchNovelsProvider,
      Provider<NovelRepositoryDb> novelRepositoryDbProvider,
      Provider<ObserverSearchHistory> observerSearchHistoryProvider,
      Provider<UpdateSearchHistory> updateSearchHistoryProvider,
      Provider<ObserverSearchResults> observerSearchResultsProvider) {
    return new SearchViewModel_Factory(getSearchNovelsProvider, novelRepositoryDbProvider, observerSearchHistoryProvider, updateSearchHistoryProvider, observerSearchResultsProvider);
  }

  public static SearchViewModel newInstance(GetSearchNovels getSearchNovels,
      NovelRepositoryDb novelRepositoryDb, ObserverSearchHistory observerSearchHistory,
      UpdateSearchHistory updateSearchHistory, ObserverSearchResults observerSearchResults) {
    return new SearchViewModel(getSearchNovels, novelRepositoryDb, observerSearchHistory, updateSearchHistory, observerSearchResults);
  }
}
