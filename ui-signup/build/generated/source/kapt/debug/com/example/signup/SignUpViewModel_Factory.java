package com.example.signup;

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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<NovelRepository> repositoryProvider;

  public SignUpViewModel_Factory(Provider<NovelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<NovelRepository> repositoryProvider) {
    return new SignUpViewModel_Factory(repositoryProvider);
  }

  public static SignUpViewModel newInstance(NovelRepository repository) {
    return new SignUpViewModel(repository);
  }
}
