package com.example.domain.resources

import android.os.Build
import android.text.format.DateUtils
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.data.MediumDate
import com.example.data.MediumDateTime
import com.example.data.ShortDate
import com.example.data.ShortTime
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.Temporal
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NovelDateFormatter @Inject constructor(
//    @ShortTime private val shortTimeFormatter: DateTimeFormatter,
//    @ShortDate private val shortDateFormatter: DateTimeFormatter,
//    @MediumDate private val mediumDateFormatter: DateTimeFormatter,
//    @MediumDateTime private val mediumDateTimeFormatter: DateTimeFormatter
) {
//    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
@RequiresApi(Build.VERSION_CODES.O)
fun getDateTime(date:String): CharSequence? {
    Log.d("DATESUB" , date.subSequence(5,7).toString())
    Log.d("DATESUB" , date.subSequence(8,10).toString())

    val y = date.take(4)
    val m = date.subSequence(5,7).toString()
    val d = date.subSequence(8,10).toString()
    val timeDate = date.drop(10)
    val newDate = String.format("%s-%s-%s $timeDate",m,d,y)
    Log.d("DATESUB" , newDate)
        //val newDate = date.replace("/","-")
    //val newDate = "07-06-2022 19:02:37"
        val sdf = SimpleDateFormat("MM-dd-yyyy HH:mm:ss")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        val time:Long = sdf.parse(newDate)?.time ?: 0L;
        val now:Long = System.currentTimeMillis();
        return  DateUtils.getRelativeTimeSpanString(
            time,
            now,
        //    DateUtils.MINUTE_IN_MILLIS);
            DateUtils.MINUTE_IN_MILLIS);
}

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate(date:String): CharSequence? {

        val newDate = date.replace("/","-")
        //val newDate = "07-06-2022 19:02:37"
        val sdf = SimpleDateFormat("MM-dd-yyyy HH:mm:ss")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        val time:Long = sdf.parse(newDate)?.time ?: 0L;
        val now:Long = System.currentTimeMillis();
        return  DateUtils.getRelativeTimeSpanString(
            time,
            now,
            //    DateUtils.MINUTE_IN_MILLIS);
            DateUtils.MINUTE_IN_MILLIS);
    }
//
//    fun formatShortDate(temporalAmount: Temporal): String = shortDateFormatter.format(temporalAmount)
//
//    fun formatMediumDate(temporalAmount: Temporal): String = mediumDateFormatter.format(temporalAmount)
//
//    fun formatMediumDateTime(temporalAmount: Temporal): String = mediumDateTimeFormatter.format(temporalAmount)
//
//    fun formatShortTime(localTime: LocalTime): String = shortTimeFormatter.format(localTime)
//
//    fun formatShortRelativeTime(dateTime: OffsetDateTime): String {
//        val now = OffsetDateTime.now()
//
//        return if (dateTime.isBefore(now)) {
//            if (dateTime.year == now.year || dateTime.isAfter(now.minusDays(7))) {
//                // Within the past week
//                DateUtils.getRelativeTimeSpanString(
//                    dateTime.toInstant().toEpochMilli(),
//                    System.currentTimeMillis(),
//                    DateUtils.MINUTE_IN_MILLIS,
//                    DateUtils.FORMAT_SHOW_DATE
//                ).toString()
//            } else {
//                // More than 7 days ago
//                formatShortDate(dateTime)
//            }
//        } else {
//            if (dateTime.year == now.year || dateTime.isBefore(now.plusDays(14))) {
//                // In the near future (next 2 weeks)
//                DateUtils.getRelativeTimeSpanString(
//                    dateTime.toInstant().toEpochMilli(),
//                    System.currentTimeMillis(),
//                    DateUtils.MINUTE_IN_MILLIS,
//                    DateUtils.FORMAT_SHOW_DATE
//                ).toString()
//            } else {
//                // In the far future
//                formatShortDate(dateTime)
//            }
//        }
//    }
}
