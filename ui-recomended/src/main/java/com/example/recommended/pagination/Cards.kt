package com.example.recommended.pagination

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.recommended.pager.HorizontalPagerCard
import com.example.bookmark.pager.PagerStateCards
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Cards(
    pagerState: PagerStateCards,
    pagerStateContent: PagerState,
    coroutineScope: CoroutineScope,
    configuration:Configuration,
    currentPage:Int,
    density: Density,
    covers: List<String>,
    modifier: Modifier = Modifier,
  //  viewModel: RecommendedViewModel  = hiltViewModel()
) {
    //val state = viewModel.state
    val itemWithScreen = configuration.screenWidthDp.dp / 3
    val itemWidthPx = with(density) {
        itemWithScreen.roundToPx()
    }

    val widthItem = with(density) {
        (itemWidthPx * 0.7).roundToInt().toDp()
    }

    //var editable by remember { mutableStateOf(true) }

    //  SideEffect {
    //      editable = true
    //  }

    LaunchedEffect(key1 = pagerState.currentPage){
        delay(10)
        pagerStateContent.scrollToPage(currentPage)
    }


        HorizontalPagerCard(
            count = covers.size,
            state = pagerState,
            itemSpacing = 7.dp,
            contentPadding = PaddingValues(horizontal = itemWithScreen),
            modifier = modifier,
        ) { i ->
            val alpha: Float by animateFloatAsState(if (currentPage == i) 1.3f else 1f)
            val mainCard = animateDpAsState(targetValue = if (currentPage == i) 17.dp else 2.dp)
            val item:String = covers[i]
            //     PaginationRecommended()


                Image(
                    painter = rememberAsyncImagePainter(model = "https://res.cloudinary.com/farav/image/upload/v1/${item}"),
                    contentDescription = item,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(if (currentPage == i) itemWithScreen.minus(12.dp) else widthItem)
                        .height(108.dp)
                        .scale(alpha)
                        .padding(horizontal = mainCard.value)
                        .clip(shape = RoundedCornerShape(10.dp))
                        //.background(color = MaterialTheme.colors.primary)
                        .clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(i)
                            }
                            //           editable = !editable
                        }
                )


        }

    }
