package com.example.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun AdvancedSearchBar(){
    Spacer(modifier = Modifier.height(25.dp))
    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.small)
        .background(MaterialTheme.colors.surface)
        .padding(10.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
        Icon(imageVector = Icons.Default.Search, contentDescription ="AdvancedSearch" )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Advanced Search")
        }
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "ArrowSearchAdvanced")

    }
    Spacer(modifier = Modifier.height(15.dp))

}