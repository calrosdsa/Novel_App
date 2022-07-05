package com.example.detail
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.detail.componnets.DetailPlaceholder
import com.example.detail.pages.NovelDetailPage
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

//@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NovelDetail(
    navController: NavController,
  //  modifier: Modifier = Modifier,
    viewModel: NovelDetailViewModel = hiltViewModel()){
    val state = viewModel.state.value
    val swipeRefreshState = rememberSwipeRefreshState(viewModel.isRefresh.value)
//    var seeMore by remember{ mutableStateOf(false)}
          SwipeRefresh(state = swipeRefreshState,
              onRefresh = {
                  viewModel.refresh()
              },
          ) {
      Box(modifier = Modifier
          .fillMaxSize()
          .background(color = MaterialTheme.colors.background)) {


              if(state.is_loading){
                 DetailPlaceholder()
              }


              if(state.error.isNotBlank()){
                  LazyColumn(modifier = Modifier.fillMaxSize()){
                      item {
                          Text(text = state.error,modifier = Modifier
                              .fillMaxSize()
                              .align(Alignment.Center))

                      }
                  }
              }

              if(state.novel != null) {
                  NovelDetailPage(navController=navController)
                  }
      }
      }
      }


@Composable
fun TextWithArrow(title: String,Icon:ImageVector){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = title,style = MaterialTheme.typography.body2.copy(
            fontSize = 13.sp,
            color = Color.DarkGray
        ))
         Icon(imageVector = Icon , contentDescription = "Tag size")
    }
}

@Composable
fun RowInfo(
    views:Int,
    BookMark:Int,
    Rank:Int
){

   Row(modifier = Modifier.fillMaxWidth(0.90f).padding(10.dp)
       ,verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceBetween
          ) {
     ColumnItem(title = "Rank",number = Rank)
       ColumnItem(title = "Views",number = views)
       ColumnItem(title = "BookMarks",number = BookMark)

   }
}
@Composable
fun ColumnItem(title:String,number:Int){
    Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title,style = MaterialTheme.typography.caption,)
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = "${number}",style = MaterialTheme.typography.h6,color=MaterialTheme.colors.primary)
    }
}
@Composable
fun Tag(tag:String,modifier: Modifier = Modifier,color: Color=MaterialTheme.colors.primary){
    Box(modifier = modifier
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.onPrimary,
            shape = RoundedCornerShape(30.dp)
        )
        .padding(5.dp)) {
        Text(text = tag,color=color,
            textAlign = TextAlign.Center,style = MaterialTheme.typography.body2)
    }
}
val roundedItem = RoundedCornerShape(15.dp)
