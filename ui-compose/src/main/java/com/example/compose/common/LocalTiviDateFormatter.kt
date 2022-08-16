package com.example.compose.common

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.domain.resources.NovelDateFormatter

val LocalNovelDateFormatter = staticCompositionLocalOf<NovelDateFormatter> {
    error("DateFormatter not provided")
}

//val LocalTiviTextCreator = staticCompositionLocalOf<TiviTextCreator> {
  //  error("TiviTextCreator not provided")
//}
