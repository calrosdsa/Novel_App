package com.example.data.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.example.data.local.entities.Request
import com.google.gson.Gson
import org.threeten.bp.Instant
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.io.ByteArrayOutputStream

class Converters{
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    private val requestValues by lazy(LazyThreadSafetyMode.NONE) { Request.values() }


    @TypeConverter
//    @JvmStatic
    fun toOffsetDateTime(value: String?) = value?.let { formatter.parse(value, OffsetDateTime::from) }

    @TypeConverter
//    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? = date?.format(formatter)

    @TypeConverter
    fun toInstant(value: Long?) = value?.let { Instant.ofEpochMilli(it) }

    @TypeConverter
    fun fromInstant(date: Instant?) = date?.toEpochMilli()

    @TypeConverter
    fun fromRequest(value: Request) = value.tag

    @TypeConverter
    fun toRequest(value: String) = requestValues.firstOrNull { it.tag == value }


    @TypeConverter
    fun listToJsonString(value: List<Int>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<Int>::class.java).toList()

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}
