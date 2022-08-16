package com.example.novels

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import com.example.compose.common.LocalNovelDateFormatter
import com.example.compose.theme.AppThemeNovel
import com.example.compose.ui.shouldUseDarkMode
import com.example.domain.resources.NovelDateFormatter
import com.example.novels.home.Home
import com.example.settings.UserSettings
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.security.AccessController.getContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var userSettings: UserSettings
    @Inject internal lateinit var novelDateFormatter: NovelDateFormatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val lp = window
            val contentResolver = contentResolver
            if(Settings.System.canWrite(this)){
        Log.d("SCREEN_BRILLO", "ENABLED")
            }else{
                val intent= Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
                intent.data = Uri.parse("package:" + application.packageName)
                startActivity(intent)

            }
            val brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)
            Log.d("SCREEN_BRILLO", brightness.toString())

            //            lifecycleScope.launch {
//                userSettings.brightStream.collect{value->
//            lp.screenBrightness = value
//            Log.d("SCREEN_BRILLO", value.toString())
//                }
//            }

            //        android:theme="@style/Theme.App.SplashScreenTheme"

            //            android:theme="@style/Theme.App.SplashScreenTheme"
            //installSplashScreen()
            //      var isLightTheme by remember {
            //        mutableStateOf(true)
            //        }
            //      val colors = (if (isLightTheme)
            //        LightColorPalette
            //      else  DarkColorPalette).switch()

            //         val activities = packageManager
            //                    .getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
            //       val nameList= activities.filter { it.name == "com.example.settings" }

            CompositionLocalProvider(
             LocalNovelDateFormatter provides novelDateFormatter
            ) {
                AppThemeNovel(darkTheme = userSettings.shouldUseDarkMode()) {
                    Home(
                        context = this,
                        window = lp
                    )
                }
            }
        }
    }
}


