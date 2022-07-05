package com.example.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "history_search",
)
data class HistorySearchEntity(
//    @PrimaryKey(autoGenerate = true) val id:Int? = null,
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    val label: String,
    val slug: String,
    val title: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long? = null,
    val isInHistory:Boolean? =false,
) :NovelEntity


