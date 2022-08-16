package com.example.bookmark.pagination.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmark.DownLoadChapterViewModel
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.data.resultentities.ChapterAndNovelImage
import com.example.novels.MainDestination

@Composable
internal fun DownLoadScreen(
    navController: NavController,
   viewModel: DownLoadChapterViewModel = hiltViewModel()
){
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    LaunchedEffect(key1 = true, block = {
    })
    Column(modifier = Modifier.fillMaxSize()) {
    LazyColumn() {
        items(
           items = state.chapters
        ){ item ->
           ChapterDownloadItem(
               item = item,
               navigateTo = { navController.navigate(MainDestination.CHAPTERS_DOWNLOAD + "/${item.novelImage.id}")}
           )
            Divider()
        }
    }
    }
}

@Composable
internal fun ChapterDownloadItem(
    item:ChapterAndNovelImage,
    navigateTo:()->Unit
){
    val count = item.novelImage.chapterCount
    Row(verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navigateTo()
            }
            .padding(5.dp)
    ) {
        Image(bitmap = item.novelImage.image.asImageBitmap(), contentDescription = item.novelImage.title,
            modifier = Modifier
                .size(70.dp, 90.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxWidth(0.7f)) {
        Text(text = item.novelImage.title, maxLines = 1)
            Text(text = if(count == item.chapters.size)"Complete $count / $count" else "${item.chapters.size}/$count" )
        }
    }
}