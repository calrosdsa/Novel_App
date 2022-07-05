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
public final class GetNovels_Factory implements Factory<GetNovels> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetNovels_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetNovels get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetNovels_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetNovels_Factory(repositoryProvider);
  }

  public static GetNovels newInstance(NovelRepository repository) {
    return new GetNovels(repository);
  }
}
