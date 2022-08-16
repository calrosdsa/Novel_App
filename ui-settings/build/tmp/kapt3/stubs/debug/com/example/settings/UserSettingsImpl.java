package com.example.settings;

import android.content.SharedPreferences;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0006>?@ABCB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00198V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020!8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020!0\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010+\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR+\u00103\u001a\u0002022\u0006\u0010\n\u001a\u0002028V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\tR\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\t\u00a8\u0006D"}, d2 = {"Lcom/example/settings/UserSettingsImpl;", "Lcom/example/settings/UserSettings;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "brightStream", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getBrightStream", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "<set-?>", "brightness", "getBrightness", "()F", "setBrightness", "(F)V", "brightness$delegate", "Lcom/example/settings/UserSettingsImpl$BrightPreferenceDelegate;", "fontSizeValue", "getFontSizeValue", "setFontSizeValue", "fontSizeValue$delegate", "Lcom/example/settings/UserSettingsImpl$FontSizePreferenceDelegate;", "fontStream", "getFontStream", "Lcom/example/settings/FontOption;", "fontWieght", "getFontWieght", "()Lcom/example/settings/FontOption;", "setFontWieght", "(Lcom/example/settings/FontOption;)V", "fontWieght$delegate", "Lcom/example/settings/UserSettingsImpl$FontWeightPreferenceDelegate;", "Lcom/example/settings/Language;", "language", "getLanguage", "()Lcom/example/settings/Language;", "setLanguage", "(Lcom/example/settings/Language;)V", "language$delegate", "Lcom/example/settings/UserSettingsImpl$LanguagePreferenceDelegate;", "languageStream", "getLanguageStream", "scrollSpeed", "getScrollSpeed", "setScrollSpeed", "scrollSpeed$delegate", "Lcom/example/settings/UserSettingsImpl$ScrollPreferenceDelegate;", "scrollStream", "getScrollStream", "Lcom/example/settings/AppTheme;", "theme", "getTheme", "()Lcom/example/settings/AppTheme;", "setTheme", "(Lcom/example/settings/AppTheme;)V", "theme$delegate", "Lcom/example/settings/UserSettingsImpl$AppThemePreferenceDelegate;", "themeStream", "getThemeStream", "weightStream", "getWeightStream", "AppThemePreferenceDelegate", "BrightPreferenceDelegate", "FontSizePreferenceDelegate", "FontWeightPreferenceDelegate", "LanguagePreferenceDelegate", "ScrollPreferenceDelegate", "ui-settings_debug"})
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
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> brightStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.BrightPreferenceDelegate brightness$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> scrollStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.ScrollPreferenceDelegate scrollSpeed$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> fontStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.FontSizePreferenceDelegate fontSizeValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.FontOption> weightStream = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.settings.UserSettingsImpl.FontWeightPreferenceDelegate fontWieght$delegate = null;
    
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> getBrightStream() {
        return null;
    }
    
    @java.lang.Override()
    public float getBrightness() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public void setBrightness(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> getScrollStream() {
        return null;
    }
    
    @java.lang.Override()
    public float getScrollSpeed() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public void setScrollSpeed(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> getFontStream() {
        return null;
    }
    
    @java.lang.Override()
    public float getFontSizeValue() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public void setFontSizeValue(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<com.example.settings.FontOption> getWeightStream() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.settings.FontOption getFontWieght() {
        return null;
    }
    
    @java.lang.Override()
    public void setFontWieght(@org.jetbrains.annotations.NotNull()
    com.example.settings.FontOption p0) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002J\'\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/settings/UserSettingsImpl$FontWeightPreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "Lcom/example/settings/FontOption;", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;Lcom/example/settings/FontOption;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "ui-settings_debug"})
    public final class FontWeightPreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, com.example.settings.FontOption> {
        private final java.lang.String name = null;
        
        public FontWeightPreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        com.example.settings.FontOption p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.settings.FontOption getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
        com.example.settings.FontOption value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/settings/UserSettingsImpl$BrightPreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;F)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Float;", "setValue", "", "value", "ui-settings_debug"})
    public final class BrightPreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, java.lang.Float> {
        private final java.lang.String name = null;
        
        public BrightPreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, float p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.Float getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, float value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/settings/UserSettingsImpl$ScrollPreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;F)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Float;", "setValue", "", "value", "ui-settings_debug"})
    public final class ScrollPreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, java.lang.Float> {
        private final java.lang.String name = null;
        
        public ScrollPreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, float p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.Float getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, float value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/settings/UserSettingsImpl$FontSizePreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "", "name", "", "default", "(Lcom/example/settings/UserSettingsImpl;Ljava/lang/String;F)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Float;", "setValue", "", "value", "ui-settings_debug"})
    public final class FontSizePreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, java.lang.Float> {
        private final java.lang.String name = null;
        
        public FontSizePreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, float p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.Float getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, float value) {
        }
    }
}