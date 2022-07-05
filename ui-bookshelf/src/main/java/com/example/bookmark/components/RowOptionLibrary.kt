package com.example.bookmark.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RowOptionLibrary(
    title:String,
    IconRow : ImageVector,
    setOption: ()-> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant.copy(alpha = 0.3f))
            .padding(5.dp)
            .clickable { setOption() }
        ,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = title)
        Icon(imageVector = IconRow, contentDescription = title)
    }
    Spacer(modifier = Modifier.height(10.dp))
}