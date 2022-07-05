package com.example.domain.interactors;

import com.dropbox.android.external.store4.Store;
import com.example.data.local.entities.FollowingEntity;
import com.example.data.remote.ApiService;
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
public final class UpdatedOptionsBookMark_Factory implements Factory<UpdatedOptionsBookMark> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<Store<String, List<FollowingEntity>>> followingStoreProvider;

  private final Provider<AppCoroutineDispatchers> dispatchersProvider;

  public UpdatedOptionsBookMark_Factory(Provider<ApiService> apiServiceProvider,
      Provider<Store<String, List<FollowingEntity>>> followingStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.followingStoreProvider = followingStoreProvider;
    this.dispatchersProvider = dispatchersProvider;
  }

  @Override
  public UpdatedOptionsBookMark get() {
    return newInstance(apiServiceProvider.get(), followingStoreProvider.get(), dispatchersProvider.get());
  }

  public static UpdatedOptionsBookMark_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<Store<String, List<FollowingEntity>>> followingStoreProvider,
      Provider<AppCoroutineDispatchers> dispatchersProvider) {
    return new UpdatedOptionsBookMark_Factory(apiServiceProvider, followingStoreProvider, dispatchersProvider);
  }

  public static UpdatedOptionsBookMark newInstance(ApiService apiService,
      Store<String, List<FollowingEntity>> followingStore, AppCoroutineDispatchers dispatchers) {
    return new UpdatedOptionsBookMark(apiService, followingStore, dispatchers);
  }
}
