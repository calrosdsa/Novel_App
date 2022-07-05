package com.example.settings;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SettingsModuleBinds_UserSettingsFactory implements Factory<UserSettings> {
  private final Provider<SharedPreferences> preferencesProvider;

  public SettingsModuleBinds_UserSettingsFactory(Provider<SharedPreferences> preferencesProvider) {
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public UserSettings get() {
    return userSettings(preferencesProvider.get());
  }

  public static SettingsModuleBinds_UserSettingsFactory create(
      Provider<SharedPreferences> preferencesProvider) {
    return new SettingsModuleBinds_UserSettingsFactory(preferencesProvider);
  }

  public static UserSettings userSettings(SharedPreferences preferences) {
    return Preconditions.checkNotNullFromProvides(SettingsModuleBinds.INSTANCE.userSettings(preferences));
  }
}
