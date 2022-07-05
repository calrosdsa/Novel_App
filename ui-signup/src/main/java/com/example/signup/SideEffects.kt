package com.example.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random


@Composable
private fun DisposableEffectLifecycleButton() {
    var showDisposableEffectLifeCycle by remember { mutableStateOf(false) }
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = {
            showDisposableEffectLifeCycle = !showDisposableEffectLifeCycle

        }
    ) {
        Text("Display DisposableEffect with LifeCycle")
    }

    if (showDisposableEffectLifeCycle) {

        val context = LocalContext.current

        DisposableEffectWithLifeCycle(
            onResume = {
                Toast.makeText(
                    context,
                    "DisposableEffectWithLifeCycle onResume()",
                    Toast.LENGTH_SHORT
                )
                    .show()
            },
            onPause = {
                Toast.makeText(
                    context,
                    "DisposableEffectWithLifeCycle onPause()",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

        )
    }
}

@Composable
private fun DisposableEffectWithLifeCycle(
    onResume: () -> Unit,
    onPause: () -> Unit,
) {

    val context = LocalContext.current

    // Safely update the current lambdas when a new one is provided
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    Toast.makeText(
        context,
        "DisposableEffectWithLifeCycle composition ENTER",
        Toast.LENGTH_SHORT
    ).show()

    val currentOnResume by rememberUpdatedState(onResume)
    val currentOnPause by rememberUpdatedState(onPause)

    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for lifecycle events
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {
                    Toast.makeText(
                        context,
                        "DisposableEffectWithLifeCycle ON_CREATE",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Lifecycle.Event.ON_START -> {
                    Toast.makeText(
                        context,
                        "DisposableEffectWithLifeCycle ON_START",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Lifecycle.Event.ON_RESUME -> {
                    currentOnResume()
                }
                Lifecycle.Event.ON_PAUSE -> {
                    currentOnPause()
                }
                Lifecycle.Event.ON_STOP -> {
                    Toast.makeText(
                        context,
                        "DisposableEffectWithLifeCycle ON_STOP",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Lifecycle.Event.ON_DESTROY -> {
                    Toast.makeText(
                        context,
                        "DisposableEffectWithLifeCycle ON_DESTROY",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        context,
                        "DisposableEffectWithLifeCycle ON_DESTROY",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)

            Toast.makeText(
                context,
                "DisposableEffectWithLifeCycle composition EXIT",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    Column(modifier = Modifier.background(Color(0xff03A9F4))) {
        Text(
            text = "Disposable Effect with lifecycle",
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}





@Composable
private fun SideEffectExample() {

    val context = LocalContext.current

    // Updates composable that listens changes in value of this State
    var counterOuter by remember { mutableStateOf(0) }
    // Updates composable that listens changes in value of this State
    var counterInner by remember { mutableStateOf(0) }

    // only runs first time SideEffectSample is called

    Column(
        Modifier
            .padding(8.dp)
    ) {

        // only runs first time SideEffectSample is called


        Button(onClick = { counterOuter++ }, modifier = Modifier.fillMaxWidth()) {
            SideEffect {
                Toast.makeText(
                    context,
                    "SideEffectExample() Button OUTER",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            Text(text = "Outer Composable: $counterOuter")
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {



            Button(onClick = { counterInner++ }, modifier = Modifier.fillMaxWidth()) {

                SideEffect {
                    Toast.makeText(
                        context,
                        "SideEffectExample() Button INNER",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                Text(text = "Inner Composable: $counterInner")
            }

        }
    }
}



@Composable
private fun ProduceStateSampleButton() {

    var loadImage by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display a load image button when image is not loading
        OutlinedButton(
            onClick = {
                loadImage = !loadImage
            }
        ) {
            Text(text = "Click to load image with produceState $loadImage")
        }

        if (loadImage) {
            ProduceStateExample()
        }
    }
}

/**
 * produceState launches a coroutine scoped to the Composition that can push values into
 * a returned State. Use it to convert non-Compose state into Compose state,
 * for example bringing external subscription-driven
 * state such as Flow, LiveData, or RxJava into the Composition.
 *
 * The producer is launched when produceState enters the Composition,
 * and will be cancelled when it leaves the Composition. The returned State conflates;
 * setting the same value won't trigger a recomposition.
 * Even though produceState creates a coroutine, it can also be used to observe
 * non-suspending sources of data. To remove the subscription to that source,
 * use the awaitDispose function.
 */
@Composable
private fun ProduceStateExample() {
    val context = LocalContext.current

    val url = "www.example.com"
    val imageRepository = remember { ImageRepository() }

    val imageState = loadNetworkImage(url = url, imageRepository)

    when (imageState.value) {
        is Result.Loading -> {
            println("🔥 ProduceStateExample() Result.Loading")
            Toast.makeText(context, "🔥 ProduceStateExample() Result.Loading", Toast.LENGTH_SHORT)
                .show()
            CircularProgressIndicator()
        }

        is Result.Error -> {
            println("❌ ProduceStateExample() Result.Error")
            Toast.makeText(context, "❌ ProduceStateExample() Result.Error", Toast.LENGTH_SHORT)
                .show()

            Image(imageVector = Icons.Default.Error, contentDescription = null)
        }

        is Result.Success -> {
            println("✅ ProduceStateExample() Result.Success")
            Toast.makeText(context, "✅ ProduceStateExample() Result.Success", Toast.LENGTH_SHORT)
                .show()

            val image = (imageState.value as Result.Success).image

            Image(
                painterResource(id = image.imageIdRes),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun loadNetworkImage(
    url: String,
    imageRepository: ImageRepository
): State<Result> {

    // Creates a State<T> with Result.Loading as initial value
    // If either `url` or `imageRepository` changes, the running producer
    // will cancel and will be re-launched with the new inputs.
    return produceState<Result>(initialValue = Result.Loading, url, imageRepository) {

        // In a coroutine, can make suspend calls
        val image = imageRepository.load()

        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = if (image == null) {
            Result.Error
        } else {
            Result.Success(image)
        }
    }
}

sealed class Result {
    object Loading : Result()
    object Error : Result()
    class Success(val image: ImageRes) : Result()
}

class ImageRes(val imageIdRes: Int)

class ImageRepository() {

    /**
     * Returns a drawable resource or null to simulate Result with Success or Error states
     */
    suspend fun load(): ImageRes? {
        delay(2000)

        // Random is added to return null if get a random number that is zero.
        // Possibility of getting null is 1/4
        return if (Random.nextInt(until = 4) > 0) {

            val images = listOf(
                R.drawable.ic_photo3,
                R.drawable.ic_photo1,
                R.drawable.ic_photo2,
                R.drawable.ic_photo3,
                R.drawable.ic_photo4,
                R.drawable.ic_photo1,
            )

            // Load a random id each time load function is called
            ImageRes(images[Random.nextInt(images.size)])
        } else {
            null
        }
    }
}


@Composable
private fun DerivedStateOfExample() {

    var numberOfItems by remember {
        mutableStateOf(0)
    }

    // Use derivedStateOf when a certain state is calculated or derived from other state objects.
    // Using this function guarantees that the calculation will only occur whenever one
    // of the states used in the calculation changes.
    val derivedStateMax by remember {
        derivedStateOf {
            numberOfItems > 5
        }
    }
    val derivedStateMin by remember {
        derivedStateOf {
            numberOfItems > 0
        }
    }
    val context = LocalContext.current
    SideEffect {
        Toast.makeText(context, "🔥 ProduceStateExample() Result.Loading", Toast.LENGTH_SHORT)
            .show()
    }

    Column(modifier = Modifier.padding(horizontal = 8.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Amount to buy: $numberOfItems", modifier = Modifier.weight(1f))
            IconButton(onClick = { numberOfItems++ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(onClick = { if (derivedStateMin) numberOfItems-- }) {
                Icon(imageVector = Icons.Default.Remove, contentDescription = "remove")
            }
        }

        println(
            "🤔 COMPOSING..." +
                    "numberOfItems: $numberOfItems, " +
                    "derivedStateMax: $derivedStateMax, " +
                    "derivedStateMin: $derivedStateMin"
        )
        if (derivedStateMax) {
            Text("You cannot buy more than 5 items", color = Color(0xffE53935))
        }
    }
}




@Composable
private fun DerivedStateOfSample2(scrollState: LazyListState) {

    val coroutineScope = rememberCoroutineScope()

    val firstItemVisible by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex != 0 }
    }

    Box {
        LazyRow(
            state = scrollState,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(200) { place ->
                    Text(text = "kamckmacmaksm $place")
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        )

        if (firstItemVisible) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier.align(Alignment.BottomEnd),
                backgroundColor = Color(0xffE53935)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}



@Composable
private fun SnapshotFlowExample(scrollState: LazyListState) {

    var sentLogCount by remember { mutableStateOf(0) }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex }
            .map { index -> index > 0 }
            .distinctUntilChanged()
            .filter { it }
            .collect {
                sentLogCount++
            }
    }

    if (sentLogCount > 0) {
        Text(
            "💗 SnapshotFlowSample collect called **$sentLogCount** times " +
                    "after firstVisibleItemIndex > map threshold"
        )
    }
}
