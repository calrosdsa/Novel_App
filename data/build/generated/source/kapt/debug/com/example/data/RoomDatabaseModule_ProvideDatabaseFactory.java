package com.example.data;

import android.content.Context;
import com.example.data.local.NovelDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomDatabaseModule_ProvideDatabaseFactory implements Factory<NovelDatabase> {
  private final Provider<Context> contextProvider;

  public RoomDatabaseModule_ProvideDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NovelDatabase get() {
    return provideDatabase(contextProvider.get());
  }

  public static RoomDatabaseModule_ProvideDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new RoomDatabaseModule_ProvideDatabaseFactory(contextProvider);
  }

  public static NovelDatabase provideDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(RoomDatabaseModule.INSTANCE.provideDatabase(context));
  }
}
