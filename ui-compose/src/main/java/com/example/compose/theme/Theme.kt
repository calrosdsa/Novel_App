package com.example.compose.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

private val Slate200 = Color(0xFF81A9B3)
private val Slate600 = Color(0xFF4A6572)
private val Slate800 = Color(0xFF232F34)
private val NeutralDark = Color(0x1fffffff)
private val NeutralLight = Color.LightGray.copy(alpha = 0.6f)
private val Neutral6C = Color(0x99000000)

private val Orange500 = Color(0xFFF9AA33)
private val Orange700 = Color(0xFFC78522)

val AppLightColors = lightColors(
    primary = Slate200,
    background = Color.White,
    onPrimary = Color.DarkGray,
    primaryVariant = Color.LightGray,
    secondary = Slate600,
    secondaryVariant = NeutralLight,
    onSecondary = Color.Black,
)

val AppDarkColors = darkColors(
    primary = Slate200,
    //background = Color(0xFF16082f),
    background = Color.Black,
    primaryVariant = Color.DarkGray,
    onPrimary = Color.LightGray,
    secondary = Slate600,
    secondaryVariant = NeutralDark,
    onSecondary = Color.White,
).withBrandedSurface()

fun Colors.withBrandedSurface() = copy(
    surface = primary.copy(alpha = 0.08f).compositeOver(this.surface),
)



@Composable
fun AppThemeNovel(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) AppDarkColors else AppLightColors
    //CompositionLocalProvider(LocalColorsProvaider provides Colorss())  {

        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
   //}
}

//@Stable
//class Colorss(
//      background: Color,
//      primary: Color,
//      onPrimary: Color,
//      onBackground: Color,
//
//      ) {
//    var background by mutableStateOf(background)
//        private set
//    var primary by mutableStateOf(primary)
//        private set
//    var onPrimary by mutableStateOf(onPrimary)
//        private set
//    var onBackground by mutableStateOf(onBackground)
//        private set
//    @Composable
//    private fun animateColor(
//        targetValue: Color,
////        finishedListener: ((Color) -> Unit)? = null
//    ) = animateColorAsState(targetValue = targetValue, animationSpec = animationSpec).value
//
//    @Composable
//    fun switch():Colorss = Colorss(
//        background = animateColor(background),
//        primary  = animateColor(primary),
//        onPrimary = animateColor(onPrimary),
//        onBackground = animateColor(onBackground)
//        //etc
//    )
//    private val animationSpec: AnimationSpec<Color> = tween(durationMillis = 700)
//
//    fun update(other: Colorss) {
//        background = other.background
//        primary = other.primary
//        onBackground = other.onBackground
//        onPrimary = other.onPrimary
//
//    }
//
//
//
//    fun copy(): Colorss = Colorss (
//        background = background,
//        primary = primary,
//        onPrimary = onPrimary,
//        onBackground = onBackground,
//
//        )
//
//
//}
////val LocalColorsProvaider = staticCompositionLocalOf { Colorss() }
//
//
////val CustomColors
// //   @Composable
////    @ReadOnlyComposable
////    get() = LocalColorsProvaider.current
//
//
//object AppThemeNovel {
//    val colors: Colorss
//        @Composable
//       get() = LocalJetsnackColors.current
//}
//
//@Composable
//fun ProvideColors(
//    colors: Colorss,
//    content: @Composable () -> Unit
//) {
//    //val colorPalette = remember { colors.copy() }
//    val colorPalette =  colors.switch()
//        // Explicitly creating a new object here so we don't mutate the initial [colors]
//    // provided, and overwrite the values set in it.
//
////    colorPalette.update(colors)
//    CompositionLocalProvider(LocalJetsnackColors provides colorPalette ,content = content)
//}
//
//private val LocalJetsnackColors = staticCompositionLocalOf<Colorss> {
//    error("No JetsnackColorPalette provided")
//}
//
//fun debugColors(
//    darkTheme: Boolean,
//    debugColor: Color = Color.LightGray
//)= Colors(
//    primary = debugColor,
//    primaryVariant = debugColor,
//    secondary = debugColor,
//    secondaryVariant = debugColor,
//    background = debugColor,
//    surface = debugColor,
//    error = debugColor,
//    onPrimary = debugColor,
//    onSecondary = debugColor,
//    onBackground = debugColor,
//    onSurface = debugColor,
//    onError = debugColor,
//    isLight = !darkTheme
//)