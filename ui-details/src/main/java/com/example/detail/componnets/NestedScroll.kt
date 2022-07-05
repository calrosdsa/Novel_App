package com.example.detail.componnets
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlin.math.abs
import kotlin.math.roundToInt

// here we use LazyColumn that has build-in nested scroll, but we want to act like a
// parent for this LazyColumn and participate in its nested scroll.
// Let's make a collapsing toolbar for LazyColumn
@Composable
fun Nested(){


val toolbarHeight = 48.dp
val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
// our offset to collapse toolbar
val toolbarOffsetHeightPx =

    remember { mutableStateOf(0f) }
// now, let's create connection to the nested scroll system and listen to the scroll
// happening inside child LazyColumn
val nestedScrollConnection = remember {
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
            val delta = available.y
            val newOffset = toolbarOffsetHeightPx.value + delta
            toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
            // here's the catch: let's pretend we consumed 0 in any case, since we want
            // LazyColumn to scroll anyway for good UX
            // We're basically watching scroll without taking it
            return Offset.Zero
        }
    }
}
Box(
Modifier
.fillMaxSize()
// attach as a parent to the nested scroll system
.nestedScroll(nestedScrollConnection)
) {
    // our list with build in nested scroll support that will notify us about its scroll
    LazyColumn(contentPadding = PaddingValues(top = toolbarHeight)) {
        items(100) { index ->
            Text("I'm item $index", modifier = Modifier.fillMaxWidth().padding(16.dp))
        }
    }
    TopAppBar(
        modifier = Modifier
            .height(toolbarHeight)
            .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
        title = { Text("toolbar offset is ${toolbarOffsetHeightPx.value}") }
    )
}
}



@Composable
fun DismissibleAppBar(){
    val appBarHeight = 60.dp
    var height by remember {
        mutableStateOf(0f)
    }
    val density = LocalDensity.current
    val animatedHeight by animateDpAsState(targetValue = with(density){height.toDp()})
    Column(modifier = Modifier.fillMaxSize()){
        TopAppBar(modifier = Modifier
            .background(Color.Red)
            .height(height = animatedHeight)
        ){}
        LazyScrollView(onOffsetChanged = {
            Log.d("OFFSET","$it")
            height = it
        }, appBarHeight = appBarHeight)
    }
}

@Composable
fun rememberNestedScrollConnection(onOffsetChanged:(Float)->Unit,appBarHeight:Float) = remember {
    var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            Log.d("AVAILABLE","$available")
            currentHeight = (currentHeight+available.y).coerceIn(minimumValue = 0f, maximumValue = appBarHeight)
            return if(abs(currentHeight) == appBarHeight || abs(currentHeight) == 0f){
                super.onPreScroll(available, source)
            }else{
                onOffsetChanged(currentHeight)
                available
            }
        }

        override suspend fun onPreFling(available: Velocity): Velocity {
            if(available.y<0){
                onOffsetChanged(0f)
            }else{
                onOffsetChanged(appBarHeight)
            }
            return super.onPreFling(available)
        }
    }
}

@Composable
fun LazyScrollView(onOffsetChanged: (Float) -> Unit, appBarHeight: Dp){
    val pixelValue = with(LocalDensity.current){appBarHeight.toPx()}
    val nestedScrollState = rememberNestedScrollConnection(onOffsetChanged = onOffsetChanged, appBarHeight = pixelValue)
    LaunchedEffect(key1 = Unit, block = {
        onOffsetChanged(pixelValue)
    })
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)
        .nestedScroll(nestedScrollState)){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(count = 50){index ->
                Text(text = "Some $index", modifier = Modifier.padding(8.dp), color = MaterialTheme.colors.onBackground)
            }
        }
    }

}

fun Offset.roundToIntOffset():IntOffset{
    return IntOffset(x = this.x.roundToInt(),y = this.y.roundToInt())
}