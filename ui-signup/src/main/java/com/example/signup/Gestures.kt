package com.example.signup

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@Composable
fun Tutorial5_1Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "1-) **Clickable** modifier to the element to make it clickable within its " +
                    "bounds and show an indication as specified in indication parameter."
        )
        Text(text = "Position of clickable")
        ClickableOrderExample()
        Text(text = "Custom ripple and bound")
        CustomRippleExample()
        Text(text = "Custom ripple theme")
        CustomRippleThemeExample()
        Text(text = "Custom Indication")
        CustomIndicationExample()
        Text(
            text = "2-)  **InteractionSource** represents a stream of **Interaction**s corresponding to events emitted by a\n" +
                    " component. These [Interaction]s can be used to change how components appear in different\n" +
                    " states, such as when a component is pressed or dragged. Setting same **InteractionSource** for different" +
                    " composables we can have synchronous click effects."
        )
        Text(text = "Composables with same InteractionSource")
        MutualInteractionSourceExample()
        Text(text = "InteractionSource that updates state of other")
        DiscreteInteractionSourceExample()
        Text(text = "InteractionSource Interaction as Flow")
        InteractionFlowExample()
    //    Text(text = "Collect Interaction flow and update other InteractionSource")
      //  DiscreteInteractionSourceFLowExample()

    }
}

private val color = Color(0xffBDBDBD)

private val modifierWithClip = Modifier
    .fillMaxWidth()
    .height(40.dp)
    .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp), clip = true)
    .background(color)

private val modifierNoClip = Modifier
    .fillMaxWidth()
    .height(40.dp)
    .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp), clip = false)
    .background(color, shape = RoundedCornerShape(16.dp))

@Composable
private fun ClickableOrderExample() {
    // This one clips ripple to have correct form
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifierWithClip
                .clickable {}
        ) {
            Text(
                text = "Clip before clickable",
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        // This ripple is not bound correctly to shape
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable {}
                .then(modifierWithClip)
        ) {
            Text(
                text = "Clip after clickable",
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CustomRippleExample() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifierWithClip
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = true,
                        radius = 250.dp,
                        color = Color.Green
                    ),
                    onClick = {}
                )
        ) {
            Text(
                text = "rememberRipple() bounded",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            contentAlignment = Alignment.Center,
            // 🔥 Modifier.clip also bounds ripple
            modifier = modifierNoClip
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = false,
                        radius = 250.dp,
                        color = Color.Green
                    ),
                    onClick = {}
                )
        ) {
            Text(
                text = "rememberRipple() unbounded",
                color = Color.White
            )
        }
    }
}

@Composable
fun CustomRippleThemeExample() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        CompositionLocalProvider(LocalRippleTheme provides CustomRippleTheme(Color.Cyan)) {
            Box(
                modifier = modifierWithClip.clickable {},
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Custom Ripple Theme",
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        CompositionLocalProvider(LocalRippleTheme provides CustomRippleTheme(Color.Magenta)) {
            Box(
                modifier = modifierWithClip.clickable {},
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Custom Ripple Theme",
                    color = Color.White
                )
            }
        }
    }
}


@OptIn(InternalCoroutinesApi::class)
@Composable
fun CustomIndicationExample() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {


        val indication1: CustomIndication = CustomIndication(
            pressColor = Color.Cyan,
            cornerRadius = CornerRadius(30f, 30f),
            alpha = .7f
        )

        val indication2: CustomIndication = CustomIndication(
            pressColor = Color.Red,
            cornerRadius = CornerRadius(16f, 16f),
            alpha = .5f
        )

        val indication3: CustomIndication = CustomIndication(
            pressColor = Color(0xffFFEB3B),
            alpha = .4f,
            drawRoundedShape = false,
        )

        Box(
            modifierWithClip
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = indication1,
                    onClick = {}
                ),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Indication",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifierWithClip
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = indication2,
                    onClick = {}
                ),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Indication",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifierWithClip
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = indication3,
                    onClick = {}
                ),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Indication with Circle Shape",
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MutualInteractionSourceExample() {
    // 🔥 This interaction is shared by Row and Card
    val interactionSource = remember { MutableInteractionSource() }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp), clip = true)
            .background(Color(0xff64B5F6))
            .clickable(
                enabled = true,
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = {
                    Toast
                        .makeText(context, "Row is clicked", Toast.LENGTH_SHORT)
                        .show()
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Card(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, bottom = 8.dp)
                .size(50.dp),
            backgroundColor = Color(0xff2196F3),
            shape = CircleShape,
            interactionSource = interactionSource,
            onClick = {
                Toast.makeText(context, "Icon is clicked", Toast.LENGTH_SHORT).show()
            },
            elevation = 0.dp,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    tint = Color(0xffBBDEFB)
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Title",
            style = TextStyle(fontSize = 16.sp),
        )
    }
}

@Composable
private fun DiscreteInteractionSourceExample() {
    val context = LocalContext.current

    // 🔥 This interaction source is set by outer composable to trigger ripple on inner one
    val interactionSource = MutableInteractionSource()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(8.dp), clip = true)
                .background(color = Color.Yellow)
                .clickable {

                    coroutineScope.launch {

                        val press = PressInteraction.Press(Offset.Zero)
                        interactionSource.emit(
                            press
                        )
                        delay(300)
                        interactionSource.emit(
                            PressInteraction.Release(press)
                        )
                    }

                    Toast
                        .makeText(context, "Outer one is clicked", Toast.LENGTH_SHORT)
                        .show()

                }
                .padding(8.dp)

        ) {

            Text("Outer Composable", color = Color.White)

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .shadow(2.dp, RoundedCornerShape(8.dp), clip = true)
                    .background(color = Color.Blue)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple(),
                        onClick = {
                            Toast
                                .makeText(context, "🔥 Inner one is clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                    .padding(8.dp)
            ) {
                Text("Inner Composable", color = Color.White, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun InteractionFlowExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        val interactionSource = MutableInteractionSource()
        val context = LocalContext.current

        LaunchedEffect(key1 = Unit, block = {
            interactionSource.interactions
                .onEach { interaction: Interaction ->
                    Toast.makeText(context, "Interaction: $interaction", Toast.LENGTH_SHORT).show()
                }
                .launchIn(this)
        }
        )

        Box(
            modifierWithClip
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(),
                    onClick = {}
                ),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Indication",
                color = Color.White
            )
        }
    }
}

private class CustomRippleTheme(val color: Color = Color.Black) : RippleTheme {
    @Composable
    override fun defaultColor(): Color = color

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(color, lightTheme = !isSystemInDarkTheme())
}

private class CustomIndication(
    val pressColor: Color = Color.Red,
    val cornerRadius: CornerRadius = CornerRadius(16f, 16f),
    val alpha: Float = 0.5f,
    val drawRoundedShape: Boolean = true
) : Indication {

    private inner class DefaultIndicationInstance(
        private val isPressed: State<Boolean>,
    ) : IndicationInstance {

        override fun ContentDrawScope.drawIndication() {

            drawContent()
            when {
                isPressed.value -> {
                    if (drawRoundedShape) {
                        drawRoundRect(
                            cornerRadius = cornerRadius,
                            color = pressColor.copy(
                                alpha = alpha
                            ), size = size
                        )
                    } else {

                        drawCircle(
                            radius = size.width,
                            color = pressColor.copy(
                                alpha = alpha
                            )
                        )
                    }
                }
            }
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()
        return remember(interactionSource) {
            DefaultIndicationInstance(isPressed)
        }
    }
}