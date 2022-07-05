package com.example.screen.componnets

import android.content.Intent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val shape = RoundedCornerShape(7.dp)


@Composable
fun novelGrid(
    novelTitle: String,
    novelCover:String,
//    novelSlug:String,
 //   novelSlug:String,
    fontSize: TextUnit = 12.sp,
    modifier: Modifier = Modifier,
  //  onNovelClick:(String) -> Unit
    ){

    Layout(
        modifier = modifier
            .aspectRatio(0.55f)
            .padding(6.dp)
            .clip(shape = shape )
  //          .clickable { onNovelClick(novelSlug) },
                ,
        content = {
    NovelCover(
        imageUrl = novelCover,
        contentDescription = null,
        modifier = Modifier.fillMaxSize().clip(
        shape = shape))
            Text(text = novelTitle,
                modifier=Modifier.padding(top = 4.dp),
                style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,

            ),
                color = MaterialTheme.colors.onSecondary,
                lineHeight = 16.sp,
                maxLines = 2
                )

    }){
      measurables,constraints ->


        // Image is sized to the larger of height of item, or a minimum value
        // i.e. may appear larger than item (but clipped to the item bounds)
        val imageSize = (constraints.maxHeight * 0.75f).toInt()
        val imageSizeW = constraints.maxWidth
        val textWidth = constraints.maxWidth

        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageSizeW,imageSize))
        val textPlaceable = measurables[1].measure(Constraints.fixedWidth(textWidth))

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ) {

            imagePlaceable.placeRelative(
                // image is placed to end of text i.e. will overflow to the end (but be clipped)
                x = 0 ,
                y = 0 // centered
            )
            textPlaceable.placeRelative(
                x= 0 ,
                y = imageSize,
            )
        }
}


}
