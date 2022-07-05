package com.example.screen.pagination

import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.data.dto.novels.Popular
import com.example.data.dto.novels.Rated
import com.example.data.dto.novels.Trend
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun RankingNovels(
    most_views:List<Popular>,
    trends:List<Trend>,
    rated:List<Rated>,
    navToNovel:(String)->Unit
   ) {


    val configuration = LocalConfiguration.current
    // var changeDirection by remember{ mutableStateOf(SwipeDirection.Right)}
    val boxSize = configuration.screenWidthDp.dp
    val densityy = with(LocalDensity.current){boxSize.toPx()}
    val springSpec = SpringSpec<Float>(
        // Determined experimentally
        stiffness = 800f,
        dampingRatio = 0.8f
    )
    val swipeableState = rememberSwipeableState(SwipeDirection.Right,springSpec)
    val scope = rememberCoroutineScope()
    Row(modifier = Modifier
        .fillMaxWidth(1f)
        .height(30.dp)
        .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
        SwipeDirection.values().map { section->
            Text(text = section.title, modifier = Modifier.clickable {
                scope.launch {
                    swipeableState.animateTo(section,springSpec)
                }
            },color = if(swipeableState.currentValue.ordinal == section.raw)MaterialTheme.colors.primary
            else MaterialTheme.colors.secondary
                ,style = MaterialTheme.typography.subtitle1
            )
        }

    }
    Divider(color = Color.DarkGray,thickness =1.dp,modifier = Modifier.fillMaxWidth())
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
            .swipeable(
                state = swipeableState,
                anchors = mapOf(
                    0f to SwipeDirection.Left,
                    densityy to SwipeDirection.Initial,
                    densityy * 2 to SwipeDirection.Right,
                ),
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )

    ) {
        Column(
            Modifier
                .offset {
                    IntOffset(
                        swipeableState.offset.value.roundToInt() - densityy.toInt() * 2,
                        0
                    )
                }
                .size(width = boxSize, height = configuration.screenHeightDp.dp)
        ) {
           most_views.forEach{
               PopularNovel(item = it, navToNovel = {slug-> navToNovel(slug)})
           }
        }

        Column(
            Modifier
                .offset {
                    IntOffset(
                        swipeableState.offset.value.roundToInt() - densityy.toInt(),
                        0
                    )
                }
                .size(width = boxSize, height = configuration.screenHeightDp.dp)

        ) {
           trends.forEach {
             TrendNovel(item = it, navToNovel = {slug->navToNovel(slug)})
           }
        }
        Column(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(width = boxSize, height = configuration.screenHeightDp.dp)
        ) {
           rated.forEach {
               RatedNovels(item = it, navToNovel = {slug->navToNovel(slug)})
           }
        }
    }
}


enum class SwipeDirection(val raw: Int,val title:String) {
    Right(0,"Most Read"),
    Initial(1,"New Trends"),
    Left(2,"User Rated"),
}