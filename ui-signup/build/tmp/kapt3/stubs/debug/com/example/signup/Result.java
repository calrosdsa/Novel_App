package com.example.signup;

import android.widget.Toast;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/example/signup/Result;", "", "()V", "Error", "Loading", "Success", "Lcom/example/signup/Result$Loading;", "Lcom/example/signup/Result$Error;", "Lcom/example/signup/Result$Success;", "ui-signup_debug"})
public abstract class Result {
    
    private Result() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/signup/Result$Loading;", "Lcom/example/signup/Result;", "()V", "ui-signup_debug"})
    public static final class Loading extends com.example.signup.Result {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.signup.Result.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/signup/Result$Error;", "Lcom/example/signup/Result;", "()V", "ui-signup_debug"})
    public static final class Error extends com.example.signup.Result {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.signup.Result.Error INSTANCE = null;
        
        private Error() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/signup/Result$Success;", "Lcom/example/signup/Result;", "image", "Lcom/example/signup/ImageRes;", "(Lcom/example/signup/ImageRes;)V", "getImage", "()Lcom/example/signup/ImageRes;", "ui-signup_debug"})
    public static final class Success extends com.example.signup.Result {
        @org.jetbrains.annotations.NotNull()
        private final com.example.signup.ImageRes image = null;
        
        public Success(@org.jetbrains.annotations.NotNull()
        com.example.signup.ImageRes image) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.signup.ImageRes getImage() {
            return null;
        }
    }
}