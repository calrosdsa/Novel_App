package com.example.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HistoryDtoToHistoryEntity_Factory implements Factory<HistoryDtoToHistoryEntity> {
  @Override
  public HistoryDtoToHistoryEntity get() {
    return newInstance();
  }

  public static HistoryDtoToHistoryEntity_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HistoryDtoToHistoryEntity newInstance() {
    return new HistoryDtoToHistoryEntity();
  }

  private static final class InstanceHolder {
    private static final HistoryDtoToHistoryEntity_Factory INSTANCE = new HistoryDtoToHistoryEntity_Factory();
  }
}
