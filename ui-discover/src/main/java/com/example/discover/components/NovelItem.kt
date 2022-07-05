package com.example.discover.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Update
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.compose.components.RatingBar
import com.example.compose.components.VerticalGrid
import com.example.data.dto.browse.Novel

@Composable
internal fun NovelItem(
    item:Novel,
    navToNovel:(String)->Unit
){
    Row(modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp)
        .clickable {
                   navToNovel(item.slug)
        },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier
                .fillMaxWidth(0.18f)
                ) {
            Image(
                painter = rememberAsyncImagePainter(model =  "https://res.cloudinary.com/farav/image/upload/v1/${item.cover}"),
                contentDescription = "Cover BookMark",
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
                Text(text = item.title, style = MaterialTheme.typography.h6.copy(
                    fontSize = 17.sp
                ),
                    maxLines = 1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.clickable {
                        //navToNovel(item.slug)
                    }
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RatingBar(
                        rating = item.average.toFloat(),
                        modifier = Modifier.height(14.5.dp),
                        color = Color(0xFFF9AA33)

                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "${item.average.toFloat()} (${item.reviews})",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary,
                    )
                }

                VerticalGrid() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Outlined.Flag, contentDescription = "RankItemDiscover",
                        tint =  MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(1.dp)
                    )
                        Text(text = "Rank ${item.rank}", style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.LibraryBooks,
                        contentDescription = "CharptersDiscover",
                        tint =  MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(1.dp)

                    )
                        Text(text = "${item.chapters} Chapters", style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Outlined.Comment, contentDescription = "RankItemDiscover",
                            tint =  MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(1.dp)

                        )
                        Text(text = "${item.comments} Com.", style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Update,
                            tint =  MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                            contentDescription = "CharptersDiscover",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(1.dp)
                        )
                        Text(text = "${item.chapters} Chapters", style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),)
                    }
                }
                Row() {
                    Text(text ="Status: ", style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),)
                    Text(text = item.status_name,
                        color = if(item.status_name == "Ongoing") Color.Red else Color.Green
                        , style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}
