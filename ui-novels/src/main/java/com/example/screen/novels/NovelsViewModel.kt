package com.example.screen.novels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.resources.Resource
import com.example.domain.useCases.GetNovels
import com.example.novels.novels.NovelsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject
@HiltViewModel
class NovelsViewModel @Inject constructor(
    private val getNovelUseCase: GetNovels,
):ViewModel() {
    private val _state = mutableStateOf(NovelsState())
    val state: State<NovelsState> = _state

    init {
            getNovels()
    }

    fun getNovels(){
        getNovelUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    delay(300)
                    _state.value = NovelsState(novels = result.data)
                }
                is Resource.Loading->{
                    _state.value = NovelsState(is_loading = true)
                }
                is Resource.Error->{
                    _state.value = NovelsState(error = result.message?:"An expected error ocurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}