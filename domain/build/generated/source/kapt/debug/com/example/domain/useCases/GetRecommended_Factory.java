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
public final class GetRecommended_Factory implements Factory<GetRecommended> {
  private final Provider<NovelRepository> novelRepositoryProvider;

  public GetRecommended_Factory(Provider<NovelRepository> novelRepositoryProvider) {
    this.novelRepositoryProvider = novelRepositoryProvider;
  }

  @Override
  public GetRecommended get() {
    return newInstance(novelRepositoryProvider.get());
  }

  public static GetRecommended_Factory create(Provider<NovelRepository> novelRepositoryProvider) {
    return new GetRecommended_Factory(novelRepositoryProvider);
  }

  public static GetRecommended newInstance(NovelRepository novelRepository) {
    return new GetRecommended(novelRepository);
  }
}
