package com.example.screen.componnets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

@Composable
fun IconImagePlace(
    modifier: Modifier = Modifier,
    novelCover:String,
    count: String,
    cover:String,
    //label: @Composable ()-> Unit

){
    Layout(
        modifier = modifier,
        content = {
            NovelCover(imageUrl = novelCover, contentDescription = novelCover)
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.small)
                    .background(color = MaterialTheme.colors.background)
                    .padding(horizontal = 2.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    tint= Color.LightGray,
                    imageVector =Icons.Default.Star, contentDescription =cover )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = count,style = MaterialTheme.typography.subtitle2)
            }
        }
    ){
        measurables,constraints ->
        val imageWidht = constraints.maxWidth
        val imageHeight = constraints.maxHeight


        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidht,imageHeight))
        val iconPlaceable = measurables[1].measure(Constraints.fixedWidth(constraints.maxWidth/2))

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ){
            imagePlaceable.placeRelative(
                // image is placed to end of text i.e. will overflow to the end (but be clipped)
                x = 0 ,
                y = 0 // centered
            )
            iconPlaceable.placeRelative(
                x= 0 ,
                y = (imageHeight * 0.84f).toInt()
            )

        }
    }
}