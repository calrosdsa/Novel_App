package com.example.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookOnline
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.data.local.entities.HistorySearchEntity
import com.example.novels.MainDestination

@Composable
fun ResultSearchRow(
    resultSearch: HistorySearchEntity,
    modifier: Modifier = Modifier,
){
    Row(modifier = modifier.fillMaxWidth()
        .padding(horizontal = 15.dp, vertical = 8.dp)
    ) {
        when(resultSearch.label){
            "novel" -> Icon(imageVector = Icons.Default.BookOnline, contentDescription ="BookLabel")
            "tag" -> Icon(imageVector = Icons.Outlined.Tag, contentDescription = "TagOption")
            "category" -> Icon(imageVector = Icons.Outlined.Widgets, contentDescription = "Category Option")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = resultSearch.title,
            maxLines = 1
        )
    }
    Divider()
}