package com.example.domain.resources;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "com.example.data.ShortTime",
    "com.example.data.ShortDate",
    "com.example.data.MediumDate",
    "com.example.data.MediumDateTime"
})
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NovelDateFormatter_Factory implements Factory<NovelDateFormatter> {
  private final Provider<DateTimeFormatter> shortTimeFormatterProvider;

  private final Provider<DateTimeFormatter> shortDateFormatterProvider;

  private final Provider<DateTimeFormatter> mediumDateFormatterProvider;

  private final Provider<DateTimeFormatter> mediumDateTimeFormatterProvider;

  public NovelDateFormatter_Factory(Provider<DateTimeFormatter> shortTimeFormatterProvider,
      Provider<DateTimeFormatter> shortDateFormatterProvider,
      Provider<DateTimeFormatter> mediumDateFormatterProvider,
      Provider<DateTimeFormatter> mediumDateTimeFormatterProvider) {
    this.shortTimeFormatterProvider = shortTimeFormatterProvider;
    this.shortDateFormatterProvider = shortDateFormatterProvider;
    this.mediumDateFormatterProvider = mediumDateFormatterProvider;
    this.mediumDateTimeFormatterProvider = mediumDateTimeFormatterProvider;
  }

  @Override
  public NovelDateFormatter get() {
    return newInstance(shortTimeFormatterProvider.get(), shortDateFormatterProvider.get(), mediumDateFormatterProvider.get(), mediumDateTimeFormatterProvider.get());
  }

  public static NovelDateFormatter_Factory create(
      Provider<DateTimeFormatter> shortTimeFormatterProvider,
      Provider<DateTimeFormatter> shortDateFormatterProvider,
      Provider<DateTimeFormatter> mediumDateFormatterProvider,
      Provider<DateTimeFormatter> mediumDateTimeFormatterProvider) {
    return new NovelDateFormatter_Factory(shortTimeFormatterProvider, shortDateFormatterProvider, mediumDateFormatterProvider, mediumDateTimeFormatterProvider);
  }

  public static NovelDateFormatter newInstance(DateTimeFormatter shortTimeFormatter,
      DateTimeFormatter shortDateFormatter, DateTimeFormatter mediumDateFormatter,
      DateTimeFormatter mediumDateTimeFormatter) {
    return new NovelDateFormatter(shortTimeFormatter, shortDateFormatter, mediumDateFormatter, mediumDateTimeFormatter);
  }
}
