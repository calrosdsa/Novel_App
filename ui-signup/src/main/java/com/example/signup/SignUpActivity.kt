package com.example.signup

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

       //     val settingsActivity =Class.forName(activities[2].name)
            Column() {
                Button(onClick = {
                    //          onClickItem(this@SignUpActivity,nameList[0])
                    onBackPressedDispatcher?.onBackPressed()
                }) {
                }
             //   RegistrationScreen()
            }
        }
    }
}

fun onClickItem(context: Context,index:Int){
    try {
        val activities = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_ACTIVITIES).activities
        val nameList= activities.map { it.name }
        val c = Class.forName(nameList[index])
        val intent = Intent(context, c)
        context.startActivity(intent)
    } catch (ex: Exception) {
    }
}