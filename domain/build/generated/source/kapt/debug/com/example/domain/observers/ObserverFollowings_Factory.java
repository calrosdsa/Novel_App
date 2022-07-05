package com.example.domain.observers;

import com.example.data.local.daos.FollowingDao;
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
public final class ObserverFollowings_Factory implements Factory<ObserverFollowings> {
  private final Provider<FollowingDao> followingDaoProvider;

  public ObserverFollowings_Factory(Provider<FollowingDao> followingDaoProvider) {
    this.followingDaoProvider = followingDaoProvider;
  }

  @Override
  public ObserverFollowings get() {
    return newInstance(followingDaoProvider.get());
  }

  public static ObserverFollowings_Factory create(Provider<FollowingDao> followingDaoProvider) {
    return new ObserverFollowings_Factory(followingDaoProvider);
  }

  public static ObserverFollowings newInstance(FollowingDao followingDao) {
    return new ObserverFollowings(followingDao);
  }
}
