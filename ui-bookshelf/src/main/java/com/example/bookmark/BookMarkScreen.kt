package com.example.bookmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmark.pagination.pages.DownLoadScreen
import com.example.compose.ui.SearchTopBar
import com.example.history.HistoryNovelScreen
import com.example.novels.MainDestination
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun BookMarkScreen(
    navController: NavController,
 //    modifier: Modifier,
    state:ScaffoldState,
) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val pages = listOf<String>("Following","History","DownLoad")
    val currentPage = pagerState.currentPage
    Scaffold(
        topBar = {
            SearchTopBar(
                state = state,
                navController = navController,
                coroutineScope = coroutineScope
            )
        },
        scaffoldState = state
    ) {
        Column(Modifier.padding(it)) {
            TabRow(
                selectedTabIndex = currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                    )
                }
            ) {
                pages.forEachIndexed { index, pair ->
                    Tab(selected = currentPage == index, onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }, text = {
                        Text(text = pair)
                    })
                }
            }
            HorizontalPager(
                count = pages.size,
                state = pagerState,
                modifier = Modifier.weight(1f),
//                flingBehavior = rememberFlingBehaviorMultiplier(
//                    multiplier = 1.2f,
//                    baseFlingBehavior = PagerDefaults.flingBehavior(pagerState)
//                ),
                ) { index ->
                if(index == 0){
                    ModalBottomSheetBookMark(
                        navController = navController,
                        scaffoldState = state,
                        coroutineScope = coroutineScope
                    )
                }
                if(index ==1){
                   HistoryNovelScreen(navController = navController)
                }
                if(index ==2){
                    DownLoadScreen(
                        navController = navController
                    )
                }
            }
        }
    }
}

