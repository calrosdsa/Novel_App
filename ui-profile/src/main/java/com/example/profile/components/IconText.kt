package com.example.profile.components

import androidx.compose.ui.graphics.Color
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.settings.AppTheme


@Composable
fun IconTextRow(
    modifier: Modifier = Modifier,
    IconValue:ImageVector,
    title:String,
    description: String = "",
){

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = IconValue,
            contentDescription =title,
            modifier = Modifier.size(27.dp,27.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column() {
        Text(text = title,
            style = MaterialTheme.typography.h6.copy(
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal
            ),
            color = MaterialTheme.colors.onSecondary)
            if(description.length > 2){
            Text(text = description,
                style = MaterialTheme.typography.caption.copy(
                    fontWeight = FontWeight.Normal
                ),
                color = MaterialTheme.colors.onSecondary.copy(
                    alpha = 0.6f
                ))
            }
        }
    }
    Spacer(modifier = Modifier.height(25.dp))
}


@Composable
fun IconTextWithToggle(
    IconValue:ImageVector,
    title:String,
    description: String = "",
    isChecked:Boolean,
    onClick: (Boolean,AppTheme)->Unit
){


    Layout(
        modifier = Modifier.fillMaxWidth().height(28.dp),
        content = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = IconValue,
                contentDescription =title,
                modifier = Modifier.size(27.dp,27.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column() {
                Text(text = title,
                    style = MaterialTheme.typography.h6.copy(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    color = MaterialTheme.colors.onSecondary)
                if(description.length > 2){
                    Text(text = description,
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.Normal
                        ),
                        color = MaterialTheme.colors.onSecondary.copy(
                            alpha = 0.6f
                        ))
                }
            }
        }
        Switch(
            checked = isChecked,
            onCheckedChange = {onClick(it , if(isChecked) AppTheme.MODE_DAY else AppTheme.MODE_NIGHT)},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF81A9B3),
                uncheckedThumbColor = Color(0xFF4A6572)
            )
        )
    }){
        measures, constrains ->

        val firstItemWidth = (constrains.maxWidth / 3) *2.3

        val item1 = measures[0].measure(Constraints.fixedWidth(firstItemWidth.toInt()))
        val item2 = measures[1].measure(Constraints.fixedWidth(constrains.maxWidth / 3))

        layout(
            width = constrains.maxWidth,
            height = constrains.maxHeight
        ){
            item1.placeRelative(
                // image is placed to end of text i.e. will overflow to the end (but be clipped)
                x = 0 ,
                y = 0 // centered
            )
            item2.placeRelative(
                x= firstItemWidth.toInt(),
                y = -constrains.maxHeight/3
            )
        }
    }

    Spacer(modifier = Modifier.height(25.dp))
}

@Composable
fun SwtichBottomComponent(
    isChecked: Boolean,
    onClick: () -> Unit
){
    IconToggleButton(
        checked = isChecked,
        onCheckedChange = { onClick() }
    ) {
        val transition = updateTransition(isChecked, label = "Checked indicator")

        val tint by transition.animateColor(
            label = "Tint"
        ) { isChecked ->
            if (isChecked) MaterialTheme.colors.secondary else MaterialTheme.colors.primary
        }

        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 250
                        30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                        35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                        40.dp at 75 // ms
                        35.dp at 150 // ms
                    }
                } else {
                    spring(stiffness = Spring.StiffnessVeryLow)
                }
            },
            label = "Size"
        ) { 28.dp
        }

        Icon(
            imageVector = if (isChecked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(size)
        )
    }

}


