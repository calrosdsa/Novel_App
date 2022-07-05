package com.example.domain.repository;

import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.domain.StateRefresh;
import com.example.domain.UserAuth;
import com.example.domain.UserData;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.GINGERBREAD)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR+\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/domain/repository/UserAuthImpl;", "Lcom/example/domain/UserAuth;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "authToken", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/domain/UserData;", "getAuthToken", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "<set-?>", "Lcom/example/domain/StateRefresh;", "refresh", "getRefresh", "()Lcom/example/domain/StateRefresh;", "setRefresh", "(Lcom/example/domain/StateRefresh;)V", "refresh$delegate", "Lcom/example/domain/repository/UserAuthImpl$RefreshPreferenceDelegate;", "refreshState", "getRefreshState", "tokenValue", "getTokenValue", "()Lcom/example/domain/UserData;", "setTokenValue", "(Lcom/example/domain/UserData;)V", "tokenValue$delegate", "Lcom/example/domain/repository/UserAuthImpl$UserPreferenceDelegate;", "RefreshPreferenceDelegate", "UserPreferenceDelegate", "domain_debug"})
public final class UserAuthImpl implements com.example.domain.UserAuth {
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.domain.UserData> authToken = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.domain.repository.UserAuthImpl.UserPreferenceDelegate tokenValue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.domain.StateRefresh> refreshState = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.domain.repository.UserAuthImpl.RefreshPreferenceDelegate refresh$delegate = null;
    
    @javax.inject.Inject()
    public UserAuthImpl(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences preferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<com.example.domain.UserData> getAuthToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.domain.UserData getTokenValue() {
        return null;
    }
    
    @java.lang.Override()
    public void setTokenValue(@org.jetbrains.annotations.NotNull()
    com.example.domain.UserData p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.MutableStateFlow<com.example.domain.StateRefresh> getRefreshState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.domain.StateRefresh getRefresh() {
        return null;
    }
    
    @java.lang.Override()
    public void setRefresh(@org.jetbrains.annotations.NotNull()
    com.example.domain.StateRefresh p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0096\u0002J\'\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/domain/repository/UserAuthImpl$UserPreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "Lcom/example/domain/UserData;", "name", "", "(Lcom/example/domain/repository/UserAuthImpl;Ljava/lang/String;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "domain_debug"})
    public final class UserPreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, com.example.domain.UserData> {
        private final java.lang.String name = null;
        
        public UserPreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.domain.UserData getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
        com.example.domain.UserData value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002J\'\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/domain/repository/UserAuthImpl$RefreshPreferenceDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "Lcom/example/domain/StateRefresh;", "name", "", "default", "(Lcom/example/domain/repository/UserAuthImpl;Ljava/lang/String;Lcom/example/domain/StateRefresh;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "domain_debug"})
    public final class RefreshPreferenceDelegate implements kotlin.properties.ReadWriteProperty<java.lang.Object, com.example.domain.StateRefresh> {
        private final java.lang.String name = null;
        
        public RefreshPreferenceDelegate(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        com.example.domain.StateRefresh p1_772401952) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.domain.StateRefresh getValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property) {
            return null;
        }
        
        @java.lang.Override()
        public void setValue(@org.jetbrains.annotations.Nullable()
        java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
        com.example.domain.StateRefresh value) {
        }
    }
}