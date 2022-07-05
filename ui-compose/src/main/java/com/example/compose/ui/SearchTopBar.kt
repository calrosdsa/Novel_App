package com.example.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novels.MainDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SearchTopBar(
    state: ScaffoldState,
    navController: NavController,
    coroutineScope: CoroutineScope
){

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(0.75f)
                .height(37.dp)
                .background(MaterialTheme.colors.primaryVariant)
                .clickable {
                    navController.navigate(MainDestination.SEARCH_SCREEN)
                }
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "SearchIconBookMark",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
            )
        }
        IconButton(
            onClick = {
                coroutineScope.launch {
                    state.drawerState.open()
                    //delay(50)
                }
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {

            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "SearchIconBookMark",
            )
        }
        Divider(
            color = MaterialTheme.colors.primaryVariant, modifier = Modifier.align(
                Alignment.BottomEnd
            )
        )
    }
}