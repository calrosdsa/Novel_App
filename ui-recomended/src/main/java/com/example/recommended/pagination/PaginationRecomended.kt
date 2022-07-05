package com.example.recommended.pagination

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmark.pager.rememberPagerStateCards
import com.example.novels.MainDestination
import com.example.recommended.RecommendedViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dev.chrisbanes.snapper.*


@OptIn(ExperimentalPagerApi::class)
@Composable
fun PaginationRecommended(
    navController: NavController,
    viewModel: RecommendedViewModel = hiltViewModel()
){
    val verticalState = rememberScrollState()
    val state = viewModel.state
//    val currentId = viewModel.currentId
    val pagerState = rememberPagerStateCards(initialPage = 0)
    val pagerStateContent = rememberPagerState(initialPage = 0)
    val currentPage = pagerState.currentPage
    val currentPageContent = pagerStateContent.currentPage
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val coroutineScope = rememberCoroutineScope()
    val covers = state.recommended?.map { novel -> novel.cover }
    val items = state.recommended?.map { it }
    val gradientGrayWhite = Brush.verticalGradient(
        0f to Color(0xFF81A9B3),
        1000f to  Color(0xFF609B1),
    )

    var seeMore by remember{ mutableStateOf(false) }
    val showFloatingButton by remember {
        derivedStateOf {
            verticalState.value > 1500
        }
    }
    LaunchedEffect(key1 =currentPageContent){
        seeMore = false
    }

  //  val mainCard  = animateDpAsState(
//        targetValue = if (currentPage == 3) 180.dp else 140.dp
  //  )
    Scaffold(
        floatingActionButton = {
           ButtonActionsRecommended(
               verticalState = verticalState,
               ids = viewModel.ids,
               currentId = viewModel.currentId,
               coroutineScope = coroutineScope,
               showFloatingButton = showFloatingButton,
               addToBookMark = {
                    viewModel.addNovelToBookMark()
               },
           )
        },
    ) {innerPadding->

Column(modifier = Modifier
    .padding(innerPadding)
    .fillMaxSize()
    .verticalScroll(verticalState)) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(gradientGrayWhite)
            .padding(vertical = 10.dp)
            .height(240.dp)) {

        TopBarRecommended(
                    navToSearchPage = { navController.navigate(MainDestination.SEARCH_SCREEN)},
                onExit = { navController.navigate(it)
            }
        )

   if (covers != null) {
       Cards(
           pagerState = pagerState,
           pagerStateContent = pagerStateContent,
           coroutineScope = coroutineScope,
           configuration = configuration,
           currentPage = currentPage,
           density = density,
           covers = covers,
           modifier = Modifier
               .align(Alignment.Center)
               .offset(y = 30.dp)
       )
   }
    }

    if (items != null) {
        Content(
            pagerState = pagerStateContent,
            recommended = items,
            pagerStateCards = pagerState,
            currentPage = currentPageContent,
            modifier = Modifier
                .fillMaxWidth(),
            getChapters = { slug:String ->  viewModel.getChaptersNovel(slug)},
            setCurrentId = {id-> viewModel.getCurrentId(id)},
            seeMore = seeMore,
            changeContent = { seeMore = it },
            navigateToNovel = {
                    slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug")
            }

        )
        Divider()
    }
    ChapterRecommended()
}
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun snapperFlignLayout(){

    val configuration = LocalConfiguration.current
    val itemWidhtScreen = configuration.screenWidthDp.dp / 4
    val contentPadding = PaddingValues(start =0.dp,
        end = 0.dp)
    val lazyListState = rememberLazyListState()
    val layoutInfo = rememberLazyListSnapperLayoutInfo(
        lazyListState,
        snapOffsetForItem = SnapOffsets.Center,
        endContentPadding = contentPadding.calculateEndPadding(LayoutDirection.Ltr))



    LazyRow(
        state = lazyListState,
        contentPadding = contentPadding,
        flingBehavior = rememberSnapperFlingBehavior(layoutInfo),
      //  horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(20) {
            Box(Modifier.width(itemWidhtScreen)) {
            Text(text ="fdff", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun snapperFlign(
){


    val lazyListState = rememberLazyListState(
        initialFirstVisibleItemIndex = Int.MAX_VALUE / 2
    )
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f),
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState)
    ) {
        items(
            count = Int.MAX_VALUE,
            key = { it }
        ) { index ->
            Box(
                Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)) {
                Text(
                    index.toString(),
                    modifier = Modifier.align(Alignment.Center)
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}





private val titles:List<String>  = listOf("Lore acksacmscmsc scmsamcs","Lore acksacmscmsc scmsamcs"
    ,"Lore acksacmscmsc scmsamcs", "Lore acksacmscmsc scmsamcs","Lore acksacmscmsc scmsamcs",
    "Lore acksacmscmsc scmsamcs","Lore acksacmscmsc scmsamcs","Lore acksacmscmsc scmsamcs",)