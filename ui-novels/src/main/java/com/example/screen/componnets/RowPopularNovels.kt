package com.example.screen.componnets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.mapper.NovelItem
import com.example.screen.R
@Composable
fun RowPopularNovels(
    nav:(String)-> Unit,
    popular: List<NovelItem>){



    LazyRow(modifier = Modifier.fillMaxSize()
        .background(MaterialTheme.colors.primaryVariant.copy(alpha = 0.5f)),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp)
        ){
     items(
         count = popular.size,
         key = {
             popular[it].id
         },
         itemContent = {index ->
             val item = popular[index]
            PopularItem(nav={
                            slug -> nav(slug)
            }
                ,item = item)
             Spacer(modifier = Modifier.width(10.dp))
         }
             )


     }
    }


@Composable
fun PopularItem(
    nav: (String)-> Unit,
    item: NovelItem){
        Box(modifier = Modifier
            .height(150.dp)
            .width(90.dp),

        ) {
    Column() {

        IconImagePlace(
            novelCover = item.cover,
            modifier = Modifier
                .height(110.dp)
                .width(85.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .clickable {
                           nav(item.slug)
                },
            count = item.average.toString(),
        cover = item.cover
        )
    //    {
 //           Row(
 //               verticalAlignment = Alignment.CenterVertically,
 //                modifier = Modifier
 //                   .background(color = MaterialTheme.colors.background)
   //                 .padding(horizontal = 2.dp)
     //               .clip(shape = MaterialTheme.shapes.medium)
       //     ) {
         //   Icon(
  //              modifier = Modifier.size(18.dp,18.dp),
   //             tint= Color.LightGray,
    //            imageVector =Icons.Default.BookmarkAdded, contentDescription =item.cover )
      //          Spacer(modifier = Modifier.width(5.dp))
     //       Text(text = item.markeds.toString(),style = MaterialTheme.typography.subtitle2, modifier=Modifier.padding(top = 4.dp),)
     //       }

      //  }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = item.title,
        style = MaterialTheme.typography.subtitle2.copy(
            fontSize = 13.sp
        ),
        maxLines = 2,
            lineHeight = 15.sp,
        )
        }
    }
}


