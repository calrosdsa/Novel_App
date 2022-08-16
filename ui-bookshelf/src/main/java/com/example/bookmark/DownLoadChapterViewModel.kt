package com.example.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.domain.observers.ObserverChapter
import com.example.domain.observers.ObserverChapters
import com.example.domain.util.ObservableLoadingCounter
import com.example.extensions.combine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DownLoadChapterViewModel @Inject constructor(
    private val observerChapter: ObserverChapters
):ViewModel() {
    private val loadingCounter = ObservableLoadingCounter()
    private val messageManager = UiMessageManager()


    val state: StateFlow<DownLoadChapterState> = combine(
        loadingCounter.observable,
        messageManager.message,
        observerChapter.flow,
    ){loading,message,chapters->
        DownLoadChapterState(
            chapters = chapters,
            loading = loading,
            message = message
        )
            }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DownLoadChapterState(),

            )

    init {
        observerChapter(ObserverChapters.Params(2))
    }
}