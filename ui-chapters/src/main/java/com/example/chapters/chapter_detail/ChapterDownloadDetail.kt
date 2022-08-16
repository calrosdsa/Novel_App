package com.example.chapters.chapter_detail

import android.util.Log
import androidx.compose.runtime.Composable

import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chapters.component.ChapterSheetModal
import com.example.chapters.component.DrawerChapterContent
import com.example.compose.common.Carousel
import com.example.compose.common.rememberCarouselScrollState
import com.example.compose.common.verticalScroll
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.novels.MainDestination
import com.example.settings.FontOption
import kotlinx.coroutines.*
import kotlin.math.absoluteValue
import kotlin.math.roundToInt



@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ChapterDownloadDetail(
    navController: NavController,
    _window:  Window,
    viewModel: ChapterDownloadViewModel = hiltViewModel(),
) {
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    val contextApp = LocalContext.current
    val coroutine = rememberCoroutineScope()
    val stateSheet = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val brillo = viewModel.brillo
    val scroll by  viewModel.scrollStream.collectAsState()
    val fontSize by viewModel.fontSizeStream.collectAsState()
    val themePrefence = viewModel.weightStream.collectAsState()
    val fontWeightValue =  when(themePrefence.value) {
        FontOption.NORMAL -> FontWeight.Normal
        FontOption.LIGHT -> FontWeight.Light
        FontOption.THIN -> FontWeight.Thin
        FontOption.EXTRABOLD -> FontWeight.ExtraBold
        FontOption.SEMIBOLD -> FontWeight.SemiBold
    }

    DisposableEffect(key1 = Unit, effect = {
        val layoutParam = _window.attributes
        layoutParam.screenBrightness = brillo
        _window.attributes = layoutParam
        Log.d("CHAPTER_CONTENT",navController.currentDestination?.id.toString())
        onDispose {
            navController.backQueue.map { it.destination.route }.last().let {
                if (it != "chapter_download_detail/{novelSlug}") {
                    layoutParam.screenBrightness =
                        WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE
                    _window.attributes = layoutParam
                }
            }
        }
    })

    val offsetContent = remember {
        mutableStateOf(0f)
    }
    var fingerCount by remember {
        mutableStateOf(0)
    };
    val listState = rememberCarouselScrollState()

    CompositionLocalProvider(
        LocalOverScrollConfiguration provides null
    ) {

        Scaffold(
//            drawerContent = {
//                DrawerChapterContent(
//                    state,
//                    navController
//                )
//            },
//            drawerScrimColor = MaterialTheme.colors.background.copy(0.3f),
//            drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
//            scaffoldState = scaffoldState
        ) {

            ModalBottomSheetLayout(
                sheetContent = {
                    ChapterSheetModal(
                        _window,
                        viewModel.brightness,
                        setBrightness = { viewModel.setBrightness(it) },
                        setTheme = {theme-> viewModel.onChangeMode(theme)},
                        currentTheme = viewModel.theme,
                        autoScroll = { coroutine.launch {
                            stateSheet.hide()
                            listState.scroll(MutatePriority.UserInput){
                                do {
                                    scrollBy(3f)
                                    delay(scroll.toLong())
                                }while (isActive)
                            }
                        }},
                        showChapters={ navController.popBackStack() },
                        setScrollSpeed = { viewModel.setScrollSpeed(it) },
                        scroll = scroll,
                        fontSize = fontSize,
                        setFontSize = { viewModel.setFontSize(it) },
                        setFontWeight = {viewModel.setWeightStream(it)},
                        fontWeightValue = fontWeightValue
                    )
                },
                sheetState = stateSheet,
                sheetBackgroundColor = MaterialTheme.colors.surface,
                scrimColor = Color.Black.copy(alpha = 0.55f),
                sheetShape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectTapGestures {

                                coroutine.launch {
                                    stateSheet.show()
                                }
                            }
                        }
                        .background(MaterialTheme.colors.surface)


                ) {
                    state.chapterDownload?.let { item ->
                        Row(
                            Modifier
                                .zIndex(1f)
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.surface)
                                .padding(vertical = 7.dp, horizontal = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
//                    .padding(vertical = 5.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colors.primaryVariant)
                                    .clickable {
                                        navController.popBackStack(
//                            route = MainDestination.CHAPTERS_SCREEN + "/${item.novel_slug}",
//                            inclusive = false
                                        )

                                    },
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "single_chapter_back"
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = item.title, style = MaterialTheme.typography.subtitle2)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {

                            Column(
                                modifier = Modifier
                                    .zIndex(0f)
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.99f)
                                    .padding(horizontal = 15.dp)
                                    .verticalScroll(listState)
                                    .offset { IntOffset(0, offsetContent.value.roundToInt()) }
                                    .pointerInput(Unit) {
                                        forEachGesture {
                                            val context = currentCoroutineContext()
                                            awaitPointerEventScope {
                                                do {
                                                    val event = awaitPointerEvent()
                                                    fingerCount += event.changes.size
                                                    if (fingerCount > 3) {
                                                        event.changes.map { it ->
                                                            if (listState.value == 0) {
                                                                offsetContent.value += 10f
                                                                if (offsetContent.value.absoluteValue == 250f) {

                                                                    if (state.previous.isNullOrBlank()) {
                                                                        coroutine.launch {
                                                                            Toast
                                                                                .makeText(
                                                                                    contextApp,
                                                                                    "This is the first chapter",
                                                                                    Toast.LENGTH_SHORT
                                                                                )
                                                                                .show()
                                                                        }
                                                                    } else {
                                                                        navController.navigate(
                                                                            MainDestination.CHAPTER_DOWNLOAD_DETAIL +
                                                                                    "/${state.previous}"
                                                                        ) {
                                                                            popUpTo(759150621)
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!it.pressed) {
                                                                offsetContent.value = 0f
                                                                fingerCount = 0
                                                            }
                                                            if (listState.value == listState.maxValue) {
                                                                offsetContent.value -= 10f
                                                                if (offsetContent.value.absoluteValue == 250f) {
                                                                        if (state.next.isNullOrBlank()) {
                                                                            Toast
                                                                                .makeText(
                                                                                    contextApp,
                                                                                    "This is the last chapter",
                                                                                    Toast.LENGTH_LONG
                                                                                )
                                                                                .show()
                                                                        } else {
                                                                            navController.navigate(
                                                                                MainDestination.CHAPTER_DOWNLOAD_DETAIL +
                                                                                        "/${state.next}"
                                                                            ) {
                                                                                popUpTo(759150621)
                                                                            }
                                                                        }
                                                                }
                                                            }
                                                        }
//                                    if (event.changes.size == fingerCount) {
//                                        context.cancel()
//                                    }
                                                    }
                                                } while (event.changes.any { it.pressed } && context.isActive)
                                            }
                                        }
                                    }) {

                                Spacer(modifier = Modifier.height(30.dp))
                                Text(
                                    text = item.title, style = MaterialTheme.typography.h5.copy(
                                        fontWeight = FontWeight.Light
                                    )
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = item.chapter, style = MaterialTheme.typography.h6.copy(
                                    fontSize = fontSize.sp,
                                    fontWeight = fontWeightValue
                                ))
                                Spacer(modifier = Modifier.height(30.dp))
                                state.next?.let {
                                    if (state.next != null) {
                                        Text(
                                            text = "SWIPE DOWN TO CONTINUE",
                                            style = MaterialTheme.typography.subtitle2,
                                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                        )
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowDown,
                                            contentDescription = "Arrow_down_keyboard",
                                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                        )
                                    }
                                }
                            }

                            AnimatedVisibility(visible = listState.isScrollInProgress) {
                                Carousel(
                                    state = listState,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
