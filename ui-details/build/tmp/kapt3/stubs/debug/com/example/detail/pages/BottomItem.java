package com.example.detail.pages;

import androidx.annotation.StringRes;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.example.data.dto.novel.Comment;
import com.example.detail.*;
import com.example.detail.R;
import com.example.novels.Screen;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0001\tB\u001b\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0001\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/detail/pages/BottomItem;", "", "labelResId", "", "contentDescriptionResId", "(II)V", "getContentDescriptionResId", "()I", "getLabelResId", "ImageVectorIcon", "Lcom/example/detail/pages/BottomItem$ImageVectorIcon;", "ui-details_debug"})
abstract class BottomItem {
    private final int labelResId = 0;
    private final int contentDescriptionResId = 0;
    
    private BottomItem(@androidx.annotation.StringRes()
    int labelResId, @androidx.annotation.StringRes()
    int contentDescriptionResId) {
        super();
    }
    
    public final int getLabelResId() {
        return 0;
    }
    
    public final int getContentDescriptionResId() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/detail/pages/BottomItem$ImageVectorIcon;", "Lcom/example/detail/pages/BottomItem;", "labelResId", "", "contentDescriptionResId", "iconImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(IILandroidx/compose/ui/graphics/vector/ImageVector;)V", "getIconImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "ui-details_debug"})
    public static final class ImageVectorIcon extends com.example.detail.pages.BottomItem {
        @org.jetbrains.annotations.NotNull()
        private final androidx.compose.ui.graphics.vector.ImageVector iconImageVector = null;
        
        public ImageVectorIcon(@androidx.annotation.StringRes()
        int labelResId, @androidx.annotation.StringRes()
        int contentDescriptionResId, @org.jetbrains.annotations.NotNull()
        androidx.compose.ui.graphics.vector.ImageVector iconImageVector) {
            super(0, 0);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.compose.ui.graphics.vector.ImageVector getIconImageVector() {
            return null;
        }
    }
}