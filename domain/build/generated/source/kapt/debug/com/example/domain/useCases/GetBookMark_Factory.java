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
public final class GetBookMark_Factory implements Factory<GetBookMark> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetBookMark_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetBookMark get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetBookMark_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetBookMark_Factory(repositoryProvider);
  }

  public static GetBookMark newInstance(NovelRepository repository) {
    return new GetBookMark(repository);
  }
}
