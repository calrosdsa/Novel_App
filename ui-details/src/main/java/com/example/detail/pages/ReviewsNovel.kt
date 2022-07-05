package com.example.detail.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.data.dto.reviews.Review
import com.example.detail.NovelDetailViewModel

@Composable
fun ReviewsPage(
    viewModel: NovelDetailViewModel = hiltViewModel()
){
    val state = viewModel.reviews.value
          state.reviews?.reviews?.map {
     Column() {
      Box(modifier = Modifier.fillMaxSize()) {

              Column() {
              ReviewItem(review = it)
              }
          }

     }
    }

}


@Composable
fun ReviewItem(review: Review){
    Box() {
        Row() {
            Image(
                painter = rememberAsyncImagePainter(
                    model = review.avatar
                ),
                contentDescription = review.avatar,
                //contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(height = 60.dp, width = 60.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
            )
            Column(modifier = Modifier.padding(start = 30.dp)) {
                Text(text = review.user)
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = review.review, style = MaterialTheme.typography.body2)
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
                    Text(text = "${review.like}")
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(19.dp),
                        imageVector = Icons.Default.Message, contentDescription = "Icon ThumbUp",
                        tint = MaterialTheme.colors.primary
                    )
                    Text(text = "${4}")
                }
            }
        }
//    Spacer(modifier = Modifier.height(18.dp))
        Divider(color = MaterialTheme.colors.onPrimary)
        Spacer(modifier = Modifier.height(18.dp))

    }
}