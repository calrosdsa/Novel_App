package com.example.chapters.indice

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Download
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.rememberAsyncImagePainter
import com.example.chapters.component.ChapterFloatingButton
import com.example.compose.common.LocalNovelDateFormatter
import com.example.compose.ui.noRippleClickable
import com.example.compose.ui.rememberFlowWithLifecycle
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.data.dto.chapters.ChapterX
import com.example.data.dto.chapters.NovelX
import com.example.data.local.entities.ChapterEntity
import com.example.data.mapper.toChapterEntity
import com.example.data.util.Constants
import com.example.novels.MainDestination
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.isActive

@Composable
fun ChapterIndiceScreen(
    navController: NavController,
   viewModel: ChaptersViewModel = hiltViewModel()
) {
    val state by rememberStateWithLifecycle(stateFlow = viewModel.state)
    val downLoad  =  remember{ mutableStateOf(false) }
    val selectChapters = remember {
    mutableStateListOf<Int>()
    }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = state, block = {
//        Log.d("CHAPTER_CONTENT",  current.toString())
    })
    Scaffold(
        floatingActionButton = {
            ChapterFloatingButton(
                listState = listState,
                coroutineScope = coroutineScope,
            )
        },
        topBar = {
            Column() {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "chapters_arrow",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    IconButton(onClick = { downLoad.value = !downLoad.value }) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "chapters_download",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Divider()
            }
        },
        bottomBar = {
            if (downLoad.value) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    TextButton(onClick = {
                        val ids = state.results?.chapters?.map { it.id }
                        if (state.results?.chapters?.size == selectChapters.size) {
                            if (ids != null) { selectChapters.removeAll(ids) } } else { if (ids != null) { selectChapters.addAll(ids) } }
                    }) {
                        Text(
                            text = if (state.results?.chapters?.size == selectChapters.size) "Cancel All" else "Select All",
                            color = MaterialTheme.colors.primary
                        )
                    }
                    TextButton(onClick = { viewModel.getAllChapterDownload(selectChapters) }) {
                        Text(text = "Download", color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            state.results?.let { result ->
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(horizontal = 5.dp),
                ) {

                    item {
                        NovelInfoChapters(
                            novel = result.novel,
                            navController = navController
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    itemsIndexed(
                        items = result.chapters,
                    ) { index, item ->
                        ChapterItems(
                            chapterX = item,
                            index = index + 1,
                            navController = navController,
                            downLoad = downLoad.value,
                            selectChapters = selectChapters ,
                            isDownload = state.chapterNovels?.chapters?.map { it.id }?.contains(item.id),
                            isSelect = selectChapters.contains(item.id),
                        )
                        Divider()
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }

            }
        }
    }
}
@Composable
internal fun NovelInfoChapters(
    novel: NovelX,
    navController: NavController,
){
    val formatter = LocalNovelDateFormatter.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.primaryVariant.copy(alpha = ContentAlpha.medium))
        .padding(10.dp)
    ) {
   Row(
       verticalAlignment = Alignment.CenterVertically
   ) {
        Box(
            Modifier
                .fillMaxWidth(0.18f)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = novel.cover),
                contentDescription = novel.cover,
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.small)
                    .width(80.dp)
                    .height(90.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.fillMaxWidth(0.8f)) {

            Column() {
                Text(text = novel.title, style = MaterialTheme.typography.h6.copy(
                    fontSize = 17.sp
                ),
                    maxLines = 1,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.noRippleClickable {
                        navController.navigate(MainDestination.CHAPTER_SCREEN +"/${novel.chapter_slug}")
                    }
                )
                Text(text ="Updated"+ formatter.getDate(novel.updated).toString(), style = MaterialTheme.typography.h6.copy(
                    fontSize = 15.sp
                ),
                    maxLines = 1,
                    color = MaterialTheme.colors.onPrimary,
                )
                Text(text = "Status ${novel.statuss}", style = MaterialTheme.typography.h6.copy(
                    fontSize = 15.sp
                ),
                    maxLines = 1,
                    color = MaterialTheme.colors.onPrimary,
                )
            }
        }
    }
        Divider(modifier = Modifier.padding(vertical = 5.dp))
        Column {
            Text(text = novel.title, style = MaterialTheme.typography.h6.copy(
                fontSize = 17.sp
            ), maxLines = 1,
                color = MaterialTheme.colors.onPrimary,
            )
            Text(text = "List of most recent chapters published for ${novel.title} novel. A total of ${novel.chapters} " +
                    "chapters have been translated and the release date of the last chapter is ${formatter.getDate(novel.updated)}",
                style = MaterialTheme.typography.caption
            )
            Text(text = "Last Released:", style = MaterialTheme.typography.h6.copy(
                fontSize = 14.sp
            ), maxLines = 1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(text = novel.chapter_title, style = MaterialTheme.typography.h6.copy(
                fontSize = 14.sp
            ), maxLines = 1,
                color = MaterialTheme.colors.primary,
                modifier =Modifier.clickable {
                    navController.navigate(MainDestination.CHAPTER_SCREEN + "/${novel.chapter_slug}")
                }
            )
        }

   }
}


@Composable
internal fun ChapterItems(
    chapterX: ChapterX,
    index:Int,
    navController: NavController,
    downLoad:Boolean,
    selectChapters: SnapshotStateList<Int>,
    isSelect:Boolean,
    isDownload: Boolean?,
){
    LaunchedEffect(key1 = true, block ={
//        Log.d("CHAPTER_CONTENT",chap?.contains(chapterX.toChapterEntity()).toString())
    } )
//    val chapter = isDownload?.id?.equals(1)
    val formatter = LocalNovelDateFormatter.current
    Row(modifier = Modifier
        .alpha(alpha = if (isDownload == true && downLoad) 0.4f else 1f)
        .fillMaxWidth()
        .noRippleClickable {
            if (downLoad) {
                if (isSelect) {
                    selectChapters.remove(chapterX.id)
                } else {
                    selectChapters.add(chapterX.id)
                }
            } else {
                navController.navigate(MainDestination.CHAPTER_SCREEN + "/${chapterX.slug}")
            }
        }
        .padding(vertical = 10.dp, horizontal = 10.dp),
        horizontalArrangement =  Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row() {
        Text(text = index.toString())
        Spacer(modifier = Modifier.width(15.dp))
        Column(modifier = Modifier) {
        Text(text = chapterX.title, maxLines = 1, modifier = Modifier.fillMaxWidth(0.6f))
            Text(text = formatter.getDateTime(chapterX.created_at).toString(),
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 11.sp
                )
            )
        }
        }
        if(isDownload == true){
            Icon(imageVector = Icons.Default.Check, contentDescription = "Check_chapter",
            modifier = Modifier
                .size(20.dp, 20.dp)
                .clip(CircleShape)
                .background(Color.Green.copy(alpha = 0.7f))
                .padding(4.dp))
        }
        if(downLoad){
        RadioButton(selected = isSelect || isDownload == true,
//            enabled = isDownload == true,
            onClick = {
             if(isSelect){ selectChapters.remove(chapterX.id) }else{ selectChapters.add(chapterX.id) }
        })
        }
    }
}
