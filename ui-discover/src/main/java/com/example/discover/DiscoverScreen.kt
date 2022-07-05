package com.example.discover

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.compose.ui.SearchTopBar
import com.example.compose.ui.appendErrorOrNull
import com.example.compose.ui.refreshErrorOrNull
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.discover.components.GenreCategoryList
import com.example.discover.components.NovelItem
import com.example.discover.components.SortedBy
import com.example.discover.components.StatusNovel
import com.example.novels.MainDestination
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlin.math.roundToInt

@Composable
fun DiscoverScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: DiscoverViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val state by rememberStateWithLifecycle(viewModel.state)
    val pagingItems = viewModel.pagingList.collectAsLazyPagingItems()
    pagingItems.loadState.appendErrorOrNull()?.let { message ->
        LaunchedEffect(message) {
            Toast.makeText(context, message.message, Toast.LENGTH_SHORT)
        }
    }
    pagingItems.loadState.refreshErrorOrNull()?.let { message ->
        LaunchedEffect(message) {
            Toast.makeText(context, message.message, Toast.LENGTH_SHORT)
        }
    }


    state.message?.let {
        LaunchedEffect(key1 = it, block = {
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            viewModel.clearMessage(it.id)
            navController.navigate(MainDestination.HOME_ROUTE)

        })
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SearchTopBar(
                state = scaffoldState,
                navController = navController,
                coroutineScope = coroutineScope
            )
        },
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 10.dp)
        ) {
//        Column(modifier = Modifier
//            .height(barHeight)
//            .offset { IntOffset(x = 0, y = barOffSet.value.roundToInt()) }
//        ) {
            SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = pagingItems.loadState.refresh == LoadState.Loading),
                onRefresh = { pagingItems.refresh() },
                indicator = { state, trigger ->
                    SwipeRefreshIndicator(
                        state = state,
                        refreshTriggerDistance = trigger,
                        scale = true
                    )
                }
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(top = 10.dp),
                    state = listState
                ) {
//            item{
                    state.categoryEntity?.let {
                        item {
                            Text(
                                text = "Genre / Category", style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.onPrimary.copy(
                                    alpha = 0.8f
                                )
                            )
                            Divider(Modifier.fillMaxWidth(0.4f), thickness = 1.5.dp)
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        item {
                            GenreCategoryList(
                                categories = it,
                                setCategory = { category -> viewModel.setCategory(category) },
                                currentCategory = viewModel.filter.value.category
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Status", style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.onPrimary.copy(
                                    alpha = 0.8f
                                )
                            )
                            Divider(Modifier.fillMaxWidth(0.4f), thickness = 1.5.dp)
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        item {
                            StatusNovel(
                                setStatus = { viewModel.setStatus(it) },
                                currentStatus = viewModel.filter.value.status
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Sorted By", style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.onPrimary.copy(
                                    alpha = 0.8f
                                )
                            )
                            Divider(Modifier.fillMaxWidth(0.4f), thickness = 1.5.dp)
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                        item {
                            SortedBy(
                                setOrdering = { viewModel.setOrdering(it) },
                                current = viewModel.filter.value.ordering
                            )
                        }
                        //         isCategorySelected = true
//        }
                    }
                    items(
                        items = pagingItems,
                        key = {
                            it.id
                        }
                    ) { item ->
                        if (item != null) {
                            NovelItem(
                                item = item,
                                navToNovel = { navController.navigate(MainDestination.NOVEL_DETAIL + "/${it}") }
                            )
                            Divider()
                        }
                    }
                    if (pagingItems.loadState.append == LoadState.Loading) {
                        item {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp)
                            ) {
                                CircularProgressIndicator(Modifier.align(Alignment.Center))
                            }
                        }
                    }
                }
            }
//        if(state.loading){
//        CircularProgressIndicator()
//        }
        }
    }
}
