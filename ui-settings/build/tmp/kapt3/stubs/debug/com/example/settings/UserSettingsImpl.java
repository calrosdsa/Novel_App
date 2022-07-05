package com.example.settings;

import android.content.SharedPreferences;
import javax.inject.Inject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/example/settings/UserSettingsImpl;", "Lcom/example/settings/UserSettings;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "<set-?>", "Lcom/example/settings/Language;", "language", "getLanguage", "()Lcom/example/settings/Language;", "setLanguage", "(Lcom/example/settings/Language;)V", "language$delegate", "Lcom/example/settings/UserSettingsImpl$LanguagePreferenceDelegate;", "languageStream", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getLanguageStream", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/settings/AppTheme;", "theme", "getTheme", "()Lcom/example/settings/AppTheme;", "setTheme", "(Lcom/example/settings/AppTheme;)V", "theme$delegate", "Lcom/example/settings/UserSettingsImpl$AppThemePreferenceDelegate;", "themeStream", "getThemeStream", "AppThemePreferenceDelegate", "LanguagePreferenceDelegate", "ui-settings_debug"})
public final class UserSettingsImpl implements com.example.settings.UserSettings {
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.AppTheme> themeStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.AppThemePreferenceDelegate theme$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.Language> languageStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.LanguagePreferenceDelegate language$delegate = null;
    
    @javax.inject.Inject()
    public UserSettingsImpl(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences preferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.AppTheme> getThemeStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.settings.AppTheme getTheme() {
        return null;
    }
    
    @java.lang.Override()
    public void setTheme(@org.jetbrains.annotations.NotNull()
    com.example.settings.AppTheme p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.Language> getLanguageStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.settings.Language getLanguage() {
        return null;
    }
    
    @java.lang.Override()
    public void setLanguage(@org.jetbrains.annotations.NotNull()
    com.example.settings.Language p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002J\'\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/settings/UserSettingsImpl$AppThemePreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "Lcom/example/settings/AppTheme;", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;Lcom/example/settings/AppTheme;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "ui-settings_debug"})
    public final class AppThemePreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, com.example.settings.AppTheme> {
        private final java.lang.String name = null;
        
        public AppThemePreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        com.example.settings.AppTheme p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.settings.AppTheme getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
        com.example.settings.AppTheme value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002J\'\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/settings/UserSettingsImpl$LanguagePreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "Lcom/example/settings/Language;", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;Lcom/example/settings/Language;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "ui-settings_debug"})
    public final class LanguagePreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, com.example.settings.Language> {
        private final java.lang.String name = null;
        
        public LanguagePreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        com.example.settings.Language p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.settings.Language getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
        com.example.settings.Language value) {
        }
    }
}