package com.example.novels.novels

import com.example.data.dto.novels.NovelsDto


data class NovelsState(
    val is_loading:Boolean = false,
    val novels: NovelsDto? = null,
    val error:String = ""

)