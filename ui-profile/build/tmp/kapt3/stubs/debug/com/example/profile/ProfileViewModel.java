package com.example.profile;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.example.domain.UserAuth;
import com.example.domain.resources.Resource;
import com.example.domain.useCases.GetProfile;
import com.example.settings.AppTheme;
import com.example.settings.UserSettings;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\'J\u0006\u0010)\u001a\u00020\'J\u000e\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\'J\u0006\u0010.\u001a\u00020\'J\u0006\u0010/\u001a\u00020\'R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/example/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "getProfile", "Lcom/example/domain/useCases/GetProfile;", "preferences", "Landroid/content/SharedPreferences;", "userAuth", "Lcom/example/domain/UserAuth;", "userSettings", "Lcom/example/settings/UserSettings;", "(Lcom/example/domain/useCases/GetProfile;Landroid/content/SharedPreferences;Lcom/example/domain/UserAuth;Lcom/example/settings/UserSettings;)V", "<set-?>", "", "count", "getCount", "()I", "setCount", "(I)V", "count$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/example/profile/ProfileState;", "state", "getState", "()Lcom/example/profile/ProfileState;", "setState", "(Lcom/example/profile/ProfileState;)V", "state$delegate", "themeMode", "getThemeMode", "()Lcom/example/settings/UserSettings;", "tokenKey", "", "tokenString", "getTokenString", "()Ljava/lang/String;", "setTokenString", "(Ljava/lang/String;)V", "tokenString$delegate", "clearPreferences", "", "getTheme", "getToken", "onChangeMode", "value", "Lcom/example/settings/AppTheme;", "onStart", "onStop", "profile", "ui-profile_debug"})
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.domain.useCases.GetProfile getProfile = null;
    private final android.content.SharedPreferences preferences = null;
    private final com.example.settings.UserSettings userSettings = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState state$delegate = null;
    private final androidx.compose.runtime.MutableState tokenString$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState count$delegate = null;
    private final java.lang.String tokenKey = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettings themeMode = null;
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    com.example.domain.useCases.GetProfile getProfile, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences preferences, @org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth userAuth, @org.jetbrains.annotations.NotNull()
    com.example.settings.UserSettings userSettings) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.profile.ProfileState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    com.example.profile.ProfileState p0) {
    }
    
    private final java.lang.String getTokenString() {
        return null;
    }
    
    private final void setTokenString(java.lang.String p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.settings.UserSettings getThemeMode() {
        return null;
    }
    
    public final void getTheme() {
    }
    
    public final void onStart() {
    }
    
    public final void onChangeMode(@org.jetbrains.annotations.NotNull()
    com.example.settings.AppTheme value) {
    }
    
    public final void onStop() {
    }
    
    public final void profile() {
    }
    
    public final void clearPreferences() {
    }
    
    public final void getToken() {
    }
}