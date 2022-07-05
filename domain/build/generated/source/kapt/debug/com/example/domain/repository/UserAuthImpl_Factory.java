package com.example.domain.repository;

import android.content.SharedPreferences;
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
public final class UserAuthImpl_Factory implements Factory<UserAuthImpl> {
  private final Provider<SharedPreferences> preferencesProvider;

  public UserAuthImpl_Factory(Provider<SharedPreferences> preferencesProvider) {
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public UserAuthImpl get() {
    return newInstance(preferencesProvider.get());
  }

  public static UserAuthImpl_Factory create(Provider<SharedPreferences> preferencesProvider) {
    return new UserAuthImpl_Factory(preferencesProvider);
  }

  public static UserAuthImpl newInstance(SharedPreferences preferences) {
    return new UserAuthImpl(preferences);
  }
}
