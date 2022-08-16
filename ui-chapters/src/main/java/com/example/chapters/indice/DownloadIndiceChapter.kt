package com.example.chapters.indice

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.common.LocalNovelDateFormatter
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.novels.MainDestination

@Composable
fun DownlaodIndiceChapter(
    navController: NavController,
    viewModel: DownloadIndiceViewModel = hiltViewModel()
) {
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    val formatter = LocalNovelDateFormatter.current
    var deleteAlert by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true, block = {
        Log.d("CHAPTER_CONTENT",navController.currentDestination?.id.toString())
    })
    Column( modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "indice_download_back")
            }
        state.chapterNovels?.novelImage?.let {
            Text(text = it.title, maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
//            state.chapterNovels?.chapters.let {
            IconButton(onClick = { deleteAlert = true }){
                Icon(imageVector = Icons.Default.Delete, contentDescription = "indice_download_back")
            }

        }
        Divider(modifier = Modifier.padding(vertical = 5.dp))
        LazyColumn(
        ) {
            state.chapterNovels?.let {
                itemsIndexed(
                    items = it.chapters
                ) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(MainDestination.CHAPTER_DOWNLOAD_DETAIL + "/${item.slug}")
                            }
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "${index + 1}")
                        Spacer(modifier = Modifier.width(15.dp))
                        Column(modifier = Modifier) {
                            Text(
                                text = item.title,
                                maxLines = 1,
                                modifier = Modifier.fillMaxWidth(0.7f)
                            )
                            Text(
                                text = formatter.getDateTime(item.created_at).toString(),
                                style = MaterialTheme.typography.body2.copy(
                                    fontSize = 11.sp
                                )
                            )
                        }
                    }
                    Divider(modifier = Modifier.padding(vertical = 5.dp))
                }
            }
        }
    }

    if(deleteAlert){
        Dialog(onDismissRequest = { deleteAlert = false }) {
            Column(modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(20.dp)
            ) {
                Text(
                    text = "Confirm deletion of chapters?",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(color=MaterialTheme.colors.primaryVariant)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(0.5f)) {
                        Text(
                            text = "Discard", style = MaterialTheme.typography.h6.copy(
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(10.dp)
                        )
                    }
                    Divider(
                        color=MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .height(38.dp)
                            .width(1.dp)
                    )
                    Box(modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clickable {
                            viewModel.deleteChapters(
                                state.chapterNovels?.chapters?.map { it.id },
                                state.chapterNovels?.novelImage?.id
                            )
                            deleteAlert = false
                            navController.popBackStack()
                        }
                    ) {
                        Text(
                            text = "Sure", style = MaterialTheme.typography.h6.copy(
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(10.dp)
                        )
                    }
                }

            }
        }
    }

}
