package com.example.bookmark.pagination.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.api.UiMessage
import com.example.bookmark.FilterOption
import com.example.bookmark.components.ItemNovelRow
import com.example.compose.ui.FilterRow
import com.example.compose.ui.SearchTopBar
import com.example.data.local.entities.FollowingEntity
import com.example.novels.MainDestination
import com.example.novels.Screen
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ReadingPage(
    modifier: Modifier = Modifier,
    loading:Boolean,
    setItem:(FollowingEntity)->Unit,
    lazyListState: LazyListState,
    setFilterOption: (FilterOption)->Unit,
    navController: NavController,
    onClick: () -> Unit,
    items:List<FollowingEntity>,
    refresh:()->Unit,
    token:String,
    visible:Boolean,
    setVisible: (Boolean) -> Unit,

) {

        Column( modifier = modifier
        ) {
            if(token.isNotBlank()) {

                FilterRow(
                    chooseOptionFilter = { setFilterOption(FilterOption.Filter) },
                    chooseOptionSorted = { setFilterOption(FilterOption.Sorted) },
                    openFilter = {
                        onClick()
                    }
                )
                SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = loading),
                    onRefresh = { refresh() }) {
                    FollowingItems(
                        lazyListState = lazyListState,
                        items = items,
                        visible = visible,
                        setVisible = { bool -> setVisible(bool) },
                        navController = navController,
                        setItem = { setItem(it) }
                    )
                }
            }else{

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            navController.navigate(Screen.Explore.route)
                        }
                ) {
                    Icon(imageVector = Icons.Outlined.AddCircleOutline, contentDescription ="AddCirleNovels",
                    modifier  =Modifier.size(60.dp),
                        tint = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Add your Favorite Novels",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
  //  }
}


@Composable
internal fun FollowingItems(
    modifier: Modifier = Modifier,
    items:List<FollowingEntity>,
    setItem: (FollowingEntity) -> Unit,
    visible:Boolean,
    navController:NavController,
    setVisible:(Boolean)->Unit,
    lazyListState: LazyListState,
) {
    LazyColumn(
        state= lazyListState,
        modifier = modifier.fillMaxSize(),
    ) {

        items(
            items = items,
            //contentType = {comment -> comment.id},
            itemContent = { it ->
                ItemNovelRow(
                    visible = visible,
                    setVisible = { setVisible(it) },
                    item = it,
                    //           getDate = { text->viewModel.getDate(text)},
                    setNovel = {novel -> setItem(novel)},
                    navToNovel = {
                        navController.navigate(MainDestination.NOVEL_DETAIL + "/$it")
                    }
                )
                Divider(modifier = Modifier.padding(vertical = 6.dp))
            }
        )
    }
}



