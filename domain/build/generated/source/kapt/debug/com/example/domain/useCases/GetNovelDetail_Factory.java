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
public final class GetNovelDetail_Factory implements Factory<GetNovelDetail> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetNovelDetail_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetNovelDetail get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetNovelDetail_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetNovelDetail_Factory(repositoryProvider);
  }

  public static GetNovelDetail newInstance(NovelRepository repository) {
    return new GetNovelDetail(repository);
  }
}
