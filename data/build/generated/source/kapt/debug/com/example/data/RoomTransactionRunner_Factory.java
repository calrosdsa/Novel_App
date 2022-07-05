package com.example.data;

import com.example.data.local.NovelDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class RoomTransactionRunner_Factory implements Factory<RoomTransactionRunner> {
  private final Provider<NovelDatabase> dbProvider;

  public RoomTransactionRunner_Factory(Provider<NovelDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public RoomTransactionRunner get() {
    return newInstance(dbProvider.get());
  }

  public static RoomTransactionRunner_Factory create(Provider<NovelDatabase> dbProvider) {
    return new RoomTransactionRunner_Factory(dbProvider);
  }

  public static RoomTransactionRunner newInstance(NovelDatabase db) {
    return new RoomTransactionRunner(db);
  }
}
