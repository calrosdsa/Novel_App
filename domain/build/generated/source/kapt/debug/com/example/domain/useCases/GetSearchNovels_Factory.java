package com.example.domain.useCases;

import com.example.data.repository.NovelRepository;
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
public final class GetSearchNovels_Factory implements Factory<GetSearchNovels> {
  private final Provider<NovelRepository> novelRepositoryProvider;

  public GetSearchNovels_Factory(Provider<NovelRepository> novelRepositoryProvider) {
    this.novelRepositoryProvider = novelRepositoryProvider;
  }

  @Override
  public GetSearchNovels get() {
    return newInstance(novelRepositoryProvider.get());
  }

  public static GetSearchNovels_Factory create(Provider<NovelRepository> novelRepositoryProvider) {
    return new GetSearchNovels_Factory(novelRepositoryProvider);
  }

  public static GetSearchNovels newInstance(NovelRepository novelRepository) {
    return new GetSearchNovels(novelRepository);
  }
}
