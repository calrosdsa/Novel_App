package com.example.screen.pagination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.screen.latestChapters.LatestChaptersScreen


sealed class TabItem(
    val index:Int,
    val title:String,
    val Screen: @Composable ()->Unit
) {
    object Home : TabItem(0, "Details", {
        //NovelPage()
    })
    object Contacts : TabItem(1,"Chapters",{
        NewNovels()
    })
    object Settings : TabItem(2,  "Reviews",{
        LatestChaptersScreen()
    })

}

@Composable
fun NewNovels(){
    LazyColumn(modifier = Modifier
        .fillMaxSize(),
    state = rememberLazyListState()) {
        items(60) {
            Text(text = "Hello")
        }
    }
}