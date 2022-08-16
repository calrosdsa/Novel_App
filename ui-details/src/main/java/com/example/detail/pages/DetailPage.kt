package com.example.detail.pages


import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.compose.components.RatingBar
import com.example.compose.ui.rememberNestedScroll
import com.example.data.dto.novel.Comment
import com.example.detail.*
import com.example.detail.R
import com.example.novels.MainDestination
import com.example.novels.Screen
import com.google.accompanist.flowlayout.FlowRow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NovelDetailPage(
    viewModel: NovelDetailViewModel = hiltViewModel(),
    navController: NavController,
    //modifier: Modifier = Modifier,
){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val coroutineScope = rememberCoroutineScope()
    val bottomBar = 60.dp
    val bottomBarPx = with(LocalDensity.current) { bottomBar.roundToPx().toFloat() }
    var seeMore by remember{ mutableStateOf(false) }
    val state = viewModel.state.value
    val listState = rememberLazyListState()
    val gradientGrayWhite = Brush.verticalGradient(
        0f to Color(0xFF81A9B3),
        1000f to  Color(0xFF609B1),
    )
    val isFirstItem by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    val secondItem by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 1
        }
    }

    val alphaValue =  remember { mutableStateOf(1f) }
    val bottomBarHeight =  remember { mutableStateOf(0f) }

    val animatedColor = animateColorAsState(
        if (isFirstItem) MaterialTheme.colors.secondaryVariant else Color(0xFF81A9B3),
        animationSpec = tween(500)
    )
    val nestedScrollConnection = rememberNestedScroll(alphaValue,bottomBarHeight,bottomBarPx,listState)
    state.novel?.let {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(bottomBar)
                    .fillMaxWidth()
//               .zIndex(1f)
                    .offset { IntOffset(x = 0, y = bottomBarHeight.value.roundToInt()) },
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                listOfBottomItems.forEachIndexed { index, item ->
                    Column(
                        //verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .height(bottomBar)
                            .width(screenWidth / 3)
                            .background(if (index == 1) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant)
                            .clickable {
                                when (index) {
                                    2 -> viewModel.addToLibrary(it.id)
                                }
                            }
                    ) {
                        when (index) {
                            0 -> {
                                Icon(
                                    imageVector = item.iconImageVector,
                                    contentDescription = item.contentDescriptionResId.toString()
                                )
                            }
                            1 -> {
                                Icon(
                                    imageVector = item.iconImageVector,
                                    contentDescription = item.contentDescriptionResId.toString()
                                )
                            }
                            2 -> {
                                Crossfade(targetState = viewModel.ids.contains(it.id)) { bool ->
                                    if (bool) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = item.contentDescriptionResId.toString()
                                        )
                                    } else {
                                        Icon(
                                            imageVector = item.iconImageVector,
                                            contentDescription = item.contentDescriptionResId.toString()
                                        )
                                    }
                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = if (index == 2 && viewModel.ids.contains(it.id)) "ADDED" else stringResource(
                                id = item.labelResId
                            ),
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        }
    ) {padding->

    //   Column() {

           LazyColumn(
               state = listState,
               contentPadding= PaddingValues(bottom = padding.calculateBottomPadding()),
               modifier = Modifier
                   .fillMaxSize()
                   .nestedScroll(nestedScrollConnection)

                   //.weight(1f)
                   //.zIndex(0f)
                   .background(color = MaterialTheme.colors.secondaryVariant)

               //   .background(color = MaterialTheme.colors.background)
           ) {

               stickyHeader {

                   Box(
                       modifier = Modifier
                           .background(color = if (secondItem) MaterialTheme.colors.primaryVariant else animatedColor.value)
                   ) {
                       if (isFirstItem) {

                           Row(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(10.dp),
                               verticalAlignment = Alignment.CenterVertically,
                               horizontalArrangement = Arrangement.SpaceBetween
                           ) {
                               Icon(
                                   imageVector = Icons.Default.ArrowBack,
                                   contentDescription = "ArrowLeftNovelDetail",
                                   modifier = Modifier
                                       .size(29.dp)
                                       .clickable { navController.popBackStack() }
                               )
                               Text(text = "Info",
                                   style = MaterialTheme.typography.caption.copy(fontSize = 14.sp),
                                   modifier = Modifier.clickable {
                                       coroutineScope.launch {
                                           listState.animateScrollToItem(2, -120)
                                       }
                                   }
                               )
                               Text(text = "Reviews",
                                   style = MaterialTheme.typography.caption.copy(fontSize = 14.sp),
                                   modifier = Modifier.clickable {
                                       coroutineScope.launch {
                                           listState.animateScrollToItem(5)
                                       }
                                   }
                               )
                               Text(
                                   text = "Recommended",
                                   style = MaterialTheme.typography.caption.copy(fontSize = 14.sp)
                               )
                               Spacer(modifier = Modifier.width(1.dp))
                               Icon(
                                   imageVector = Icons.Default.Share,
                                   contentDescription = "ArrowLeftNovelDetail",
                                   modifier = Modifier.size(28.dp)
                               )
                           }
                       } else {
                           Row(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(10.dp),
                               verticalAlignment = Alignment.CenterVertically,
                               horizontalArrangement = Arrangement.SpaceBetween
                           ) {

                               Icon(
                                   imageVector = Icons.Default.ArrowBack,
                                   contentDescription = "ArrowLeftNovelDetail",
                                   modifier = Modifier
                                       .size(29.dp)
                                       .clickable { navController.popBackStack() }
                               )
                               Icon(
                                   imageVector = Icons.Default.Share,
                                   contentDescription = "ArrowLeftNovelDetail",
                                   modifier = Modifier.size(28.dp)
                               )

                           }
                       }
                   }

               }

               item {
                   Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .background(gradientGrayWhite)
                           .graphicsLayer {
                               alpha = alphaValue.value
                           }

                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .fillMaxHeight(),
                           horizontalArrangement = Arrangement.Center,
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Image(
                               painter = rememberAsyncImagePainter(
                                   model = it.cover
                               ),
                               contentDescription = it.cover,
                               contentScale = ContentScale.FillWidth,
                               modifier = Modifier
                                   .size(height = 200.dp, width = 155.dp)
                                   .padding(10.dp)
                                   .clip(shape = roundedItem)

                           )

                           Column() {
                               Text(text = it.title, style = MaterialTheme.typography.h6)
                               Row(
                                   verticalAlignment = Alignment.CenterVertically,
                                   modifier = Modifier.padding(8.dp)
                               ) {
                                   RatingBar(
                                       rating = it.average.toFloat(),
                                       modifier = Modifier.height(17.5.dp),
                                       color = Color(0xFFF9AA33)
                                   )
                                   Text(text = "${it.average.toFloat()}")
                               }
                               FlowRow(
                                   mainAxisSpacing = 3.dp,
                                   crossAxisSpacing = 4.dp
                               ) {
                                   it.category.forEach { category ->
                                       TagItem(tag = category.title,
                                           navToCategory={navController.navigate(Screen.Explore.route + "?category=${category.id}")},
                                           modifier = Modifier
                                               .clip(shape = com.example.detail.roundedItem)
                                               .background(color = MaterialTheme.colors.primaryVariant),
                                       )
                                   }
                               }
                           }
                       }
                   }
               }

               item {
                   Spacer(modifier = Modifier.height(30.dp))
                   Button(onClick = {
                       navController.navigate(MainDestination.CHAPTERS_SCREEN + "/${it.slug}")
//                       navController.navigate(MainDestination.HISTORY_NOVEL)
                   }) {

                   }
               }

               item {
                   Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = 15.dp)
                           .clip(shape = RoundedCornerShape(30.dp))
                           .background(color = MaterialTheme.colors.secondaryVariant),
                       contentAlignment = Alignment.Center
                   ) {
                       RowInfo(
                           views = it.novel_views,
                           BookMark = it.book_marked.size,
                           Rank = it.rank
                       )
                   }
                   Spacer(modifier = Modifier.height(5.dp))
               }

               item {
                   Spacer(modifier = Modifier.height(20.dp))
               }

               item {
                   Text(
                       text = it.description,
                       style = MaterialTheme.typography.body2,
                       color = MaterialTheme.colors.secondary,
                       modifier =Modifier.padding(horizontal = 10.dp)
                   )
                   Spacer(modifier = Modifier.height(15.dp))
               }
               item {

                   Text(
                       text = "Synopsis", style = MaterialTheme.typography.h6.copy(
                           fontSize = 16.sp,
                       ), color = MaterialTheme.colors.secondary,
                       modifier =Modifier.padding(horizontal = 10.dp)
                   )
                   Spacer(modifier = Modifier.height(15.dp))
               }
               item {
                   Box(
                       modifier = Modifier
                           .padding(horizontal = 10.dp)
                           .clickable { seeMore = !seeMore }
                           .animateContentSize()
                   ) {
                       Text(
                           text = it.sumary, style = MaterialTheme.typography.body2,
                           maxLines = if (seeMore) Int.MAX_VALUE else 3,
                           modifier =Modifier.padding(horizontal = 10.dp)
                       )
                   }
               }
               item {
                   Icon(
                       imageVector = if (seeMore) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                       contentDescription = "See more Icon",
                       modifier = Modifier.clickable { seeMore = !seeMore }
                   )
                   Divider(color = MaterialTheme.colors.onPrimary, thickness = 0.7.dp)
               }
               item {

                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(13.dp),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Column {
                           Text(
                               text = "Contents",
                               style = MaterialTheme.typography.h6.copy(
                                   fontSize = 16.sp
                               ),
                               color = MaterialTheme.colors.secondary
                           )
                           Spacer(modifier = Modifier.height(5.dp))
                           Text(
                               text = "${it.chapters} chapters",
                               style = MaterialTheme.typography.caption
                           )
                       }
                       Text(text = "Update ${viewModel.formatDate(it.updated)}",
                           color = MaterialTheme.colors.primaryVariant,
                           style = MaterialTheme.typography.caption)
                   }
                   Divider(color = MaterialTheme.colors.onPrimary, thickness = 0.7.dp)
                   Spacer(modifier = Modifier.height(10.dp))
               }

               item {

                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = 10.dp),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           text = "Tags", style = MaterialTheme.typography.h6.copy(
                               fontSize = 16.sp
                           ), color = MaterialTheme.colors.secondary
                       )
                       TextWithArrow(
                           title = "${it.tags.size} tags",
                           Icon = Icons.Default.KeyboardArrowRight
                       )
                   }
                   Spacer(modifier = Modifier.height(10.dp))
               }
               item {

                   FlowRow(
                       mainAxisSpacing = 5.dp,
                       crossAxisSpacing = 5.dp,
                   ) {
                       it.tags.forEach { tag ->
                           TagItem(
                               tag = "#${tag.title}", color = Color.Red,
                               modifier = Modifier
                                   .clip(shape = com.example.detail.roundedItem)
                                   .background(color = MaterialTheme.colors.primaryVariant),
                               navToCategory = {}
                           )
                       }
                   }
                   Spacer(modifier = Modifier.height(10.dp))
               }
               items(
                   items = it.comments,
                   key = { comment ->
                       comment.id
                   }
               ) { item ->
                   CommentItem(comment = item)
               }


           }


               //     }
       }
    }
}







@Composable
fun TagItem(tag:String,modifier: Modifier = Modifier,
            color: Color=MaterialTheme.colors.primary,
            navToCategory:()->Unit
){
    Box(modifier = modifier
        .padding(5.dp)
        .clickable {
            navToCategory()
        }
    ) {
        Text(text = tag,color=color,
            textAlign = TextAlign.Center,style = MaterialTheme.typography.body2)
    }
}





@Composable
fun CommentItem(comment: Comment) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 4.dp)
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.primaryVariant.copy(alpha = ContentAlpha.medium))
        .padding(10.dp)
    ) {
        Row() {
            Image(
                painter = rememberAsyncImagePainter(
                    model = comment.image
                ),
                contentDescription = comment.image,
                //contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(height = 60.dp, width = 60.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
            )
            Column(modifier = Modifier.padding(start = 30.dp)) {
                Text(text = comment.added_b)
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = comment.body, style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(13.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 19.dp)
                            .size(20.dp),
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Icon ThumbUp",
                        tint = MaterialTheme.colors.primary
                    )
                    Text(text = "${comment.count_likes}")
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(19.dp),
                        imageVector = Icons.Default.Message, contentDescription = "Icon ThumbUp",
                        tint = MaterialTheme.colors.primary
                    )
                    Text(text = "${comment.count_reply}")
                }
            }
        }
//    Spacer(modifier = Modifier.height(18.dp))
        //   Divider(color = MaterialTheme.colors.onPrimary)
        Spacer(modifier = Modifier.height(18.dp))

    }
}

