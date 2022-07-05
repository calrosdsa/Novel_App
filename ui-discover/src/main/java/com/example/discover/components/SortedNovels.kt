package com.example.discover.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.discover.sortedOptions

@Composable
internal fun SortedBy(
    setOrdering: (String) -> Unit,
    current:String
){



        Row() {
    sortedOptions.map {
        SortedOptionsBox(
            modifier = Modifier.clickable { setOrdering(it.ordering) },
            ordering = it.ordering, currentOrdering = current, title = it.title
        )
        Spacer(modifier = Modifier.width(10.dp))

    }
        }

    }


@Composable
internal fun SortedOptionsBox(
    modifier: Modifier,
    ordering:String,
    currentOrdering:String,
    title:String
){
    Box(modifier = modifier
        .clip(MaterialTheme.shapes.small)
        .background(
            if (ordering == currentOrdering) MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(
                alpha = 0.65f
            )
        )
        .padding(8.dp)
    ){
        Text(text = title, style = MaterialTheme.typography.caption)
    }
}
