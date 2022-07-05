package com.example.screen.latestChapters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.example.data.dto.chaptersLatest.Result

@Composable
fun LatestChaptersScreen(
    viewModel: LatestChaptersViewModel = hiltViewModel()
) {
    //val context = LocalContext.current
    val state = viewModel.pager.collectAsLazyPagingItems()




    LazyColumn(state = rememberLazyListState()) {
        items(state){ item ->
           LastChapterNovelItem(result = item!!)
        }

    state.apply{
        when{
            loadState.refresh is LoadState.Loading ->{
                item {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    CircularProgressIndicator(modifier = Modifier.align(Center))
                }
                }
            }

            loadState.append is LoadState.Loading ->{
                item {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    CircularProgressIndicator(modifier = Modifier.align(Center))
                }
                }
            }

            loadState.prepend is LoadState.Loading ->{
                item {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    CircularProgressIndicator(modifier = Modifier.align(Center))
                }
                }
            }

        }
    }
    }
}


@Composable
fun LastChapterNovelItem(result:Result){
    Row(verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()) {
        Image(
            painter =rememberAsyncImagePainter(
                model = result.novel_cover),
            contentDescription = result.novel_cover,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth(0.25f)
                .clip(shape = RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = result.title)
        Spacer(modifier = Modifier.height(5.dp))
    }
}


