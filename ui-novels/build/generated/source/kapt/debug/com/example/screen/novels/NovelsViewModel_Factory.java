package com.example.screen.novels;

import com.example.domain.useCases.GetNovels;
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
public final class NovelsViewModel_Factory implements Factory<NovelsViewModel> {
  private final Provider<GetNovels> getNovelUseCaseProvider;

  public NovelsViewModel_Factory(Provider<GetNovels> getNovelUseCaseProvider) {
    this.getNovelUseCaseProvider = getNovelUseCaseProvider;
  }

  @Override
  public NovelsViewModel get() {
    return newInstance(getNovelUseCaseProvider.get());
  }

  public static NovelsViewModel_Factory create(Provider<GetNovels> getNovelUseCaseProvider) {
    return new NovelsViewModel_Factory(getNovelUseCaseProvider);
  }

  public static NovelsViewModel newInstance(GetNovels getNovelUseCase) {
    return new NovelsViewModel(getNovelUseCase);
  }
}
