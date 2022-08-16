package com.example.screen.pagination

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.data.dto.novels.Chapter

@Composable
internal fun LastChapters(
    item: Chapter,
    navToNovel:(String)->Unit,
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(top = 5.dp, bottom = 5.dp)
//        .padding(10.dp)
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .fillMaxWidth(0.18f)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model =  item.novel_cover),
                contentDescription = "Cover BookMark",
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.small)
                    .width(50.dp)
                    .height(75.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(modifier = Modifier.fillMaxWidth(0.8f)) {

            Column() {
                Text(text = item.novel_title, style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.clickable {
                        navToNovel(item.novel_slug)
                    }
                )

//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    RatingBar(
//                        rating = item.average.toFloat(),
//                        modifier = Modifier.height(14.5.dp),
//                        color = Color(0xFFFFD700)
//                    )
//                    Spacer(modifier = Modifier.width(6.dp))
//                    Text(text = "${item.average.toFloat()} (${item.reviews})",
//                        style = MaterialTheme.typography.caption,
//                        color = MaterialTheme.colors.onPrimary,
//                    )
//                }


                    Text(
                        text = item.title, style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.primary,
                        maxLines = 1,
                    )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Update,
                        contentDescription = "BookMarkHome",
                        tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        modifier = Modifier
                            .size(19.dp)
                            .padding(1.dp)

                    )
                    Text(
                        text = "Updated",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                }

            }
        }
    }

}