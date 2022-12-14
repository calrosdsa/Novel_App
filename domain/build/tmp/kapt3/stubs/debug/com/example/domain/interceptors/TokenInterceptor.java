package com.example.domain.interceptors;

import com.example.domain.UserAuth;
import kotlinx.coroutines.*;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/domain/interceptors/TokenInterceptor;", "Lokhttp3/Interceptor;", "auth", "Lcom/example/domain/UserAuth;", "(Lcom/example/domain/UserAuth;)V", "tokenValue", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "domain_debug"})
public final class TokenInterceptor implements okhttp3.Interceptor {
    private final java.lang.String tokenValue = null;
    
    @javax.inject.Inject()
    public TokenInterceptor(@org.jetbrains.annotations.NotNull()
    com.example.domain.UserAuth auth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
}