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
public final class GetProfile_Factory implements Factory<GetProfile> {
  private final Provider<NovelRepository> repositoryProvider;

  public GetProfile_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetProfile get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetProfile_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new GetProfile_Factory(repositoryProvider);
  }

  public static GetProfile newInstance(NovelRepository repository) {
    return new GetProfile(repository);
  }
}
