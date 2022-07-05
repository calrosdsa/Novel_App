package com.example.bookmark

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bookmark.components.BottomSheetBookMark
import com.example.bookmark.components.DialogBookMark
import com.example.bookmark.pagination.pages.ReadingPage
import com.example.compose.ui.rememberStateWithLifecycle
import com.example.domain.util.NovelOrder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheetBookMark(
    navController: NavController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    viewModel: BookMarkedViewModel = hiltViewModel(),
    ) {
    val state by rememberStateWithLifecycle(viewModel.state)
    val listState = rememberLazyListState()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var openDialog by remember {
        mutableStateOf(false)
    }


    state.message?.let { message ->
        LaunchedEffect(message) {
            scaffoldState.snackbarHostState.showSnackbar(message.message)
            // Notify the view model that the message has been dismissed
//            Toast.makeText(context, message.message, Toast.LENGTH_SHORT).show()
            viewModel.clearMessage(message.id)
        }
    }


    ModalBottomSheetLayout(
        sheetContent = {
            Box(
                modifier = Modifier
                    //.navigationBarsWithImePadding()
//                    .navigationBarsPadding()
                    .zIndex(2f)
                    .height(300.dp)
                    .fillMaxWidth()
                //               .background(MaterialTheme.colors.background)
            ) {
                state.filterType?.let {
                    BottomSheetBookMark(
                        item = it,
                        closeSheet = {
                            coroutineScope.launch {
                                sheetState.hide()
                            }
                        },
                        currentOption = state.option,
                        currentOrder = state.ordering ?: NovelOrder.Updated,
                        setOption = { option -> viewModel.setOption(option) },
                        setOrdering = { order -> viewModel.setOrdering(order) },
                    )
                }
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = MaterialTheme.colors.surface,
        scrimColor = Color.Black.copy(alpha = 0.55f),
        sheetShape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
    ) {

        state.currentItem?.let {
            DialogBookMark(
                visible = openDialog,
                setVisible = { bool -> openDialog = bool },
                item = it,
                setOption = { id, option -> viewModel.setAction(id, option) },
                removeNovel = { id, title -> viewModel.removeNovel(id, title) }
            )
        }

        state.followings?.let {
            ReadingPage(
                visible = openDialog,
                loading = state.loading,
                setVisible = { bool -> openDialog = bool },
                refresh = { viewModel.refresh() },
                setFilterOption = { filter -> viewModel.setFIlter(filter) },
                items = it,
                setItem = { itemC -> viewModel.setCurrentItem(itemC) },
                navController = navController,
                onClick = {
                    coroutineScope.launch {
                        sheetState.show()
                    }
                },
                lazyListState = listState,
                token = viewModel.token,
            )
        }
    }
}

