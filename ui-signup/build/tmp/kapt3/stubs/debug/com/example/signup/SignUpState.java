package com.example.signup;

import androidx.annotation.StringRes;
import com.example.data.dto.user.LoginResponse;
import com.example.data.dto.user.SignUpResponse;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\u000bH\u00c6\u0003J\t\u0010,\u001a\u00020\u000bH\u00c6\u0003J\u0084\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\bH\u00d6\u0001J\t\u00102\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015\u00a8\u00063"}, d2 = {"Lcom/example/signup/SignUpState;", "", "response", "Lcom/example/data/dto/user/SignUpResponse;", "successLogin", "", "displayProgressBar", "errorEmail", "", "errorPassword", "username", "", "email", "password1", "password2", "errorMessage", "error", "(Lcom/example/data/dto/user/SignUpResponse;ZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getDisplayProgressBar", "()Z", "getEmail", "()Ljava/lang/String;", "getError", "getErrorEmail", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "getErrorPassword", "getPassword1", "getPassword2", "getResponse", "()Lcom/example/data/dto/user/SignUpResponse;", "getSuccessLogin", "getUsername", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/example/data/dto/user/SignUpResponse;ZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/example/signup/SignUpState;", "equals", "other", "hashCode", "toString", "ui-signup_debug"})
public final class SignUpState {
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.dto.user.SignUpResponse response = null;
    private final boolean successLogin = false;
    private final boolean displayProgressBar = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer errorEmail = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer errorPassword = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String username = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String password1 = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String password2 = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String error = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.signup.SignUpState copy(@org.jetbrains.annotations.Nullable()
    com.example.data.dto.user.SignUpResponse response, boolean successLogin, boolean displayProgressBar, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorEmail, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorPassword, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password1, @org.jetbrains.annotations.NotNull()
    java.lang.String password2, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SignUpState() {
        super();
    }
    
    public SignUpState(@org.jetbrains.annotations.Nullable()
    com.example.data.dto.user.SignUpResponse response, boolean successLogin, boolean displayProgressBar, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorEmail, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorPassword, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password1, @org.jetbrains.annotations.NotNull()
    java.lang.String password2, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer errorMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.user.SignUpResponse component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.dto.user.SignUpResponse getResponse() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean getSuccessLogin() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getDisplayProgressBar() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getErrorEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getErrorPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getError() {
        return null;
    }
}