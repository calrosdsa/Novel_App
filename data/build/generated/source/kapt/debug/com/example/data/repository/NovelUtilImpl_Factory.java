package com.example.data.repository;

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
public final class NovelUtilImpl_Factory implements Factory<NovelUtilImpl> {
  @Override
  public NovelUtilImpl get() {
    return newInstance();
  }

  public static NovelUtilImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NovelUtilImpl newInstance() {
    return new NovelUtilImpl();
  }

  private static final class InstanceHolder {
    private static final NovelUtilImpl_Factory INSTANCE = new NovelUtilImpl_Factory();
  }
}
