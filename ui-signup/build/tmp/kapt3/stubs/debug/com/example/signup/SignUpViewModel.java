package com.example.signup;

import android.util.Patterns;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import com.example.data.repository.NovelRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/example/signup/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/data/repository/NovelRepository;", "(Lcom/example/data/repository/NovelRepository;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Lcom/example/signup/SignUpState;", "state", "Landroidx/compose/runtime/State;", "getState", "()Landroidx/compose/runtime/State;", "hideErrorDialog", "", "singUp", "username", "", "email", "password1", "password2", "navController", "Landroidx/navigation/NavController;", "ui-signup_debug"})
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.repository.NovelRepository repository = null;
    private final androidx.compose.runtime.MutableState<com.example.signup.SignUpState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.signup.SignUpState> state = null;
    
    @javax.inject.Inject()
    public SignUpViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository repository) {
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
    java.lang.String password2, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    public final void hideErrorDialog() {
    }
}