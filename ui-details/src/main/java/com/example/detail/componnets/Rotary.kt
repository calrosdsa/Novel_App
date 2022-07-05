package com.example.detail.componnets

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.rotary.onPreRotaryScrollEvent
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Themee(){

MaterialTheme(colors = darkColors()) {
    val rowScrollState = rememberScrollState()
    val columnScrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val focusRequester = remember { FocusRequester() }
    var interceptScroll by remember { mutableStateOf(false) }
    Column(
        Modifier
            .onPreRotaryScrollEvent {
                // You can intercept an event before it is sent to the child.
                if (interceptScroll) {
                    coroutineScope.launch {
                        rowScrollState.scrollBy(it.horizontalScrollPixels)
                    }
                    // return true to consume this event.
                    true
                } else {
                    // return false to ignore this event and continue propagation to the child.
                    false
                }
            }
            .onRotaryScrollEvent {
                // If the child does not use the scroll, we get notified here.
                coroutineScope.launch {
                    rowScrollState.scrollBy(it.horizontalScrollPixels)
                }
                true
            }
    ) {
        Row(
            modifier = Modifier.align(CenterHorizontally),
            verticalAlignment = CenterVertically
        ) {
            Text(
                modifier = Modifier.width(70.dp),
                text = if (interceptScroll) "Row" else "Column",
                style = TextStyle(color = White)
            )
            Switch(
                checked = interceptScroll,
                onCheckedChange = { interceptScroll = it },
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rowScrollState)
        ) {
            repeat(100) {
                Text(
                    text = "row item $it ",
                    modifier = Modifier.align(CenterVertically),
                    color = White,
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(columnScrollState)
                .onRotaryScrollEvent {
                    coroutineScope.launch {
                        columnScrollState.scrollBy(it.verticalScrollPixels)
                    }
                    true
                }
                .focusRequester(focusRequester)
                .focusable(),
        ) {
            repeat(100) {
                Text(
                    text = "column item $it",
                    modifier = Modifier.align(CenterHorizontally),
                    color = White,
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}
}
