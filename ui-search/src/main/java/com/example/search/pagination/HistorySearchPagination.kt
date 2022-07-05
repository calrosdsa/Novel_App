package com.example.search.pagination

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.compose.ui.rememberFlowWithLifecycle
import com.example.novels.MainDestination
import com.example.search.components.ResultSearchRow

@Composable
fun AllHistory(
    navController: NavController,
    viewModel: HistorySearchViewModel = hiltViewModel()
) {
    val state = rememberFlowWithLifecycle(flow = viewModel.pagedList).collectAsLazyPagingItems()


    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(state = rememberLazyListState()) {
            items(state) { item ->
                if (item != null) {
                    ResultSearchRow(resultSearch = item,  modifier = Modifier.clickable {
                        navController.navigate(MainDestination.NOVEL_DETAIL + "/${item.slug}")
                    })
                }
            }
            state.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        }
                    }

                    loadState.prepend is LoadState.Loading -> {
                        item {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        }
                    }

                }
            }
        }
    }
}
