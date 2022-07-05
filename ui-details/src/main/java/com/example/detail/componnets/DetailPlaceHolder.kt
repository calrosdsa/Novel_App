package com.example.detail.componnets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.components.RatingBar
import com.google.accompanist.flowlayout.FlowRow

val roundedItem = RoundedCornerShape(15.dp)


@Composable
fun DetailPlaceholder(){
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            item {

         Spacer(modifier = Modifier.height(38.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(

                    modifier = Modifier
                        .size(height = 190.dp, width = 160.dp)
                        .padding(10.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                )

                Column {
                    Spacer(modifier = Modifier
                        .size(120.dp, 25.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray))
                   Spacer(modifier = Modifier.height(10.dp))
                        RatingBar(
                            rating = 0f,
                            modifier = Modifier.height(17.5.dp)
                        )
                    Spacer(modifier = Modifier.height(20.dp))
                    FlowRow( mainAxisSpacing = 4.dp,
                    crossAxisSpacing= 4.dp) {
                           Spacer(modifier = Modifier
                               .size(60.dp, 18.dp)
                               .clip(shape = roundedItem)
                               .background(color = Color.LightGray)

                           )
                        Spacer(modifier = Modifier
                            .size(70.dp, 18.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)
                        )
                        Spacer(modifier = Modifier
                            .size(56.dp, 18.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)

                        )
                        Spacer(modifier = Modifier
                            .size(60.dp, 18.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)
                        )
                        Spacer(modifier = Modifier
                            .size(70.dp, 18.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)
                        )
                        Spacer(modifier = Modifier
                            .size(60.dp, 18.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)
                        )
                    }

                }
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray))

                    Spacer(modifier = Modifier.height(15.dp))

                    repeat(3){
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(17.dp)
                            .clip(shape = roundedItem)
                            .background(color = Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
            }

                Spacer(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(17.dp)
                    .clip(shape = roundedItem)
                    .background(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.height(15.dp))

          SpacerPlaceholder(height = 23.dp)
                Spacer(modifier = Modifier.height(10.dp))


                repeat(2){
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(17.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }

                Spacer(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(17.dp)
                    .clip(shape = roundedItem)
                    .background(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.height(15.dp))

                SpacerPlaceholder(height = 50.dp,width = 1f)
                Spacer(modifier = Modifier.height(15.dp))

                SpacerPlaceholder(height = 22.dp)

                Spacer(modifier = Modifier.height(15.dp))

                FlowRow( mainAxisSpacing = 4.dp,
                    crossAxisSpacing= 4.dp) {
                    Spacer(modifier = Modifier
                        .size(60.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)

                    )
                    Spacer(modifier = Modifier
                        .size(90.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(86.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)

                    )
                    Spacer(modifier = Modifier
                        .size(100.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(70.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(90.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(60.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(122.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier
                        .size(90.dp, 22.dp)
                        .clip(shape = roundedItem)
                        .background(color = Color.LightGray)
                    )
                }

            }
        }
    }
}


@Composable
fun SpacerPlaceholder(
    height:Dp = 17.dp,
    width:Float =  0.3f
){
    Spacer(modifier = Modifier
        .fillMaxWidth(width)
        .height(height = height)
        .clip(roundedItem)
        .background(color = Color.LightGray))
}