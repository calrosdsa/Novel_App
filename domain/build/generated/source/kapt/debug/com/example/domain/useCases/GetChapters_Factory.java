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
public final class GetChapters_Factory implements Factory<GetChapters> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetChapters_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetChapters get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetChapters_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetChapters_Factory(repositoryProvider);
  }

  public static GetChapters newInstance(NovelRepository repository) {
    return new GetChapters(repository);
  }
}
