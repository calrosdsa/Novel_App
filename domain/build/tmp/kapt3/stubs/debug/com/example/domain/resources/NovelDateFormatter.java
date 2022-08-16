package com.example.domain.resources;

import android.os.Build;
import android.text.format.DateUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.example.data.MediumDate;
import com.example.data.MediumDateTime;
import com.example.data.ShortDate;
import com.example.data.ShortTime;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/domain/resources/NovelDateFormatter;", "", "()V", "getDate", "", "date", "", "getDateTime", "domain_debug"})
@javax.inject.Singleton()
public final class NovelDateFormatter {
    
    @javax.inject.Inject()
    public NovelDateFormatter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final java.lang.CharSequence getDateTime(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final java.lang.CharSequence getDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
}