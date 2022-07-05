package com.example.domain.interceptors;

import com.example.domain.UserAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TokenInterceptor_Factory implements Factory<TokenInterceptor> {
  private final Provider<String> tokenProvider;

  private final Provider<UserAuth> authProvider;

  public TokenInterceptor_Factory(Provider<String> tokenProvider, Provider<UserAuth> authProvider) {
    this.tokenProvider = tokenProvider;
    this.authProvider = authProvider;
  }

  @Override
  public TokenInterceptor get() {
    return newInstance(tokenProvider.get(), authProvider.get());
  }

  public static TokenInterceptor_Factory create(Provider<String> tokenProvider,
      Provider<UserAuth> authProvider) {
    return new TokenInterceptor_Factory(tokenProvider, authProvider);
  }

  public static TokenInterceptor newInstance(String token, UserAuth auth) {
    return new TokenInterceptor(token, auth);
  }
}
