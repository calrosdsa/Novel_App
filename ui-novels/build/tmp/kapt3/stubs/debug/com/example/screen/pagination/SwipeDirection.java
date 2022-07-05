package com.example.screen.pagination;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import com.example.data.dto.novels.Popular;
import com.example.data.dto.novels.Rated;
import com.example.data.dto.novels.Trend;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/screen/pagination/SwipeDirection;", "", "raw", "", "title", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getRaw", "()I", "getTitle", "()Ljava/lang/String;", "Right", "Initial", "Left", "ui-novels_debug"})
public enum SwipeDirection {
    /*public static final*/ Right /* = new Right(0, null) */,
    /*public static final*/ Initial /* = new Initial(0, null) */,
    /*public static final*/ Left /* = new Left(0, null) */;
    private final int raw = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    SwipeDirection(int raw, java.lang.String title) {
    }
    
    public final int getRaw() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
}