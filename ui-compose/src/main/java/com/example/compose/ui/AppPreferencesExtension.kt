package com.example.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.font.FontWeight
import com.example.settings.AppTheme
import com.example.settings.FontOption
import com.example.settings.UserSettings

@Composable
fun UserSettings.shouldUseDarkMode():Boolean{
    val themePrefence = themeStream.collectAsState()
    return when (themePrefence.value) {
        AppTheme.MODE_AUTO -> isSystemInDarkTheme()
        AppTheme.MODE_DAY -> false
        AppTheme.MODE_NIGHT -> true
    }
}

@Composable
fun UserSettings.fonWeightOption():FontWeight{
    val themePrefence = weightStream.collectAsState()
    return when (themePrefence.value) {
        FontOption.NORMAL -> FontWeight.Normal
        FontOption.LIGHT -> FontWeight.Light
        FontOption.THIN -> FontWeight.Thin
        FontOption.EXTRABOLD -> FontWeight.ExtraBold
        FontOption.SEMIBOLD -> FontWeight.SemiBold

    }
}