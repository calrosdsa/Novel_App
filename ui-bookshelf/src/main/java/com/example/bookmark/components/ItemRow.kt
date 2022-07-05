package com.example.bookmark.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.entities.FollowingEntity

@Composable
fun ItemNovelRow(
    item:FollowingEntity,
    visible:Boolean,
    setVisible:(Boolean)-> Unit,
    setNovel:(FollowingEntity)-> Unit,
    navToNovel:(String)->Unit,
){
  //  val formatter = LocalTiviDateFormatter.current
  //  val formattedDate = formatter.formatShortRelativeTime(item.added)


    Row(modifier = Modifier
        .fillMaxWidth(),
   //     .combinedClickable(
     //       onClick = { },
       //     onLongClick = {
         //           setNovel(item)
           //         setVisible(!visible)
          //  },
            //)
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            Modifier
                .fillMaxWidth(0.18f)) {
            item.cover?.let {
                Image(bitmap = it.asImageBitmap(),
                    contentDescription = "Cover BookMark",
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.small)
                        .fillMaxWidth()
                        .heightIn(50.dp, 95.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth(0.70f)) {
            Text(text = item.title, style = MaterialTheme.typography.h6.copy(
                fontSize = 17.sp
            ),
                maxLines = 1,
                modifier = Modifier.clickable{
                    navToNovel(item.slug)
                }
            )
            Row(verticalAlignment = Alignment.CenterVertically){

            Icon(imageVector = Icons.Default.Update, contentDescription = "Date BookMark",modifier=Modifier.size(17.dp),
                tint = Color.DarkGray
            )
                Spacer(modifier = Modifier.width(10.dp))
            Text(text = "${item.id}" ,color =  Color.DarkGray)

            }
            Text(text = "Progress: ${item.progress}/${item.chapters} (${item.progress * 100 / item.chapters}%)",
                color =  Color.DarkGray
            )
            Text(
                text = if(item.options.contains(1)) "New Chapters" else "No Updates",
                color = if(item.options.contains(1)) MaterialTheme.colors.primary else Color.DarkGray,
            )
        }

        Column(
            modifier = Modifier.heightIn(90.dp,100.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Row(modifier= Modifier.widthIn(50.dp),
                horizontalArrangement = Arrangement.End
            ) {
                if(item.options.contains(3)){
                Icon(imageVector = Icons.Default.Star, contentDescription ="IconNotificationBook", modifier = Modifier.size(23.dp) )
                Spacer(modifier = Modifier.widthIn(5.dp))
                }
                Icon(imageVector = Icons.Default.Notifications, contentDescription ="IconNotificationBook" )
            }
            Icon(imageVector = Icons.Default.Menu, contentDescription ="IconNotificationBook",
            modifier = Modifier.clickable{
                    setNovel(item)
                    setVisible(!visible)
            })

        }

    }
}
