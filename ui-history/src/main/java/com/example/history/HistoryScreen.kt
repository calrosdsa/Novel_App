package com.example.history

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isFinite
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import com.example.compose.ui.appendErrorOrNull
import com.example.compose.ui.prependErrorOrNull
import com.example.compose.ui.refreshErrorOrNull
import com.example.compose.ui.rememberFlowWithLifecycle
import com.example.novels.MainDestination

@Composable
fun HistoryNovelScreen(
    navController: NavController,
    viewModel: HistoryViewModel = hiltViewModel()
){
    val lazyPagingItems = rememberFlowWithLifecycle(flow = viewModel.pager).collectAsLazyPagingItems()
    val context = LocalContext.current
    lazyPagingItems.loadState.prependErrorOrNull()?.let {
        LaunchedEffect(it) {
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }
    }
    lazyPagingItems.loadState.appendErrorOrNull()?.let { message ->
        LaunchedEffect(message) {
            Toast.makeText(context, message.message, Toast.LENGTH_LONG).show()
        }
    }
    lazyPagingItems.loadState.refreshErrorOrNull()?.let { message ->
        LaunchedEffect(message) {
            Toast.makeText(context, message.message, Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(key1 = lazyPagingItems, block =
    {
        Log.d("STATELAZY","Refresh ${lazyPagingItems.loadState.refresh}")
    })

    LaunchedEffect(key1 = lazyPagingItems, block =
    {
        Log.d("STATELAZY", "append ${lazyPagingItems.loadState.append}")
    })

Scaffold() { padding ->


    LazyColumn(state = rememberLazyListState(),
            modifier = Modifier
                .padding(padding)
    //            .bodyWidth()
                .fillMaxHeight(),
    ) {

        items(
            items = lazyPagingItems,
            key = {item->
                 item.novel.novel_title
            }
        ) {item ->
            Column(modifier = Modifier.height(200.dp)) {
                if (item != null) {
                    Text(text = item.novel.novel_title)
                    Button(onClick = {
                        navController.navigate(MainDestination.NOVEL_DETAIL + "/${item.novel.novel_slug}")
                    }) {

                    }
                }
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


