package com.example.domain.resources

import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
//
//class DateFormatter () {
//  //  fun getDateTimeFormatted(minutesToAdd: Long, pattern: String): String {
//        // get current time in UTC, no millis needed
//  //      val nowInUtc = OffsetDateTime.now(ZoneOffset.UTC)
//        // add some minutes to it
//    //    val someMinutesLater = nowInUtc.plusMinutes(minutesToAdd)
//        // return the result in the given pattern
//    //    return someMinutesLater.format(
//   //         DateTimeFormatter.ofPattern(pattern)
//     //   )
//   // }
//    fun getTime(date:String): CharSequence? {
//        val newDate = date.replace("/","-")
//        val sdf = SimpleDateFormat("MM-dd-yyyy HH:mm:ss")
//        sdf.timeZone = TimeZone.getTimeZone("GMT")
//        val time:Long = sdf.parse(newDate).time;
//        val now:Long = System.currentTimeMillis();
//        return  DateUtils.getRelativeTimeSpanString(
//            time,
//            now,
//            DateUtils.MINUTE_IN_MILLIS);
//}
//    }
