package com.example.domain.observers

import com.example.data.local.daos.CategoryDao
import com.example.data.local.entities.CategoryEntity
import com.example.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverCategory @Inject constructor(
    private val categoryDao: CategoryDao
) : SubjectInteractor<ObserverCategory.Params, List<CategoryEntity>>() {


        override fun createObservable(params: Params): Flow<List<CategoryEntity>> {
            return categoryDao.getCategoryList()
        }

        data class Params(val count: Int = 20)
}