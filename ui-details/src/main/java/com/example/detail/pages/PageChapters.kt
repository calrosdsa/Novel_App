package com.example.detail.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.detail.NovelDetailViewModel


@Composable
fun ChaptersPage(viewModel: NovelDetailViewModel = hiltViewModel()){
    val state = viewModel.chapters.value
    
            state.chapters?.let{
                it.chapters.map{ chapter ->
    LazyColumn() {
        item{
        Box(modifier = Modifier.fillMaxSize()) {

                    Column() {
                        repeat(40){

                    Text(text = chapter.title,color = Color.LightGray)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                        }
                }


            Text(text =" ${it.products_count}")
            }


        }

        }
    }
}