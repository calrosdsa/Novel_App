package com.example.recommended.pagination

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ButtonActionsRecommended(
    verticalState:ScrollState,
    coroutineScope: CoroutineScope,
    showFloatingButton:Boolean,
    addToBookMark:() -> Unit,
    ids:List<Int>,
    currentId:Int
){
    Column() {
        FloatingActionButton(onClick = { addToBookMark.invoke() },
            backgroundColor = Color.Blue.copy(alpha = 0.8f),
        ) {
            if(ids.contains(currentId)){
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Follow IconOutlined")
            }else{
                Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Follow IconFill.")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = showFloatingButton) {

        FloatingActionButton(onClick = {
              coroutineScope.launch {
              verticalState.animateScrollTo(0)
              }
        },
            backgroundColor = Color.DarkGray.copy(alpha = 0.8f),
        ) {
            Icon(imageVector = Icons.Default.ArrowUpward, contentDescription = "ArrowUp")
        }
        }
    }
}