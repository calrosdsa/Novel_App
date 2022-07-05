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
public final class GetBrowseResults_Factory implements Factory<GetBrowseResults> {
  private final Provider<NovelRepository> novelRepositoryProvider;

  public GetBrowseResults_Factory(Provider<NovelRepository> novelRepositoryProvider) {
    this.novelRepositoryProvider = novelRepositoryProvider;
  }

  @Override
  public GetBrowseResults get() {
    return newInstance(novelRepositoryProvider.get());
  }

  public static GetBrowseResults_Factory create(Provider<NovelRepository> novelRepositoryProvider) {
    return new GetBrowseResults_Factory(novelRepositoryProvider);
  }

  public static GetBrowseResults newInstance(NovelRepository novelRepository) {
    return new GetBrowseResults(novelRepository);
  }
}
