package com.example.bookmark

import com.example.domain.util.NovelOption
import com.example.domain.util.NovelOrder

sealed class NovelEvent{
    data class Order(val novelOrder: NovelOrder): NovelEvent()
    //data class Options(val option:NovelOption) :NovelEvent()
}
