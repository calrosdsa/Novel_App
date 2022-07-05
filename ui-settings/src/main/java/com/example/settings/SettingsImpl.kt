package com.example.settings

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty



class UserSettingsImpl @Inject constructor(
    private val preferences: SharedPreferences,
) : UserSettings {
    override val themeStream: MutableStateFlow<AppTheme>
    override var theme: AppTheme by AppThemePreferenceDelegate("app_theme", AppTheme.MODE_AUTO)
    override val languageStream: MutableStateFlow<Language>
    override  var language: Language by LanguagePreferenceDelegate("app_language",Language.DEFAULT)


    init {
        themeStream = MutableStateFlow(theme)
        languageStream = MutableStateFlow(language)
    }

    inner class AppThemePreferenceDelegate(
        private val name: String,
        private val default: AppTheme,
    ) : ReadWriteProperty<Any?, AppTheme> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): AppTheme =
            AppTheme.fromOrdinal(preferences.getInt(name, default.ordinal))

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: AppTheme) {
            themeStream.value = value
           with(preferences.edit()){
               putInt(name, value.ordinal)
                   .apply()
           }
        }
    }



    inner class LanguagePreferenceDelegate(
        private val name: String,
        private val default: Language,
    ) : ReadWriteProperty<Any?, Language> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): Language =
            Language.fromOrdinal(preferences.getInt(name, default.ordinal))

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Language) {
            languageStream.value = value
            with(preferences.edit()){
                putInt(name, value.ordinal)
            }
        }
    }
}