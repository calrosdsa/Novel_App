package com.example.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.UiMessageManager
import com.example.data.local.entities.HistorySearchEntity
import com.example.data.repository.NovelRepositoryDb
import com.example.domain.interactors.UpdateSearchHistory
import com.example.domain.observers.ObserverSearchHistory
import com.example.domain.observers.ObserverSearchResults
import com.example.domain.useCases.GetSearchNovels
import com.example.domain.util.ObservableLoadingCounter
import com.example.domain.util.collectStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchNovels: GetSearchNovels,
    private val novelRepositoryDb: NovelRepositoryDb,
    private val observerSearchHistory: ObserverSearchHistory,
    private val updateSearchHistory: UpdateSearchHistory,
    private val observerSearchResults: ObserverSearchResults
  //  private val logger: Logger,

    ):ViewModel(){
    private val uiMessageManager = UiMessageManager()
    private val recommendedLoadingState = ObservableLoadingCounter()
    private val loadingState = ObservableLoadingCounter()
    private val searchQuery = MutableStateFlow("")


    var searchHistory by mutableStateOf(SearchHistoryState())

    val state:StateFlow<SearchViewState> = combine(
        observerSearchResults.flow,
        observerSearchHistory.flow,
        searchQuery,
        ){ results,history,query ->
        SearchViewState(
            searchResults = results,
            searchHistory = history,
            query = query
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
         initialValue = SearchViewState()
    )
    init {
        refresh()
        observerSearchHistory(ObserverSearchHistory.Params(10))
        observerSearchResults(ObserverSearchResults.Params(""))
        viewModelScope.launch {
            searchQuery.debounce(300)
                .onEach { query ->
                    val job = launch {
    //                    loadingState.addLoader()
                        observerSearchResults(ObserverSearchResults.Params(query))
                    }
      //              job.invokeOnCompletion { loadingState.removeLoader() }
                    job.join()
                }
                .catch {
             //`           throwable -> uiMessageManager.emitMessage(UiMessage(throwable))
                }
                .collect()
        }
    }

    fun search(searchTerm: String) {
        searchQuery.value = searchTerm
    }


    fun getSearch(){
        observerSearchHistory.flow.onEach {
             searchHistory = searchHistory.copy(history = it)
        }.launchIn(viewModelScope)
    }

    fun refresh(query:String="a",refresh:Boolean = true){
        viewModelScope.launch {
        updateSearchHistory(
            UpdateSearchHistory.Params(query, refresh)
        )
        .collectStatus(recommendedLoadingState,uiMessageManager)
    }
    }


   fun insertSearch (resultSearch: HistorySearchEntity){
       viewModelScope.launch {
        novelRepositoryDb.insetHistorySearch(resultSearch.copy(
            isInHistory = true,
            timestamp = System.currentTimeMillis()
        ))
       }
    }

    private fun getSearchHistories(){

    }

    fun deleteAll(allSearch:List<HistorySearchEntity>){
        viewModelScope.launch {
        novelRepositoryDb.deleteAllSearch(allSearch)
        }
    }


     fun getSearchResults(){
     //        getSearchNovels().onEach {result->
  //         state = when(result){
    //            is Resource.Loading -> SearchState(loading = true)
      //         is Resource.Success -> SearchState(searchResults = result.data)
        //       is Resource.Error -> SearchState(error = result.message?:"An expected error ocurred")
    //    }
   //     }.launchIn(viewModelScope)
    }
}