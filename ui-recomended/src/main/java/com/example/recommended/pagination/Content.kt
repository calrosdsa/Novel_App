package com.example.recommended.pagination

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmark.pager.PagerStateCards
import com.example.data.dto.recommended.RecommendedItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Content(
    pagerState: PagerState,
    pagerStateCards: PagerStateCards,
    changeContent: (Boolean)-> Unit,
    seeMore:Boolean,
    currentPage:Int,
    recommended: List<RecommendedItem>,
    modifier: Modifier = Modifier,
    getChapters: (String) -> Unit,
    setCurrentId: (Int) -> Unit,
    navigateToNovel: (String) -> Unit,
//    viewModel: RecommendedViewModel = hiltViewModel()

){
    LaunchedEffect(key1 = pagerState.currentPage){
        pagerStateCards.animateScrollToPage(currentPage)
    }
    LaunchedEffect(key1 = pagerState.currentPage){
        delay(1000)
        getChapters(recommended[currentPage].slug)
    }
    LaunchedEffect(key1 = pagerState.currentPage){
        setCurrentId(recommended[currentPage].id)
    }



    HorizontalPager(
        count = recommended.size,
        state = pagerState,
        modifier = modifier
//        itemSpacing = 2.dp,
  //      contentPadding = PaddingValues(itemWithScreen),
        ) {i->
        val item = recommended[i]
        //val itemSlug = recommended?.get(i -1)
        Column(
            modifier =Modifier.padding(horizontal = 15.dp),
            //verticalArrangement = Arrangement.Center,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
//                  Spacer(modifier =Modifier.height(10.dp) )
            Box(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.title, style = MaterialTheme.typography.h6.copy(
                        fontSize = 20.sp,
                    ),
                    maxLines = 2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        //.offset(y=10.dp)
                               .align(Alignment.Center)
                        .clickable {
                            navigateToNovel(item.slug)
                        }
                )
            }
                Divider()
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Sinopsis", style =MaterialTheme.typography.h6.copy(
                    fontSize = 16.sp, color = MaterialTheme.colors.primary
                ),
                    textAlign = TextAlign.Start

                )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier
                .clickable { changeContent(!seeMore) }
                .animateContentSize()) {
            Text(
                    text = item.sumary,
                    maxLines = if(seeMore) 10 else 3,
                    style = MaterialTheme.typography.body2,
                    //modifier = Modifier.fillMaxWidth()
                )
            }
            Icon(
                imageVector = if (seeMore) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "See more Icon",
                modifier = Modifier.clickable { changeContent(!seeMore) }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
