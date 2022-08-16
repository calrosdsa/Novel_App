package com.example.signup;

import android.content.Context;
import com.example.data.repository.NovelRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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

  private final Provider<Context> contextProvider;

  public SignUpViewModel_Factory(Provider<NovelRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    this.repositoryProvider = repositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(repositoryProvider.get(), contextProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<NovelRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    return new SignUpViewModel_Factory(repositoryProvider, contextProvider);
  }

  public static SignUpViewModel newInstance(NovelRepository repository, Context context) {
    return new SignUpViewModel(repository, context);
  }
}
