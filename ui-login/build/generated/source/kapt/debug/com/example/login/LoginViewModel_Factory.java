package com.example.login;

import com.example.data.repository.NovelRepository;
import com.example.domain.interactors.UpdateFollowingNovels;
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
  private final Provider<NovelRepository> repositoryProvider;

  private final Provider<UpdateFollowingNovels> updateFollowingNovelsProvider;

  public LoginViewModel_Factory(Provider<NovelRepository> repositoryProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider) {
    this.repositoryProvider = repositoryProvider;
    this.updateFollowingNovelsProvider = updateFollowingNovelsProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(repositoryProvider.get(), updateFollowingNovelsProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<NovelRepository> repositoryProvider,
      Provider<UpdateFollowingNovels> updateFollowingNovelsProvider) {
    return new LoginViewModel_Factory(repositoryProvider, updateFollowingNovelsProvider);
  }

  public static LoginViewModel newInstance(NovelRepository repository,
      UpdateFollowingNovels updateFollowingNovels) {
    return new LoginViewModel(repository, updateFollowingNovels);
  }
}
