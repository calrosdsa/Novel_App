package com.example.data.local.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime


@Entity(
    tableName = "following_novels",
)
data class FollowingEntity(
    @PrimaryKey(autoGenerate = true) val id:Int? = null,
    val added: String?=null,
    val chapters: Int=10,
    val cover: Bitmap?=null,
    val options: List<Int> = listOf(0),
    val progress: Int = 0,
    val slug: String = "",
    val title: String = "",
    val updated: String= ""
)