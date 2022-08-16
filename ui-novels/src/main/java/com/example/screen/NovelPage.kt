package com.example.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import com.example.compose.components.VerticalGrid
import com.example.compose.ui.SearchTopBar
import com.example.data.dto.novels.Completed
import com.example.data.mapper.toNovelItem
import com.example.novels.MainDestination
import com.example.novels.Screen
import com.example.screen.componnets.RowPopularNovels
import com.example.screen.componnets.novelGrid
import com.example.screen.pagination.RankingNovels
import com.example.screen.novels.NovelsViewModel
import com.example.screen.pagination.LastChapters


@Composable
fun NovelPage(
    navController: NavController,
    //openSettings: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NovelsViewModel = hiltViewModel()) {
    val novels = viewModel.state.value.novels


        if (novels != null) {
            Box(
                modifier = modifier
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "New Release",
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = stringResource(R.string.see_more),
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.Explore.route + "?ordering=-created")
                            }
                        )

                    }

                    RowPopularNovels(
                        nav = { slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug") },
                        popular = novels.posts.map { it.toNovelItem() }
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Column(
                        modifier = Modifier
                            .height(740.dp)
                            .padding(horizontal = 10.dp)
                            .clip(MaterialTheme.shapes.small)
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.primaryVariant.copy(alpha = 0.5f))
                    ) {

                        RankingNovels(
                            most_views = novels.popular,
                            trends = novels.trends,
                            rated = novels.rated,
                            navToNovel = { slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug") }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Completed Stories",
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = stringResource(R.string.see_more),
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.Explore.route + "?status=3")
                            }
                        )
                    }

                    RowPopularNovels(
                        nav = { slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug") },
                        popular = novels.completed.map { it.toNovelItem() }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    ListGridNovel(
                        novels = novels.completed,
                        //onNovelClick = onNovelClick
                    )
                    Spacer(modifier = Modifier.height(10.dp))


                    Text(
                        text = "Weekly Most Active",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(7.dp)
                    )
                    RowPopularNovels(
                        nav = { slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug") },
                        popular = novels.weekly.map { it.toNovelItem() }
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "New Release",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(7.dp)

                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    novels.chapters.forEach {
                        LastChapters(
                            item = it,
                            navToNovel = { slug -> navController.navigate(MainDestination.NOVEL_DETAIL + "/$slug") })
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
//        else{
//            Box(modifier = Modifier.fillMaxSize()){
//                    Row(modifier = Modifier.align(Alignment.Center)
//                        .clip(MaterialTheme.shapes.small)
//                        .background(MaterialTheme.colors.primary)
//                        .clickable { viewModel.getNovels() }
//                        .padding(10.dp)
//                    ) {
//                        Text(text = "Refresh Page")
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Icon(imageVector = Icons.Default.Refresh, contentDescription ="refresh_page_" )
//                    }
//                }
//        }
    }


private val shape = RoundedCornerShape(7.dp)



@Composable
fun ListGridNovel(
    novels: List<Completed>,
  //  modifier: Modifier = Modifier,
 //   onNovelClick: (String) -> Unit
){
    Box(modifier = Modifier
        .clip(shape = shape)
        .padding(horizontal = 10.dp)
        .background(MaterialTheme.colors.primaryVariant.copy(alpha = 0.5f)),
    ) {

        Column() {
            Text(
                text = "Weekly Featured",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .wrapContentHeight()
            )
            VerticalGrid(
                columns = 4,
                modifier = Modifier.padding(10.dp)
            ) {
                novels.forEach { novel ->
                    novelGrid(novelTitle = novel.title, novelCover = novel.cover
//                        ,novelSlug=novel.slug
                        //onNovelClick=onNovelClick)
                    )
                }
            }
            Spacer(Modifier.height(4.dp))
        }
    }
}


