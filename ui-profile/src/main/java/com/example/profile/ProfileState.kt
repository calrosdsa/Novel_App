package com.example.profile

import com.example.data.dto.profile.ProfileDto

data class ProfileState(

    val isContainToken :Boolean? = null,
    val token: String = "",
    val is_loading:Boolean = false,
    val profile:ProfileDto? = null,
    val isNightMode:Boolean? = null,
    val error:String = ""

)