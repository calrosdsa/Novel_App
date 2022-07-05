package com.example.domain.useCases;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class GetLatestChapters_Factory implements Factory<GetLatestChapters> {
  @Override
  public GetLatestChapters get() {
    return newInstance();
  }

  public static GetLatestChapters_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GetLatestChapters newInstance() {
    return new GetLatestChapters();
  }

  private static final class InstanceHolder {
    private static final GetLatestChapters_Factory INSTANCE = new GetLatestChapters_Factory();
  }
}
