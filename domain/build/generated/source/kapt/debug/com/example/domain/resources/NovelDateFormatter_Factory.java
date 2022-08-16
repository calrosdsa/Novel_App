package com.example.domain.resources;

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
public final class NovelDateFormatter_Factory implements Factory<NovelDateFormatter> {
  @Override
  public NovelDateFormatter get() {
    return newInstance();
  }

  public static NovelDateFormatter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NovelDateFormatter newInstance() {
    return new NovelDateFormatter();
  }

  private static final class InstanceHolder {
    private static final NovelDateFormatter_Factory INSTANCE = new NovelDateFormatter_Factory();
  }
}
