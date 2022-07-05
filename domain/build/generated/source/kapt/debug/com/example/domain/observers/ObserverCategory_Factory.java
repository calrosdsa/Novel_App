package com.example.domain.observers;

import com.example.data.local.daos.CategoryDao;
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
public final class ObserverCategory_Factory implements Factory<ObserverCategory> {
  private final Provider<CategoryDao> categoryDaoProvider;

  public ObserverCategory_Factory(Provider<CategoryDao> categoryDaoProvider) {
    this.categoryDaoProvider = categoryDaoProvider;
  }

  @Override
  public ObserverCategory get() {
    return newInstance(categoryDaoProvider.get());
  }

  public static ObserverCategory_Factory create(Provider<CategoryDao> categoryDaoProvider) {
    return new ObserverCategory_Factory(categoryDaoProvider);
  }

  public static ObserverCategory newInstance(CategoryDao categoryDao) {
    return new ObserverCategory(categoryDao);
  }
}
