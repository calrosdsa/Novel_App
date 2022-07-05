package com.example.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.example.novels.MainDestination
import com.example.search.components.AdvancedSearchBar
import com.example.search.components.HistorySearchComponent
import com.example.search.components.ResultSearchRow
import com.example.search.components.TopSearchComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel= hiltViewModel()
) {
    //  val stateSearch by rememberStateWithLifecycle(stateFlow = viewModel.stateSearch)
    val state by rememberStateWithLifecycle(viewModel.state)

    var value by remember {
        mutableStateOf(TextFieldValue(state.query))
    }
    var deleteAlert by remember {
        mutableStateOf(false)
    }


    Column {

        TopSearchComponent(
            value = value.text, onChangeValue = {
                value = it
                viewModel.search(it.text)
            },
            navBack = { navController.popBackStack() }
        )
        if (value.text.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Column() {
                    AdvancedSearchBar()
                    state.searchHistory.let { history ->
                        if (history.isNotEmpty()) {
                            HistorySearchComponent(
                                history = history,
                                deleteAll = { viewModel.deleteAll(it) },
                                deleteAlert = deleteAlert,
                                activeAlert = { deleteAlert = it }
                            )
                        }
                    }
                }
            }
        } else {
            state.searchResults.map { result ->
                ResultSearchRow(
                    resultSearch = result,
                    modifier = Modifier.clickable {
                        viewModel.insertSearch(result)
                        navController.navigate(MainDestination.NOVEL_DETAIL + "/${result.slug}")
                    },
                )
            }
            Button(onClick = {
                navController.navigate(MainDestination.HISTORY_SEARCH)
            }) {
            }
        }
    }
}





@Composable
fun <T> rememberStateWithLifecycle(
    stateFlow: StateFlow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> {
    val initialValue = remember(stateFlow) { stateFlow.value }
    return produceState(
        key1 = stateFlow, key2 = lifecycle, key3 = minActiveState,
        initialValue = initialValue
    ) {
        lifecycle.repeatOnLifecycle(minActiveState) {
            stateFlow.collect {
                this@produceState.value = it
            }
        }
    }
}
