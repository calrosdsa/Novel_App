package com.example.compose.ui

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.example.api.UiMessage

fun CombinedLoadStates.appendErrorOrNull(): UiMessage? {
    return (append.takeIf { it is LoadState.Error } as? LoadState.Error)
        ?.let { UiMessage(it.error) }
}

fun CombinedLoadStates.prependErrorOrNull(): UiMessage? {
    return (prepend.takeIf { it is LoadState.Error } as? LoadState.Error)
        ?.let { UiMessage(it.error) }
}

fun CombinedLoadStates.refreshErrorOrNull(): UiMessage? {
    return (refresh.takeIf { it is LoadState.Error } as? LoadState.Error)
        ?.let { UiMessage(it.error) }
}


