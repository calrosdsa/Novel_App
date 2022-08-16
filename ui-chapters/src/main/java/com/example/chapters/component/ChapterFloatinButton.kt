package com.example.chapters.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun ChapterFloatingButton(
    listState: LazyListState,
    coroutineScope: CoroutineScope
){
    val lastItem = listState.layoutInfo.totalItemsCount - 1

    Column(modifier = Modifier.offset(y=20.dp)) {
        IconButton(onClick = {
            coroutineScope.launch {
                listState.animateScrollToItem(2)
            }
        }) {
        Icon(imageVector = Icons.Default.ArrowUpward, contentDescription = "ARROWUPCHAPTERS")
        }
        IconButton(onClick = {
            coroutineScope.launch {
                listState.animateScrollToItem(lastItem)
            }
        }) {
        Icon(imageVector = Icons.Default.ArrowDownward, contentDescription = "ARROWUPCHAPTERS")
        }
    }
}

fun LazyListState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1