package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "category_table"
)
data class CategoryEntity   (
    @PrimaryKey override val id:Long = 0,
    val title:String
):NovelEntity