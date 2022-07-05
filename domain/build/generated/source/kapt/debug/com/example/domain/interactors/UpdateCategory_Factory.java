package com.example.domain.interactors;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.entities.CategoryEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlin.Unit;

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
public final class UpdateCategory_Factory implements Factory<UpdateCategory> {
  private final Provider<Store<Unit, List<CategoryEntity>>> categoryStoreProvider;

  public UpdateCategory_Factory(Provider<Store<Unit, List<CategoryEntity>>> categoryStoreProvider) {
    this.categoryStoreProvider = categoryStoreProvider;
  }

  @Override
  public UpdateCategory get() {
    return newInstance(categoryStoreProvider.get());
  }

  public static UpdateCategory_Factory create(
      Provider<Store<Unit, List<CategoryEntity>>> categoryStoreProvider) {
    return new UpdateCategory_Factory(categoryStoreProvider);
  }

  public static UpdateCategory newInstance(Store<Unit, List<CategoryEntity>> categoryStore) {
    return new UpdateCategory(categoryStore);
  }
}
