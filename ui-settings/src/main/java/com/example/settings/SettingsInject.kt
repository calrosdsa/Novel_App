@file:Suppress("DEPRECATION")
package com.example.settings
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingsModuleBinds {
    @Provides
    @Singleton
    fun userSettings(preferences: SharedPreferences): UserSettings{
        return UserSettingsImpl(preferences)
    }
}

