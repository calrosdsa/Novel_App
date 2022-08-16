package com.example.settings

import android.content.SharedPreferences
import androidx.compose.ui.text.font.Font
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
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
    override val brightStream: MutableStateFlow<Float>
    override  var brightness by BrightPreferenceDelegate("app_brightness",0.5f)
    override val scrollStream: MutableStateFlow<Float>
    override var scrollSpeed: Float by ScrollPreferenceDelegate("scroll_speed",30f)
    override val fontStream:MutableStateFlow<Float>
    override var fontSizeValue: Float by FontSizePreferenceDelegate("font_size",13f)
    override val weightStream: MutableStateFlow<FontOption>
    override var fontWieght: FontOption by FontWeightPreferenceDelegate("font_weight",FontOption.NORMAL)


    init {
        themeStream = MutableStateFlow(theme)
        languageStream = MutableStateFlow(language)
        brightStream = MutableStateFlow(brightness)
        scrollStream = MutableStateFlow(scrollSpeed)
        fontStream = MutableStateFlow(fontSizeValue)
        weightStream = MutableStateFlow(fontWieght)
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
    inner class FontWeightPreferenceDelegate(
        private val name: String,
        private val default: FontOption,
    ) : ReadWriteProperty<Any?, FontOption> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): FontOption =
            FontOption.fromOrdinal(preferences.getInt(name, default.ordinal))

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: FontOption) {
            weightStream.value = value
            with(preferences.edit()){
                putInt(name, value.ordinal)
            }
        }
    }

    inner class BrightPreferenceDelegate(
        private val name: String,
        private val default: Float,
    ) : ReadWriteProperty<Any?, Float> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): Float =
            preferences.getFloat(name, default)

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
            brightStream.value = value
            with(preferences.edit()){
                putFloat(name, value)
                    .commit()
            }
        }
    }

    inner class ScrollPreferenceDelegate(
        private val name: String,
        private val default: Float,
    ) : ReadWriteProperty<Any?, Float> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): Float =
            preferences.getFloat(name, default)

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
            scrollStream.value = value
            with(preferences.edit()){
                putFloat(name, value)
                    .commit()
            }
        }
    }

    inner class FontSizePreferenceDelegate(
        private val name: String,
        private val default: Float,
    ) : ReadWriteProperty<Any?, Float> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): Float =
            preferences.getFloat(name, default)

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
            fontStream.value = value
            with(preferences.edit()){
                putFloat(name, value)
                    .commit()
            }
        }
    }
}