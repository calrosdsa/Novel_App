package com.example.screen.pagination;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B*\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\t\u00a2\u0006\u0002\u0010\nR\u001c\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0003\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/example/screen/pagination/TabItem;", "", "index", "", "title", "", "Screen", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getScreen", "()Lkotlin/jvm/functions/Function0;", "getIndex", "()I", "getTitle", "()Ljava/lang/String;", "Contacts", "Home", "Settings", "Lcom/example/screen/pagination/TabItem$Home;", "Lcom/example/screen/pagination/TabItem$Contacts;", "Lcom/example/screen/pagination/TabItem$Settings;", "ui-novels_debug"})
public abstract class TabItem {
    private final int index = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> Screen = null;
    
    private TabItem(int index, java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> Screen) {
        super();
    }
    
    public final int getIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getScreen() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/screen/pagination/TabItem$Home;", "Lcom/example/screen/pagination/TabItem;", "()V", "ui-novels_debug"})
    public static final class Home extends com.example.screen.pagination.TabItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.screen.pagination.TabItem.Home INSTANCE = null;
        
        private Home() {
            super(0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/screen/pagination/TabItem$Contacts;", "Lcom/example/screen/pagination/TabItem;", "()V", "ui-novels_debug"})
    public static final class Contacts extends com.example.screen.pagination.TabItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.screen.pagination.TabItem.Contacts INSTANCE = null;
        
        private Contacts() {
            super(0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/screen/pagination/TabItem$Settings;", "Lcom/example/screen/pagination/TabItem;", "()V", "ui-novels_debug"})
    public static final class Settings extends com.example.screen.pagination.TabItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.screen.pagination.TabItem.Settings INSTANCE = null;
        
        private Settings() {
            super(0, null, null);
        }
    }
}