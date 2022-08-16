package com.example.chapters.component

import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chapters.chapter_detail.ChapterState
import com.example.chapters.indice.ChaptersViewModel
import com.example.compose.common.LocalNovelDateFormatter
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.novels.MainDestination

@Composable
fun DrawerChapterContent(
    chapter: ChapterState?,
    navController: NavController,
    viewModel: ChaptersViewModel = hiltViewModel(),
){

    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    val formatter = LocalNovelDateFormatter.current

    LaunchedEffect(key1 = chapter, block = {
        chapter?.let {
            it.chapter?.let { it1 ->
                viewModel.getAllChapters(it1.novel_slug)
            }
        }
    })


    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Content",style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(15.dp))
        Divider()
        state.results?.chapters?.let {
        LazyColumn(contentPadding = PaddingValues(horizontal = 15.dp),
            modifier = Modifier.padding(top = 15.dp)
        ) {
               itemsIndexed(
                  items = it,
               ){index , it->
                   Row(modifier = Modifier.fillMaxSize()
                       .clickable { navController.navigate(MainDestination.CHAPTER_SCREEN + "/${it.slug}"){
                           popUpTo(-1516363942)
                       } },
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(text = "${index + 1}", style = MaterialTheme.typography.subtitle2)
                       Spacer(modifier = Modifier.width(15.dp))
                       Column() {
                           Text(text = it.title, style = MaterialTheme.typography.subtitle2, maxLines = 1)
                           Text(text = formatter.getDateTime(it.created_at).toString(), style = MaterialTheme.typography.subtitle2.copy(
                               fontWeight = FontWeight.Normal
                           ))

                       }
                   }
                   Spacer(modifier = Modifier.height(10.dp))
               }
            }
        }

    }
}