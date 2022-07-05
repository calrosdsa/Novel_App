package com.example.bookmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.ui.SearchTopBar
import com.example.novels.MainDestination


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookMarkScreen(
    navController: NavController,
 //    modifier: Modifier,
    state:ScaffoldState,
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SearchTopBar(
                state = state,
                navController = navController,
                coroutineScope = coroutineScope
            )
        },
        scaffoldState = state
    ) {
        Column(Modifier.padding(it)) {
            ModalBottomSheetBookMark(
                navController = navController,
                scaffoldState = state,
                coroutineScope = coroutineScope
            )
        }
    }
}
