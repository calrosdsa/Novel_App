package com.example.recommended.pagination

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recommended.RecommendedViewModel

@Composable
fun ChapterRecommended(
    viewModel: RecommendedViewModel = hiltViewModel()
){
    val state = viewModel.chapters.value
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 5.dp)) {
    Column() {
        state.chapters?.chapters?.map {
            Text(text = it.title , style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.Light,
                fontSize = 28.sp
            ))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = it.chapter)
        }
    }




        if(state.is_loading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (state.error.isNotBlank()){
            Text(text = state.error, modifier = Modifier.align(Alignment.Center))
        }

}
}
