package com.example.domain.repository

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.domain.StateRefresh
import com.example.domain.UserAuth
import com.example.domain.UserData
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@RequiresApi(Build.VERSION_CODES.GINGERBREAD)
class UserAuthImpl @Inject constructor(
    private val preferences: SharedPreferences,
): UserAuth {
    override val authToken: MutableStateFlow<UserData>
    override var tokenValue: UserData by UserPreferenceDelegate("jwt")
    override val refreshState: MutableStateFlow<StateRefresh>
    override var refresh: StateRefresh by RefreshPreferenceDelegate("refresh",StateRefresh.INITIAL)
    //override val authToken: MutableStateFlow<UserData> get() = MutableStateFlow(tokenValue)

    init {
         authToken = MutableStateFlow(tokenValue)
        refreshState = MutableStateFlow(refresh)
    }

    inner class UserPreferenceDelegate(
        private val name:String,
        //private val default:UserData,
    ): ReadWriteProperty<Any?, UserData>{
        override fun getValue(thisRef: Any?, property: KProperty<*>): UserData =
            UserData( token=preferences.getString(name,null)?: "")


        override fun setValue(thisRef: Any?, property: KProperty<*>, value: UserData) {
            authToken.value = value
            val bearerToken = "token ${value.token}"
            with(preferences.edit()){
                putString(name, bearerToken)
                    .apply()
            }
        }

    }


    inner class RefreshPreferenceDelegate(
        private val name:String,
        private val default: StateRefresh,
        //private val default:UserData,
    ): ReadWriteProperty<Any?, StateRefresh>{
        override fun getValue(thisRef: Any?, property: KProperty<*>): StateRefresh =
            StateRefresh.fromOrdinal(preferences.getInt(name,default.ordinal))


        override fun setValue(thisRef: Any?, property: KProperty<*>, value: StateRefresh) {
            refreshState.value = value
            with(preferences.edit()){
                putInt(name,value.ordinal)
                    .apply()
            }
        }

    }


}