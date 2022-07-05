package com.example.profile

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UserAuth
import com.example.domain.resources.Resource
import com.example.domain.useCases.GetProfile
import com.example.settings.AppTheme
import com.example.settings.UserSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfile: GetProfile,
    private val preferences: SharedPreferences,
    userAuth:UserAuth,
    private val userSettings: UserSettings
): ViewModel() {
  //  private val _state = mutableStateOf(ProfileState())
    //val state : State<ProfileState> = _state
  //  var tokenValue by mutableStateOf("")

    var state by mutableStateOf(ProfileState())
    private var tokenString by mutableStateOf("")
    var count by mutableStateOf(0)
    private val tokenKey = userAuth.tokenValue.token
    val themeMode = userSettings


    fun getTheme(){
        preferences.getInt("app_theme",AppTheme.MODE_DAY.ordinal)
    }


    init {
    }

    fun onStart(){
        if(state.profile == null) {
           profile()
      tokenString = "On Start cycle"
       }
    }

    fun onChangeMode(value:AppTheme) {

    userSettings.theme = AppTheme.fromOrdinal(value.ordinal)
    }

    fun onStop(){

    }




    fun profile(){

        if(tokenKey != ""){

        Log.d("requestProfil","${count++}")

        getProfile(tokenKey).onEach { result->
            state = when(result){
                is Resource.Success->{
                    delay(1000)
                    ProfileState(profile = result.data)
                }
                is Resource.Loading->{
                    ProfileState(is_loading = true)
                }
                is Resource.Error->{
                    ProfileState(error = result.message?:"An expected error ocurred")

                }
            }
        }.launchIn(viewModelScope)
        }
    }


    fun clearPreferences(){
        preferences.edit().remove("jwt")
    }


    fun getToken(){
      //  val handler = Handler(Looper.getMainLooper())
      //  val runnable = object : Runnable {
      //      override fun run() {
        //        try {
          //          recreate(context as Activity)
            //    } catch (e: Exception) {}
              //  handler.postDelayed(this, 10000)
           // }
   //     }
     //   handler.postDelayed(runnable, 10000)
       // tokenString = token
     //   context.startActivity(Intent(
     //       context,SettingsActivity::class.java
     //   ))
    }
    //private fun getTokenKey(){
    //    viewModelScope.launch {
    //        _state.value = state.value.copy(isContainToken = true, token = "amkcascak")
    //    }
  //  }
}