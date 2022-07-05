package com.example.signup;

import android.widget.Toast;
import androidx.compose.foundation.*;
import androidx.compose.foundation.interaction.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import kotlinx.coroutines.InternalCoroutinesApi;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u0018"}, d2 = {"Lcom/example/signup/CustomIndication;", "Landroidx/compose/foundation/Indication;", "pressColor", "Landroidx/compose/ui/graphics/Color;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "alpha", "", "drawRoundedShape", "", "(JJFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getCornerRadius-kKHJgLs", "()J", "J", "getDrawRoundedShape", "()Z", "getPressColor-0d7_KjU", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "DefaultIndicationInstance", "ui-signup_debug"})
final class CustomIndication implements androidx.compose.foundation.Indication {
    private final long pressColor = 0L;
    private final long cornerRadius = 0L;
    private final float alpha = 0.0F;
    private final boolean drawRoundedShape = false;
    
    private CustomIndication(long pressColor, long cornerRadius, float alpha, boolean drawRoundedShape) {
        super();
    }
    
    public final float getAlpha() {
        return 0.0F;
    }
    
    public final boolean getDrawRoundedShape() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.compose.runtime.Composable()
    @java.lang.Override()
    public androidx.compose.foundation.IndicationInstance rememberUpdatedInstance(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.interaction.InteractionSource interactionSource) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/signup/CustomIndication$DefaultIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "isPressed", "Landroidx/compose/runtime/State;", "", "(Lcom/example/signup/CustomIndication;Landroidx/compose/runtime/State;)V", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui-signup_debug"})
    final class DefaultIndicationInstance implements androidx.compose.foundation.IndicationInstance {
        private final androidx.compose.runtime.State<java.lang.Boolean> isPressed = null;
        
        public DefaultIndicationInstance(@org.jetbrains.annotations.NotNull()
        androidx.compose.runtime.State<java.lang.Boolean> isPressed) {
            super();
        }
        
        @java.lang.Override()
        public void drawIndication(@org.jetbrains.annotations.NotNull()
        androidx.compose.ui.graphics.drawscope.ContentDrawScope $this$drawIndication) {
        }
    }
}