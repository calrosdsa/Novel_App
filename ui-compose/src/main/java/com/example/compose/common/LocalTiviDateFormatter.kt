package com.example.compose.common

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.domain.resources.NovelDateFormatter

val LocalTiviDateFormatter = staticCompositionLocalOf<NovelDateFormatter> {
    error("TiviDateFormatter not provided")
}

//val LocalTiviTextCreator = staticCompositionLocalOf<TiviTextCreator> {
  //  error("TiviTextCreator not provided")
//}
