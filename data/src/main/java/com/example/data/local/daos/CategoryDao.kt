package com.example.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.data.local.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow
@Dao
abstract class CategoryDao : EntityDao<CategoryEntity>() {
    
    @Query("SELECT * FROM category_table")
    abstract  fun getCategoryList():Flow<List<CategoryEntity>>

    @Query("DELETE FROM category_table")
    abstract suspend fun deleteAll()


}