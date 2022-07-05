package com.example.settings;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SettingsActivity_MembersInjector implements MembersInjector<SettingsActivity> {
  private final Provider<UserSettings> userSettingsProvider;

  public SettingsActivity_MembersInjector(Provider<UserSettings> userSettingsProvider) {
    this.userSettingsProvider = userSettingsProvider;
  }

  public static MembersInjector<SettingsActivity> create(
      Provider<UserSettings> userSettingsProvider) {
    return new SettingsActivity_MembersInjector(userSettingsProvider);
  }

  @Override
  public void injectMembers(SettingsActivity instance) {
    injectUserSettings(instance, userSettingsProvider.get());
  }

  @InjectedFieldSignature("com.example.settings.SettingsActivity.userSettings")
  public static void injectUserSettings(SettingsActivity instance, UserSettings userSettings) {
    instance.userSettings = userSettings;
  }
}
