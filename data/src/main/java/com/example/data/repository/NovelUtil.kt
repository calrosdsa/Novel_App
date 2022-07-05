package com.example.data.repository

import android.content.Context
import android.graphics.Bitmap
import java.time.OffsetDateTime

interface NovelUtil {
    suspend fun getImageBitmap(context:Context,imageUrl:String):Bitmap
    suspend fun formatDateOffset():OffsetDateTime
}