package com.example.domain.observers;

import com.example.data.local.daos.HistoryNovelDao;
import com.example.domain.interactors.UpdatedHistoryNovels;
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
public final class ObservableHistoryNovels_Factory implements Factory<ObservableHistoryNovels> {
  private final Provider<UpdatedHistoryNovels> updatedHistoryNovelsProvider;

  private final Provider<HistoryNovelDao> historyNovelDaoProvider;

  public ObservableHistoryNovels_Factory(
      Provider<UpdatedHistoryNovels> updatedHistoryNovelsProvider,
      Provider<HistoryNovelDao> historyNovelDaoProvider) {
    this.updatedHistoryNovelsProvider = updatedHistoryNovelsProvider;
    this.historyNovelDaoProvider = historyNovelDaoProvider;
  }

  @Override
  public ObservableHistoryNovels get() {
    return newInstance(updatedHistoryNovelsProvider.get(), historyNovelDaoProvider.get());
  }

  public static ObservableHistoryNovels_Factory create(
      Provider<UpdatedHistoryNovels> updatedHistoryNovelsProvider,
      Provider<HistoryNovelDao> historyNovelDaoProvider) {
    return new ObservableHistoryNovels_Factory(updatedHistoryNovelsProvider, historyNovelDaoProvider);
  }

  public static ObservableHistoryNovels newInstance(UpdatedHistoryNovels updatedHistoryNovels,
      HistoryNovelDao historyNovelDao) {
    return new ObservableHistoryNovels(updatedHistoryNovels, historyNovelDao);
  }
}
