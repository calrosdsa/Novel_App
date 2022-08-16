package com.example.data.dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/example/data/dto/user/LoginResponse;", "", "key", "", "user", "Lcom/example/data/dto/user/UserX;", "email", "", "username", "(Ljava/lang/String;Lcom/example/data/dto/user/UserX;Ljava/util/List;Ljava/util/List;)V", "getEmail", "()Ljava/util/List;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getUser", "()Lcom/example/data/dto/user/UserX;", "setUser", "(Lcom/example/data/dto/user/UserX;)V", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "data_debug"})
public final class LoginResponse {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String key;
    @org.jetbrains.annotations.NotNull()
    private com.example.data.dto.user.UserX user;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> username = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.dto.user.LoginResponse copy(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.example.data.dto.user.UserX user, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> email, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> username) {
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
    
    public LoginResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.example.data.dto.user.UserX user, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> email, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> username) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKey() {
        return null;
    }
    
    public final void setKey(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.dto.user.UserX component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.dto.user.UserX getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.example.data.dto.user.UserX p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getUsername() {
        return null;
    }
}