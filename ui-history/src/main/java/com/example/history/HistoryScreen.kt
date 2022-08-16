package com.example.history

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isFinite
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberAsyncImagePainter
import com.example.compose.common.LocalNovelDateFormatter
import com.example.compose.ui.appendErrorOrNull
import com.example.compose.ui.prependErrorOrNull
import com.example.compose.ui.refreshErrorOrNull
import com.example.compose.ui.rememberFlowWithLifecycle
import com.example.data.dto.history.HistoryDtoItem
import com.example.novels.MainDestination
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HistoryNovelScreen(
    navController: NavController,
    viewModel: HistoryViewModel = hiltViewModel()
){
    val lazyPagingItems = rememberFlowWithLifecycle(flow = viewModel.pager).collectAsLazyPagingItems()
//    val context = LocalContext.current
    val formatter = LocalNovelDateFormatter.current

//    lazyPagingItems.loadState.refreshErrorOrNull()?.let { message ->
//        LaunchedEffect(message) {
//            Toast.makeText(context, message.message, Toast.LENGTH_LONG).show()
//        }
//    }


Scaffold() { padding ->

    SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = lazyPagingItems.loadState.refresh == LoadState.Loading),
        onRefresh = { lazyPagingItems.refresh() },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = true
            )
        }
    ) {

    LazyColumn(state = rememberLazyListState(),
            modifier = Modifier
                .padding(padding)
                //            .bodyWidth()
                .fillMaxHeight(),
    ) {

        items(
            items = lazyPagingItems,
            key = {item->
                 item.novel_title
            }
        ) {item ->
            if(item != null){
           HistoryNovelItem(
               item=item,
               getDate = { formatter.getDate(item.viewed_on) },
               navToNovel = {navController.navigate(MainDestination.NOVEL_DETAIL + "/${item.novel_slug}")},
               navToChapter = {navController.navigate(MainDestination.CHAPTER_SCREEN + "/${item.last_chapter_slug}")}
           )
                Divider()
            }
        }

        lazyPagingItems.apply {
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
            }
        }
    }
    }
//        item {
//
//        if (lazyPagingItems.loadState.prepend == LoadState.Loading) {
//                Box(
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(24.dp)
}
//                ) {
//                    CircularProgressIndicator(Modifier.align(Alignment.Center))
//                }
//            }
//        }
 //   }
}

object Layout{


val bodyMaxWidth: Dp
    @Composable get() = when (LocalConfiguration.current.screenWidthDp) {
        in 0..599 -> Dp.Infinity
        in 600..904 -> Dp.Infinity
        in 905..1239 -> 840.dp
        in 1240..1439 -> Dp.Infinity
        else -> 1040.dp
    }
}


fun Modifier.bodyWidth() = fillMaxWidth()
    .wrapContentWidth(align = Alignment.CenterHorizontally)
    .composed {
        val bodyMaxWidth = Layout.bodyMaxWidth
        if (bodyMaxWidth.isFinite) widthIn(max = bodyMaxWidth) else this
    }
    .composed {
        padding(
            WindowInsets.systemBars
                .only(WindowInsetsSides.Horizontal)
                .asPaddingValues()
        )
    }



@Composable
internal fun HistoryNovelItem(
   item: HistoryDtoItem,
   getDate:()->CharSequence?,
   navToNovel:()->Unit,
   navToChapter:()->Unit
){
    Row(verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navToNovel()
            }
            .padding(5.dp)
    ) {
        Image(painter = rememberAsyncImagePainter(model = item.novel_cover), contentDescription = item.novel_title,
            modifier = Modifier
                .size(66.dp, 86.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxWidth(0.7f)) {
            Text(text = item.novel_title, maxLines = 1,
            style = MaterialTheme.typography.subtitle1.copy(
                color = MaterialTheme.colors.onPrimary,
            ))
            Text(text = "Progress: ${item.progress}/${item.chapters} (${item.progress * 100 / item.chapters}%)", maxLines = 1,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = MaterialTheme.colors.onPrimary.copy(
                        alpha = 0.6f
                    ),
                    fontSize = 13.sp,
                ))
            Text(text = "Last Read: $getDate", maxLines = 1,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = MaterialTheme.colors.onPrimary.copy(
                        alpha = 0.6f
                    ),
                    fontSize = 13.sp,
                ))
            Text(text = item.last_chapter, maxLines = 1,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = MaterialTheme.colors.primary,
                    fontSize = 13.sp,
                ),modifier = Modifier.clickable {
                    navToChapter()
                })
        }
    }
}