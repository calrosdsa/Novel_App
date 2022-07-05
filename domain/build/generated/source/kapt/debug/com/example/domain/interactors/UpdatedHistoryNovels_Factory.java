package com.example.domain.interactors;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.daos.HistoryNovelDao;
import com.example.data.local.entities.HistoryNovelEntry;
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
public final class UpdatedHistoryNovels_Factory implements Factory<UpdatedHistoryNovels> {
  private final Provider<Store<Integer, List<HistoryNovelEntry>>> historyNovelsStoreProvider;

  private final Provider<AppCoroutineDispatchers> dispatchersProvider;

  private final Provider<HistoryNovelDao> historyNovelDaoProvider;

  public UpdatedHistoryNovels_Factory(
      Provider<Store<Integer, List<HistoryNovelEntry>>> historyNovelsStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider,
      Provider<HistoryNovelDao> historyNovelDaoProvider) {
    this.historyNovelsStoreProvider = historyNovelsStoreProvider;
    this.dispatchersProvider = dispatchersProvider;
    this.historyNovelDaoProvider = historyNovelDaoProvider;
  }

  @Override
  public UpdatedHistoryNovels get() {
    return newInstance(historyNovelsStoreProvider.get(), dispatchersProvider.get(), historyNovelDaoProvider.get());
  }

  public static UpdatedHistoryNovels_Factory create(
      Provider<Store<Integer, List<HistoryNovelEntry>>> historyNovelsStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider,
      Provider<HistoryNovelDao> historyNovelDaoProvider) {
    return new UpdatedHistoryNovels_Factory(historyNovelsStoreProvider, dispatchersProvider, historyNovelDaoProvider);
  }

  public static UpdatedHistoryNovels newInstance(
      Store<Integer, List<HistoryNovelEntry>> historyNovelsStore,
      AppCoroutineDispatchers dispatchers, HistoryNovelDao historyNovelDao) {
    return new UpdatedHistoryNovels(historyNovelsStore, dispatchers, historyNovelDao);
  }
}
