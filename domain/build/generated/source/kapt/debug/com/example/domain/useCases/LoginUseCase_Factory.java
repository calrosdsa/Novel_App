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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<NovelRepository> novelRepositoryProvider;

  public LoginUseCase_Factory(Provider<NovelRepository> novelRepositoryProvider) {
    this.novelRepositoryProvider = novelRepositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(novelRepositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<NovelRepository> novelRepositoryProvider) {
    return new LoginUseCase_Factory(novelRepositoryProvider);
  }

  public static LoginUseCase newInstance(NovelRepository novelRepository) {
    return new LoginUseCase(novelRepository);
  }
}
