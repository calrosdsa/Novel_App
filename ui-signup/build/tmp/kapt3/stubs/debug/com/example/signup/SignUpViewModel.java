package com.example.signup;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.example.data.dto.user.ErrorSingResponse;
import com.example.data.repository.NovelRepository;
import com.example.domain.resources.Resource;
import com.google.gson.Gson;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/example/signup/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/data/repository/NovelRepository;", "context", "Landroid/content/Context;", "(Lcom/example/data/repository/NovelRepository;Landroid/content/Context;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Lcom/example/signup/SignUpState;", "state", "Landroidx/compose/runtime/State;", "getState", "()Landroidx/compose/runtime/State;", "hideErrorDialog", "", "singUp", "username", "", "email", "password1", "password2", "ui-signup_debug"})
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.repository.NovelRepository repository = null;
    private final android.content.Context context = null;
    private final androidx.compose.runtime.MutableState<com.example.signup.SignUpState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.signup.SignUpState> state = null;
    
    @javax.inject.Inject()
    public SignUpViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository repository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.signup.SignUpState> getState() {
        return null;
    }
    
    public final void singUp(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password1, @org.jetbrains.annotations.NotNull()
    java.lang.String password2) {
    }
    
    public final void hideErrorDialog() {
    }
}