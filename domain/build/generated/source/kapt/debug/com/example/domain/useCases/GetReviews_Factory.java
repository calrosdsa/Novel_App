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
public final class GetReviews_Factory implements Factory<GetReviews> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetReviews_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetReviews get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetReviews_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetReviews_Factory(repositoryProvider);
  }

  public static GetReviews newInstance(NovelRepository repository) {
    return new GetReviews(repository);
  }
}
