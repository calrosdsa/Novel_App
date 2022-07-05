package com.example.domain.resources;

import android.text.format.DateUtils;
import com.example.data.MediumDate;
import com.example.data.MediumDateTime;
import com.example.data.ShortDate;
import com.example.data.ShortTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/domain/resources/NovelDateFormatter;", "", "shortTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "shortDateFormatter", "mediumDateFormatter", "mediumDateTimeFormatter", "(Ljava/time/format/DateTimeFormatter;Ljava/time/format/DateTimeFormatter;Ljava/time/format/DateTimeFormatter;Ljava/time/format/DateTimeFormatter;)V", "formatMediumDate", "", "temporalAmount", "Ljava/time/temporal/Temporal;", "formatMediumDateTime", "formatShortDate", "formatShortRelativeTime", "dateTime", "Ljava/time/OffsetDateTime;", "formatShortTime", "localTime", "Ljava/time/LocalTime;", "domain_debug"})
@javax.inject.Singleton()
public final class NovelDateFormatter {
    private final java.time.format.DateTimeFormatter shortTimeFormatter = null;
    private final java.time.format.DateTimeFormatter shortDateFormatter = null;
    private final java.time.format.DateTimeFormatter mediumDateFormatter = null;
    private final java.time.format.DateTimeFormatter mediumDateTimeFormatter = null;
    
    @javax.inject.Inject()
    public NovelDateFormatter(@org.jetbrains.annotations.NotNull()
    @com.example.data.ShortTime()
    java.time.format.DateTimeFormatter shortTimeFormatter, @org.jetbrains.annotations.NotNull()
    @com.example.data.ShortDate()
    java.time.format.DateTimeFormatter shortDateFormatter, @org.jetbrains.annotations.NotNull()
    @com.example.data.MediumDate()
    java.time.format.DateTimeFormatter mediumDateFormatter, @org.jetbrains.annotations.NotNull()
    @com.example.data.MediumDateTime()
    java.time.format.DateTimeFormatter mediumDateTimeFormatter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatShortDate(@org.jetbrains.annotations.NotNull()
    java.time.temporal.Temporal temporalAmount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatMediumDate(@org.jetbrains.annotations.NotNull()
    java.time.temporal.Temporal temporalAmount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatMediumDateTime(@org.jetbrains.annotations.NotNull()
    java.time.temporal.Temporal temporalAmount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatShortTime(@org.jetbrains.annotations.NotNull()
    java.time.LocalTime localTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatShortRelativeTime(@org.jetbrains.annotations.NotNull()
    java.time.OffsetDateTime dateTime) {
        return null;
    }
}