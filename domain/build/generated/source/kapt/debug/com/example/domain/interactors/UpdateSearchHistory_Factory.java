package com.example.domain.interactors;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.entities.HistorySearchEntity;
import com.example.util.AppCoroutineDispatchers;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
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
public final class UpdateSearchHistory_Factory implements Factory<UpdateSearchHistory> {
  private final Provider<Store<String, List<HistorySearchEntity>>> searchResultStoreProvider;

  private final Provider<AppCoroutineDispatchers> dispatchersProvider;

  public UpdateSearchHistory_Factory(
      Provider<Store<String, List<HistorySearchEntity>>> searchResultStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    this.searchResultStoreProvider = searchResultStoreProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public UpdateSearchHistory get() {
    return newInstance(searchResultStoreProvider.get(), dispatchersProvider.get());
  }

  public static UpdateSearchHistory_Factory create(
      Provider<Store<String, List<HistorySearchEntity>>> searchResultStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    return new UpdateSearchHistory_Factory(searchResultStoreProvider, dispatchersProvider);
  }

  public static UpdateSearchHistory newInstance(
      Store<String, List<HistorySearchEntity>> searchResultStore,
      AppCoroutineDispatchers dispatchers) {
    return new UpdateSearchHistory(searchResultStore, dispatchers);
  }
}
