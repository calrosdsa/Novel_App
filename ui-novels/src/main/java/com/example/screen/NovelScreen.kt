package com.example.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.ui.SearchTopBar
import com.example.compose.ui.rememberNestedScroll
import com.example.compose.ui.rememberNestedScrollFloatingButton
import com.example.novels.MainDestination

@Composable
fun NovelScreen(
    navController: NavController,
    scaffoldState: ScaffoldState
){

    val widthFloatingButton = 160.dp
    val widthFloatingButtonToPx = with(LocalDensity.current){widthFloatingButton.roundToPx().toFloat()}
    val floatingOffset = remember {
        mutableStateOf(0f)
    }

    val floatingButtonScroll = rememberNestedScrollFloatingButton(
        barOffset = floatingOffset,
        barHeight = widthFloatingButtonToPx,
    )
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SearchTopBar(
                state = scaffoldState,
                navController = navController,
                coroutineScope = coroutineScope
            )
        },
        floatingActionButton = {
            FloatingButtonNovel(width = widthFloatingButton,position = floatingOffset) {
                navController.navigate(MainDestination.RECOMMENDED_SCREEN)
            }
        }
    ) {
        NovelPage(
            navController = navController,
            modifier = Modifier
                .nestedScroll(floatingButtonScroll)
                .padding(it))
    }
}

@Composable
internal fun FloatingButtonNovel(
    width:Dp,
    position:MutableState<Float>,
    navToPage:()->Unit,
){
    val gradientGrayWhite = Brush.horizontalGradient(
        0f to Color.Magenta,
        1000f to  Color.Cyan,
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .offset {
                IntOffset(x = position.value.toInt(), y = 0)
            }
            .width(width)
            .clip(MaterialTheme.shapes.medium)
            .background(gradientGrayWhite)
            .padding(end = 3.dp)
            .clickable {
                navToPage()
            }) {
            Icon(imageVector = Icons.Default.Star, contentDescription ="FloatingStar",
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp)
                .clip(MaterialTheme.shapes.small)
            )
        Text(text = "Recommended", style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Medium
        ))
    }
}