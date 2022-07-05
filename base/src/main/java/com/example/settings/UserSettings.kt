package com.example.settings

import kotlinx.coroutines.flow.StateFlow


enum class AppTheme {
    MODE_DAY,
    MODE_NIGHT,
    MODE_AUTO;

    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}
enum class  Language{
    ENGLISH,
    SPANISH,
    DEFAULT;
    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}



interface UserSettings {
    val themeStream: StateFlow<AppTheme>
    var theme: AppTheme
    val languageStream: StateFlow<Language>
    var language: Language
}