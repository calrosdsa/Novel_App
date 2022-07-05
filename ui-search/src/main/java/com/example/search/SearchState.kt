package com.example.search

import com.example.data.dto.searchNovel.ResultSearch
import com.example.data.local.entities.HistorySearchEntity

data class SearchState(
    val searchResults:List<ResultSearch>? = null,
    val loading:Boolean = false,
    val error:String = "",
)

data class SearchHistoryState(
    val history:List<HistorySearchEntity>?= null,
)


data class SearchViewState(
    val searchResults: List<HistorySearchEntity> = emptyList(),
    val searchHistory: List<HistorySearchEntity> = emptyList(),
    val query: String = "",
    //val refreshing: Boolean = false,
  //  val message: UiMessage? = null,
) {
    companion object {
        val Empty = SearchViewState()
    }
}
