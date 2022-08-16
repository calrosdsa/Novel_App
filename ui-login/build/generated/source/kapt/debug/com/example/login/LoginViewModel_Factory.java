package com.example.login;

import com.example.domain.interactors.UpdateFollowingNovels;
import com.example.domain.useCases.LoginUseCase;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<UpdateFollowingNovels> updateFollowingNovelsProvider;

  private final Provider<LoginUseCase> loginUseCaseProvider;

  public LoginViewModel_Factory(Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<LoginUseCase> loginUseCaseProvider) {
    this.updateFollowingNovelsProvider = updateFollowingNovelsProvider;
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(updateFollowingNovelsProvider.get(), loginUseCaseProvider.get());
  }

  public static LoginViewModel_Factory create(
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider,
      Provider<LoginUseCase> loginUseCaseProvider) {
    return new LoginViewModel_Factory(updateFollowingNovelsProvider, loginUseCaseProvider);
  }

  public static LoginViewModel newInstance(UpdateFollowingNovels updateFollowingNovels,
      LoginUseCase loginUseCase) {
    return new LoginViewModel(updateFollowingNovels, loginUseCase);
  }
}
