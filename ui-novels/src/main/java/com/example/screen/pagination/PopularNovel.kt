package com.example.screen.pagination

import android.graphics.fonts.FontStyle
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.compose.components.RatingBar
import com.example.compose.components.VerticalGrid
import com.example.data.dto.novels.Popular

@Composable
internal fun PopularNovel(
    item:Popular,
    navToNovel:(String)->Unit
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(top = 5.dp, bottom = 5.dp)
        .padding(horizontal = 10.dp)
        .height(60.dp),
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
                    .width(45.dp)
                    .height(60.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Box(modifier = Modifier.fillMaxWidth(0.8f)) {

            Column() {
                Text(text = item.title, style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.clickable {
                        navToNovel(item.slug)
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

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Flag,
                            contentDescription = "NovelViewsHome",
                            tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                            modifier = Modifier
                                .size(19.dp)
                                .padding(1.dp)
                        )
                        Text(
                            text = " ${item.novel_views} (Monthly", style = MaterialTheme.typography.caption.copy(
                                fontWeight = FontWeight.Light
                            ),
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Bookmark,
                            contentDescription = "BookMarkHome",
                            tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                            modifier = Modifier
                                .size(19.dp)
                                .padding(1.dp)

                        )
                        Text(
                            text = " ${item.markeds}",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                        )
                    }

                }
        }
    }
}