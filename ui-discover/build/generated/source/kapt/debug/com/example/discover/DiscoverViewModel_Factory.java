package com.example.discover;

import androidx.lifecycle.SavedStateHandle;
import com.example.data.remote.ApiService;
import com.example.domain.interactors.UpdateCategory;
import com.example.domain.observers.ObserverCategory;
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
public final class DiscoverViewModel_Factory implements Factory<DiscoverViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<UpdateCategory> updateCategoryProvider;

  private final Provider<ApiService> apiServiceProvider;

  private final Provider<ObserverCategory> observerCategoryProvider;

  public DiscoverViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UpdateCategory> updateCategoryProvider, Provider<ApiService> apiServiceProvider,
      Provider<ObserverCategory> observerCategoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.updateCategoryProvider = updateCategoryProvider;
    this.apiServiceProvider = apiServiceProvider;
    this.observerCategoryProvider = observerCategoryProvider;
  }

  @Override
  public DiscoverViewModel get() {
    return newInstance(savedStateHandleProvider.get(), updateCategoryProvider.get(), apiServiceProvider.get(), observerCategoryProvider.get());
  }

  public static DiscoverViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<UpdateCategory> updateCategoryProvider, Provider<ApiService> apiServiceProvider,
      Provider<ObserverCategory> observerCategoryProvider) {
    return new DiscoverViewModel_Factory(savedStateHandleProvider, updateCategoryProvider, apiServiceProvider, observerCategoryProvider);
  }

  public static DiscoverViewModel newInstance(SavedStateHandle savedStateHandle,
      UpdateCategory updateCategory, ApiService apiService, ObserverCategory observerCategory) {
    return new DiscoverViewModel(savedStateHandle, updateCategory, apiService, observerCategory);
  }
}
