package com.example.domain

import kotlinx.coroutines.flow.StateFlow



data class UserData(
    var token:String = "",
)




interface UserAuth {
    val authToken: StateFlow<UserData>
    var tokenValue: UserData
    val refreshState:StateFlow<StateRefresh>
    var refresh:StateRefresh
}


enum class StateRefresh {
    REFRESH,
    INITIAL;
    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}


