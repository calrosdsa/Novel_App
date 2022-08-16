package com.example.chapters.chapter_detail

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
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
import com.example.data.local.entities.ChapterEntity
import com.example.novels.MainDestination
import com.example.settings.FontOption
import kotlinx.coroutines.*
import kotlin.math.absoluteValue
import kotlin.math.roundToInt


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ChapterDetailScreen(
    navController: NavController,
    _window:  Window,
    viewModel: ChapterViewModel = hiltViewModel(),
) {
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    val scaffoldState = rememberScaffoldState()
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

    LaunchedEffect(key1 = state, block = {
//        Log.d("CHAPTER_CONTENT", state.chapter.toString() )

//        val next = state.chapterNovel?.chapters?.first { it.id < state.chapterDownload?.id!! }?.slug
//        val previous = state.chapterNovel?.chapters?.first { it.id > state.chapterDownload?.id!! }?.slug
//        Log.d("CHAPTER_CONTENT", next.toString())
//        Log.d("CHAPTER_CONTENT", previous.toString())
//        Log.d("CHAPTER_CONTENT", state.chapterNovel.toString())
//        Log.d("CHAPTER_CONTENT", next.toString())
    })

    DisposableEffect(key1 = Unit, effect = {
        Log.d("CHAPTER_CONTENT",navController.currentDestination?.id.toString() )

        val layoutParam = _window.attributes
        layoutParam.screenBrightness = brillo
        _window.attributes = layoutParam
        onDispose {
            navController.backQueue.map { it.destination.route }.last().let {
                if (it != "chapter_screen/{novelSlug}") {
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
            drawerContent = {
                 DrawerChapterContent(
                     state,
                     navController
                 )
            },
            drawerScrimColor = MaterialTheme.colors.background.copy(0.3f),
            drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
            scaffoldState = scaffoldState
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
                        showChapters = {
                            coroutine.launch{
                            scaffoldState.drawerState.open()
                            }},
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
                    state.chapter?.let { item ->
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
                                                                    item.previous?.let {

                                                                        if (it.slug.isNullOrBlank()) {
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
                                                                                MainDestination.CHAPTER_SCREEN +
                                                                                        "/${it.slug}"
                                                                            ) {
                                                                                popUpTo(-1516363942)
                                                                            }
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
                                                                    item.next?.let {

                                                                        if (it.slug.isNullOrEmpty()) {
                                                                            Toast
                                                                                .makeText(
                                                                                    contextApp,
                                                                                    "This is the last chapter",
                                                                                    Toast.LENGTH_LONG
                                                                                )
                                                                                .show()
                                                                        } else {
                                                                            navController.navigate(
                                                                                MainDestination.CHAPTER_SCREEN +
                                                                                        "/${it.slug}"
                                                                            ) {
                                                                                popUpTo(-1516363942)
                                                                            }
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
                                item.next?.let {
                                    if (it.slug != null) {
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
//    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)

//    val swipeableState = rememberSwipeableState(initialValue = SwipeDirection.UP)
//    val configuration = LocalConfiguration.current
//    val boxSize = configuration.screenHeightDp.dp
//    val density = with(LocalDensity.current){boxSize.toPx()}
//    LaunchedEffect(key1 = swipeableState, block = {
//        Log.d("SWIPEABLEST" , swipeableState.overflow.value.toString())
//
//    })
//
//Box(  modifier = Modifier
//    .fillMaxSize()
//    .swipeable(
//        state = swipeableState,
//        anchors = mapOf(
//            0f to SwipeDirection.DOWN,
//            density to SwipeDirection.UP,
//        ),
//        thresholds = { _, _ -> FractionalThreshold(0.5f) },
//        orientation = Orientation.Vertical
//    )
//) {
//
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.LightGray)
//            .offset {
//                IntOffset(
//                    0,
//                    swipeableState.offset.value.roundToInt(),
//                )
//            }
//      //      .verticalScroll(rememberScrollState())
//        //   .padding(it)
//        //     .verticalScroll(rememberScrollState())
//    ) {
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .background(Color.LightGray)
////        ) {
//
////            state.chapter?.let { chapter ->
////                TextButton(onClick = { navController.popBackStack() }) {
////                    Text(text = chapter.novel_title)
////                }
////                Text(text = chapter.title)
////
////                TextButton(
////                    enabled = chapter.next != null,
////                    onClick = {
////                        navController.navigate(MainDestination.CHAPTER_SCREEN + "/${chapter.next?.slug}")
////                    }) {
////                    Text(text = chapter.next?.slug.toString())
////                }
////                Text(text = chapter.chapter)
////                Box(modifier = Modifier
////                    .fillMaxWidth()
////                    .height(140.dp)
////                    .padding(20.dp)
////                    .clip(MaterialTheme.shapes.small)
////                    .background(Color.DarkGray)
////                    .pointerInput(Unit) {
////                        forEachGesture {
////                            val currentContext = currentCoroutineContext()
////                            awaitPointerEventScope {
////                                do {
////                                    val event = awaitPointerEvent()
////                                    val pointerCount = event.changes.size
////                                    navController.navigate(MainDestination.CHAPTER_SCREEN + "/${chapter.next?.slug}")
////                                    Log.d("POINTEREVENT", pointerCount.toString())
////                                    currentContext.cancel()
////                                } while (event.changes.any { e -> e.pressed } && currentContext.isActive)
////                            }
////                        }
////                    }
////                ) {
////                    Text(text = "Swipe to Continue")
////                }
////            }
////        }
//    }
//}
//    Box(modifier = Modifier
//        .fillMaxSize()
//
//        .offset {
//            IntOffset(
//                0,
//                swipeableState.offset.value.roundToInt() * density.toInt(),
//            )
//        }
//    ) {
//      Button(onClick = { navController.popBackStack() }) {
//
//      }
//    }
//}
//
//
//
//enum class SwipeDirection{
//    UP,
//    CENTER,
//    DOWN
//}