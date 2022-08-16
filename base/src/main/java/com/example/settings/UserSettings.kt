package com.example.settings

import kotlinx.coroutines.flow.StateFlow
import org.intellij.lang.annotations.JdkConstants.FontStyle


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
enum class  FontOption{
    THIN,
    LIGHT,
    NORMAL,
    SEMIBOLD,
    EXTRABOLD;
    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}





interface UserSettings {
    val themeStream: StateFlow<AppTheme>
    var theme: AppTheme
    val languageStream: StateFlow<Language>
    var language: Language
    val brightStream:StateFlow<Float>
    var  brightness:Float
    val scrollStream: StateFlow<Float>
    var scrollSpeed:Float
    val fontStream: StateFlow<Float>
    var fontSizeValue : Float
    val weightStream:StateFlow<FontOption>
    var fontWieght:FontOption
}