package com.example.screen.componnets

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun NovelCover(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    //elevation: Dp = 0.dp
){

        Image(
            painter =rememberAsyncImagePainter(
                model = "https://res.cloudinary.com/farav/image/upload/v1/${imageUrl}"),
            contentDescription = contentDescription,
            modifier = modifier.clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
        )
}