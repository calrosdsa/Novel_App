package com.example.novels.navigation

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.util.fastFirstOrNull
import kotlinx.coroutines.*
import kotlin.math.roundToInt

@Composable
fun SwipeableScreen(){
    val offsetContent  = remember {
        mutableStateOf(0f)
    }
    val listState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(listState)
            .fillMaxSize()
            .offset { IntOffset(0, offsetContent.value.roundToInt()) }
            .pointerInput(Unit) {
                val fingerCount = 2;
//                var touchess = 0f;
                forEachGesture {
                    val context = currentCoroutineContext()
                    awaitPointerEventScope {
                        do {
                            val event = awaitPointerEvent()
                            event.changes.map {
                                if(listState.value == 0){
                                    offsetContent.value += 6f
                                }
                            if(!it.pressed){
                                offsetContent.value = 0f
                            }
                                if(listState.value == listState.maxValue){
                                    offsetContent.value -= 6f
                                }
                            }
                            if (event.changes.size == fingerCount) {
                                context.cancel()
                            }
                            Log.d("TOUCHESS", offsetContent.value.toString())
                        } while (event.changes.any { it.pressed } && context.isActive)
                    }
                }
            }){
        repeat(40){
            Text(text = "Item $it")
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
//
//    val listState = rememberLazyListState()
//    val offsetX = remember { mutableStateOf(0f) }
////    val draggedInteraction = remember { mutableStateOf<DragInteraction.Start?>(null) }
//
//
////    val isPressed by interactionSource.collectIsPressedAsState()
////    val nestedScrollConnection = rememberLazyNestedScroll(listState = listState, offSet = offsetX)
//    val source =  listState.interactionSource.collectIsDraggedAsState()
//
//    LaunchedEffect(key1 = source.value, block ={
//        Log.d("FUENTE",source.toString())
//    } )
//    Box( modifier = Modifier
//        .fillMaxSize()
//        //   .scrollEnabled(false)
//        //    .background(color.value)
//        ,
//    ){
//
//        CompositionLocalProvider(
//            LocalOverScrollConfiguration provides null
//        ) {
//     //   var list by remember { mutableStateOf(listOf("A", "B", "C")) }
//        Column(
//            modifier = Modifier
//                .offset { IntOffset(0, offsetX.value.roundToInt()) }
////                .nestedScroll(nestedScrollConnection)
//                .fillMaxWidth()
//                .simpleVerticalScrollbar(listState)
//                .pointerInput(Unit) {
//                    forEachGesture {
//                        awaitPointerEventScope {
//                            val down = awaitFirstDown(requireUnconsumed = false)
//                             val isPreseed = currentEvent.isPointerUp(down.id)
////                            var drag: PointerInputChange?
//                            do {
////                                Log.d("CHANGETYPE","NOPRESSED")
////                            }else{
////                            val isUp = down.pressed
////                            val event = awaitPointerEvent()
////                            val dragEvent = event.changes.fastFirstOrNull { it.id == down.id }
////                            while (down.pressed){
////                            Log.d("CHANGETYPE",dragEvent?.type.toString())
//                            Log.d("CHANGETYPE","PRESSED")
////                            }
////                            }
//                            }while (isPreseed)
//                        }
//                    }
//                }
//        ) {
//            repeat(100){
//                Text(text = ",cd,cls,lc,ls,ls,cla")
//                Spacer(modifier = Modifier.height(30.dp))
//            }
//        }
//        }
//    }

    }


private val VerticalScrollConsumer = object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource) = available.copy(x = 0f)
}

private val HorizontalScrollConsumer = object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource) = available.copy(y = 0f)
}

@Composable
fun rememberLazyNestedScroll(
    listState: LazyListState,
    offSet:MutableState<Float>,
//    interactionSource: MutableInteractionSource,
//    isPressed:Boolean
) = remember {
    object :NestedScrollConnection{
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
//            Log.d("OFFVALUE","$isPressed")

            val delta = available.y
            if(listState.firstVisibleItemIndex == 0){
                 val newOffset = offSet.value + delta/3
                offSet.value = newOffset.coerceIn(0f,700f)

            }
            if( listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1){
                val newOffset = offSet.value - delta/3
                offSet.value = newOffset
            }

            return Offset.Zero
        }
    }
}

//
//
//fun Modifier.disableVerticalPointerInputScroll(
//    listState: LazyListState,
//    offSet:MutableState<Float>
//) = this.nestedScroll(
//    rememberLazyNestedScroll(listState = listState,offSet))

fun Modifier.disableHorizontalPointerInputScroll() = this.nestedScroll(HorizontalScrollConsumer)

fun LazyListState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            // Await indefinitely, blocking scrolls
            awaitCancellation()
        }
    }
}

fun LazyListState.reenableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            // Do nothing, just cancel the previous indefinite "scroll"
        }
    }
}

@Composable
fun Modifier.simpleVerticalScrollbar(
    state: LazyListState,
    width: Dp = 8.dp
): Modifier {
    val targetAlpha = if (state.isScrollInProgress) 1f else 0f
    val duration = if (state.isScrollInProgress) 150 else 500

    val alpha by animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = tween(durationMillis = duration)
    )

    return drawWithContent {
        drawContent()

        val firstVisibleElementIndex = state.layoutInfo.visibleItemsInfo.firstOrNull()?.index
        val needDrawScrollbar = state.isScrollInProgress || alpha > 0.0f

        // Draw scrollbar if scrolling or if the animation is still running and lazy column has content
        if (needDrawScrollbar && firstVisibleElementIndex != null) {
            val elementHeight = this.size.height / state.layoutInfo.totalItemsCount
            val scrollbarOffsetY = firstVisibleElementIndex * elementHeight
            val scrollbarHeight = state.layoutInfo.visibleItemsInfo.size * elementHeight

            drawRect(
                color = Color.Red,
                topLeft = Offset(this.size.width - width.toPx(), scrollbarOffsetY),
                size = Size(width.toPx(), scrollbarHeight),
                alpha = alpha
            )
        }
    }
}

//fun Modifier.repeatingClickable(
//    interactionSource: MutableInteractionSource,
//    enabled: Boolean,
//    maxDelayMillis: Long = 1000,
//    minDelayMillis: Long = 5,
//    delayDecayFactor: Float = .20f,
//    onClick: () -> Unit
//): Modifier = composed {
//
//    val currentClickListener by rememberUpdatedState(onClick)
//
//    pointerInput(interactionSource, enabled) {
//        forEachGesture {
//            coroutineScope {
//                awaitPointerEventScope {
//                    val down = awaitFirstDown(requireUnconsumed = false)
//                    // Create a down press interaction
//                    val downPress = DragInteraction.Start()
//                    val heldButtonJob = launch {
//                        // Send the press through the interaction source
//                        interactionSource.emit(downPress)
//                        var currentDelayMillis = maxDelayMillis
//                        while (enabled && down.pressed) {
//                            currentClickListener()
//                            delay(currentDelayMillis)
//                            val nextMillis = currentDelayMillis - (currentDelayMillis * delayDecayFactor)
//                            currentDelayMillis = nextMillis.toLong().coerceAtLeast(minDelayMillis)
//                        }
//                    }
//                    val up = waitForUpOrCancellation()
//                    heldButtonJob.cancel()
//                    // Determine whether a cancel or release occurred, and create the interaction
//                    val releaseOrCancel = when (up) {
//                        null -> DragInteraction.Cancel(downPress)
//                        else -> DragInteraction.Stop(downPress)
//                    }
//                    launch {
//                        // Send the result through the interaction source
//                        interactionSource.emit(releaseOrCancel)
//                    }
//                }
//            }
//        }
//    }.indication(interactionSource, rememberRipple())
//}


private fun PointerEvent.isPointerUp(pointerId: PointerId): Boolean =
    changes.fastFirstOrNull { it.id == pointerId }?.pressed != true