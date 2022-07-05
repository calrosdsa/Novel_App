package com.example.data.local.entities

import androidx.room.*


@Entity(
    tableName = "history_entries",
    indices = [
        Index(value = ["novel_id"], unique = true)
    ]
)
data class HistoryNovelEntry(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    @ColumnInfo(name = "novel_id") override val novelId: Long,
    @ColumnInfo(name = "page") override val page: Int = 0,
    @ColumnInfo(name = "page_order") val pageOrder: Int
    //@ColumnInfo(name = "last_watched") val lastWatched: OffsetDateTime
) : PaginatedEntry
