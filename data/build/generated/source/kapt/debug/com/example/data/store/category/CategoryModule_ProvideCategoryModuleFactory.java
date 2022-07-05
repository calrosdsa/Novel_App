package com.example.data.store.category;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.daos.CategoryDao;
import com.example.data.local.entities.CategoryEntity;
import com.example.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlin.Unit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class CategoryModule_ProvideCategoryModuleFactory implements Factory<Store<Unit, List<CategoryEntity>>> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  public CategoryModule_ProvideCategoryModuleFactory(Provider<ApiService> apiServiceProvider,
      Provider<CategoryDao> categoryDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.categoryDaoProvider = categoryDaoProvider;
  }

  @Override
  public Store<Unit, List<CategoryEntity>> get() {
    return provideCategoryModule(apiServiceProvider.get(), categoryDaoProvider.get());
  }

  public static CategoryModule_ProvideCategoryModuleFactory create(
      Provider<ApiService> apiServiceProvider, Provider<CategoryDao> categoryDaoProvider) {
    return new CategoryModule_ProvideCategoryModuleFactory(apiServiceProvider, categoryDaoProvider);
  }

  public static Store<Unit, List<CategoryEntity>> provideCategoryModule(ApiService apiService,
      CategoryDao categoryDao) {
    return Preconditions.checkNotNullFromProvides(CategoryModule.INSTANCE.provideCategoryModule(apiService, categoryDao));
  }
}
