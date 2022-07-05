package com.example.settings;

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
public final class UserSettingsImpl_Factory implements Factory<UserSettingsImpl> {
  private final Provider<SharedPreferences> preferencesProvider;

  public UserSettingsImpl_Factory(Provider<SharedPreferences> preferencesProvider) {
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public UserSettingsImpl get() {
    return newInstance(preferencesProvider.get());
  }

  public static UserSettingsImpl_Factory create(Provider<SharedPreferences> preferencesProvider) {
    return new UserSettingsImpl_Factory(preferencesProvider);
  }

  public static UserSettingsImpl newInstance(SharedPreferences preferences) {
    return new UserSettingsImpl(preferences);
  }
}
