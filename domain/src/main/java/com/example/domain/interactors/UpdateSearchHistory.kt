
package com.example.domain.interactors

import com.dropbox.android.external.store4.*
import com.example.data.fetch
import com.example.data.store.history_search.SearchResultStore
import com.example.domain.Interactor
import com.example.util.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@OptIn(ExperimentalStoreApi::class)
class UpdateSearchHistory @Inject constructor(
    private val searchResultStore: SearchResultStore,
    private val dispatchers: AppCoroutineDispatchers
) : Interactor<UpdateSearchHistory.Params>() {


    override suspend fun doWork(params: Params) {
        withContext(dispatchers.io){
//             searchResultStore.fetch(params.query,
 //                forceFresh = params.forceRefresh)
            searchResultStore.get("key")
    //            when(response){
      //              is StoreResponse.Data -> response.value
        //        }
      //      }
        }
    }

    data class Params(val query:String ,val forceRefresh: Boolean = false)

    override suspend fun deleteAll(params:Params) {
        withContext(dispatchers.io){
            searchResultStore.clearAll()
        }
    }
}
