package com.example.recommended

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.recommended.pagination.Cards
import com.example.recommended.pagination.PaginationRecommended

@Composable
fun RecommendedScreen(
    navController: NavController,

){
    Box(modifier = Modifier
        .fillMaxSize()
        ){

        PaginationRecommended(navController = navController)
    }
}