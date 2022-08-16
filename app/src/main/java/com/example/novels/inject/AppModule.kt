package com.example.novels.inject

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.os.ConfigurationCompat
import com.example.data.*
import com.example.data.remote.ApiService
import com.example.data.util.Constants
import com.example.domain.UserAuth
import com.example.domain.interceptors.TokenInterceptor
import com.example.util.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    @Named("Token")
    fun provideToken(prefs: SharedPreferences): String =  prefs.getString("jwt", null) ?: ""

    @Singleton
    @Provides
    fun provideCoroutineDispatchers() = AppCoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )

    @Provides
    @Singleton
    fun provideOkHttpClient(
//        auth:UserAuth
    ): OkHttpClient = with(OkHttpClient.Builder()) {
        writeTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(10L, TimeUnit.MINUTES)
//            .addInterceptor(TokenInterceptor(auth))
        build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(okHttpClient: OkHttpClient
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
        //    .client(OkHttpClient.Builder()
          //      .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create()
            //.create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences{
        return  app.getSharedPreferences("prefs",MODE_PRIVATE)
    }

    @Singleton
    @Provides
    @MediumDate
    fun provideMediumDateFormatter(
        @ApplicationContext context: Context,
    ): DateTimeFormatter {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(context)
    }

    @Singleton
    @Provides
    @MediumDateTime
    fun provideDateTimeFormatter(
        @ApplicationContext context: Context
    ): DateTimeFormatter {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(context)
    }

    @Singleton
    @Provides
    @ShortDate
    fun provideShortDateFormatter(
        @ApplicationContext context: Context
    ): DateTimeFormatter {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(context)
    }

    @Singleton
    @Provides
    @ShortTime
    fun provideShortTimeFormatter(
        @ApplicationContext context: Context
    ): DateTimeFormatter {
        return DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(context)
    }

}



fun DateTimeFormatter.withLocale(context: Context): DateTimeFormatter {
    val locales = ConfigurationCompat.getLocales(context.resources.configuration)
    return when {
        locales.isEmpty -> this
        else -> withLocale(locales[0])
    }
}
