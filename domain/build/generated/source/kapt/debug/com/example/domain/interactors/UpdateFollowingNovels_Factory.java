package com.example.domain.interactors;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.entities.FollowingEntity;
import com.example.util.AppCoroutineDispatchers;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
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
public final class UpdateFollowingNovels_Factory implements Factory<UpdateFollowingNovels> {
  private final Provider<Store<String, List<FollowingEntity>>> followingStoreProvider;

  private final Provider<AppCoroutineDispatchers> dispatchersProvider;

  public UpdateFollowingNovels_Factory(
      Provider<Store<String, List<FollowingEntity>>> followingStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    this.followingStoreProvider = followingStoreProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public UpdateFollowingNovels get() {
    return newInstance(followingStoreProvider.get(), dispatchersProvider.get());
  }

  public static UpdateFollowingNovels_Factory create(
      Provider<Store<String, List<FollowingEntity>>> followingStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    return new UpdateFollowingNovels_Factory(followingStoreProvider, dispatchersProvider);
  }

  public static UpdateFollowingNovels newInstance(
      Store<String, List<FollowingEntity>> followingStore, AppCoroutineDispatchers dispatchers) {
    return new UpdateFollowingNovels(followingStore, dispatchers);
  }
}
