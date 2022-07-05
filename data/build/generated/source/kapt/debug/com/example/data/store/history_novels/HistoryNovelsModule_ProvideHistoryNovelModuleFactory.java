package com.example.data.store.history_novels;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.daos.HistoryNovelDao;
import com.example.data.local.daos.NovelHistoryDao;
import com.example.data.local.entities.HistoryNovelEntry;
import com.example.data.repository.history_novels.HistoryNovelShowsLastRequestStore;
import com.example.data.repository.history_novels.HistoryNovelsDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class HistoryNovelsModule_ProvideHistoryNovelModuleFactory implements Factory<Store<Integer, List<HistoryNovelEntry>>> {
  private final Provider<HistoryNovelDao> historyNovelDaoProvider;

  private final Provider<NovelHistoryDao> novelHistoryDaoProvider;

  private final Provider<HistoryNovelsDataSource> historyNovelsDataSourceProvider;

  private final Provider<HistoryNovelShowsLastRequestStore> lastRequestStoreProvider;

  public HistoryNovelsModule_ProvideHistoryNovelModuleFactory(
      Provider<HistoryNovelDao> historyNovelDaoProvider,
      Provider<NovelHistoryDao> novelHistoryDaoProvider,
      Provider<HistoryNovelsDataSource> historyNovelsDataSourceProvider,
      Provider<HistoryNovelShowsLastRequestStore> lastRequestStoreProvider) {
    this.historyNovelDaoProvider = historyNovelDaoProvider;
    this.novelHistoryDaoProvider = novelHistoryDaoProvider;
    this.historyNovelsDataSourceProvider = historyNovelsDataSourceProvider;
    this.lastRequestStoreProvider = lastRequestStoreProvider;
  }

  @Override
  public Store<Integer, List<HistoryNovelEntry>> get() {
    return provideHistoryNovelModule(historyNovelDaoProvider.get(), novelHistoryDaoProvider.get(), historyNovelsDataSourceProvider.get(), lastRequestStoreProvider.get());
  }

  public static HistoryNovelsModule_ProvideHistoryNovelModuleFactory create(
      Provider<HistoryNovelDao> historyNovelDaoProvider,
      Provider<NovelHistoryDao> novelHistoryDaoProvider,
      Provider<HistoryNovelsDataSource> historyNovelsDataSourceProvider,
      Provider<HistoryNovelShowsLastRequestStore> lastRequestStoreProvider) {
    return new HistoryNovelsModule_ProvideHistoryNovelModuleFactory(historyNovelDaoProvider, novelHistoryDaoProvider, historyNovelsDataSourceProvider, lastRequestStoreProvider);
  }

  public static Store<Integer, List<HistoryNovelEntry>> provideHistoryNovelModule(
      HistoryNovelDao historyNovelDao, NovelHistoryDao novelHistoryDao,
      HistoryNovelsDataSource historyNovelsDataSource,
      HistoryNovelShowsLastRequestStore lastRequestStore) {
    return Preconditions.checkNotNullFromProvides(HistoryNovelsModule.INSTANCE.provideHistoryNovelModule(historyNovelDao, novelHistoryDao, historyNovelsDataSource, lastRequestStore));
  }
}
