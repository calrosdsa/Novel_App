package com.example.login;

import android.util.Patterns;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import com.example.data.repository.NovelRepository;
import com.example.domain.interactors.UpdateFollowingNovels;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/data/repository/NovelRepository;", "updateFollowingNovels", "Lcom/example/domain/interactors/UpdateFollowingNovels;", "(Lcom/example/data/repository/NovelRepository;Lcom/example/domain/interactors/UpdateFollowingNovels;)V", "_state", "Landroidx/compose/runtime/MutableState;", "Lcom/example/login/LoginState;", "state", "Landroidx/compose/runtime/State;", "getState", "()Landroidx/compose/runtime/State;", "hideErrorDialog", "", "login", "email", "", "password", "navController", "Landroidx/navigation/NavController;", "ui-login_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.data.repository.NovelRepository repository = null;
    private final com.example.domain.interactors.UpdateFollowingNovels updateFollowingNovels = null;
    private final androidx.compose.runtime.MutableState<com.example.login.LoginState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.login.LoginState> state = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.example.data.repository.NovelRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.domain.interactors.UpdateFollowingNovels updateFollowingNovels) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.login.LoginState> getState() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    public final void hideErrorDialog() {
    }
}