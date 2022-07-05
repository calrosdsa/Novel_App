package com.example.profile;

import android.content.SharedPreferences;
import com.example.domain.UserAuth;
import com.example.domain.useCases.GetProfile;
import com.example.settings.UserSettings;
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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<GetProfile> getProfileProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<UserAuth> userAuthProvider;

  private final Provider<UserSettings> userSettingsProvider;

  public ProfileViewModel_Factory(Provider<GetProfile> getProfileProvider,
      Provider<SharedPreferences> preferencesProvider, Provider<UserAuth> userAuthProvider,
      Provider<UserSettings> userSettingsProvider) {
    this.getProfileProvider = getProfileProvider;
    this.preferencesProvider = preferencesProvider;
    this.userAuthProvider = userAuthProvider;
    this.userSettingsProvider = userSettingsProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(getProfileProvider.get(), preferencesProvider.get(), userAuthProvider.get(), userSettingsProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<GetProfile> getProfileProvider,
      Provider<SharedPreferences> preferencesProvider, Provider<UserAuth> userAuthProvider,
      Provider<UserSettings> userSettingsProvider) {
    return new ProfileViewModel_Factory(getProfileProvider, preferencesProvider, userAuthProvider, userSettingsProvider);
  }

  public static ProfileViewModel newInstance(GetProfile getProfile, SharedPreferences preferences,
      UserAuth userAuth, UserSettings userSettings) {
    return new ProfileViewModel(getProfile, preferences, userAuth, userSettings);
  }
}
