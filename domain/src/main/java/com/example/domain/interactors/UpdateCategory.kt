package com.example.domain.interactors

import com.dropbox.android.external.store4.fresh
import com.dropbox.android.external.store4.get
import com.example.data.store.category.CategoryStore
import com.example.domain.Interactor
import javax.inject.Inject

class UpdateCategory @Inject constructor(
    private val categoryStore: CategoryStore
):Interactor<UpdateCategory.Params>(){
    override suspend fun doWork(params: Params) {
        categoryStore.get(Unit)
    }
    override suspend fun deleteAll(params: Params) {
        TODO("Not yet implemented")
    }
    data class Params(
        val it:Unit
    )
}
