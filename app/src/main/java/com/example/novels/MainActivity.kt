package com.example.novels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.theme.AppThemeNovel
import com.example.compose.ui.shouldUseDarkMode
import com.example.novels.home.Home
import com.example.settings.UserSettings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var userSettings: UserSettings
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

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

     AppThemeNovel(darkTheme = userSettings.shouldUseDarkMode()) {

         Home(context = this)

     }
            }
        }
    }
