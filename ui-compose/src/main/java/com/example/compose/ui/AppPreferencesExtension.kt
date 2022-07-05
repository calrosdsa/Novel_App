package com.example.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.settings.AppTheme
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