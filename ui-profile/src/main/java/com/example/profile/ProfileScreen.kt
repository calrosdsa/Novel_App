    package com.example.profile

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.compose.ui.SearchTopBar
import com.example.compose.ui.shouldUseDarkMode
import com.example.profile.components.IconTextRow
import com.example.profile.components.IconTextWithToggle
import com.example.profile.components.InfoRow
import com.example.profile.components.UserInfoRow
import com.example.profile.components.placeholder.UserInfoPlaceholder
import com.example.settings.AppTheme
import com.example.settings.SettingsActivity
import com.example.settings.UserSettings


    private val shapeBox = 25.dp


@Composable
fun ProfileScreen(
//    openSettings: () -> Unit,context:Context
     navController: NavController,
     modifier: Modifier,
     loginScreen : String,
     context: Context,
     scaffoldState: ScaffoldState,
     viewModel: ProfileViewModel = hiltViewModel()
){
    val state = viewModel.state
    val userBitMap = ImageBitmap.imageResource(id = R.drawable.ic_user_placeholder)
    val isNightMode = viewModel.themeMode.shouldUseDarkMode()
    val isChecked  = remember { mutableStateOf(isNightMode) }
    val coroutineScope = rememberCoroutineScope()


    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }
    Scaffold(
        topBar = {
            SearchTopBar(
                state = scaffoldState,
                navController = navController,
                coroutineScope = coroutineScope
            )
        },
        scaffoldState = scaffoldState
    ) {

    Column(modifier = modifier
        .padding(it)
        .background(color = MaterialTheme.colors.background)
        .padding(20.dp)) {


            Box(modifier = Modifier
                .clip(shape = RoundedCornerShape(shapeBox))
                .background(color = MaterialTheme.colors.secondaryVariant)
                .padding(10.dp)

            ) {



                if(state.profile != null) {
            UserInfoRow(
                username = state.profile.name,
                avatar = state.profile.avatar,
                description = state.profile.bio
            ) {
           //      navController.navigate(loginScreen)
            }
            }else{
                    InfoRow(
                        signIn = stringResource(id = R.string.signin),
                        placeHolderUser = userBitMap) {
                        navController.navigate(loginScreen)

                    }
            }

                if (state.is_loading){

                   UserInfoPlaceholder()

                }

        }

       Spacer(modifier = Modifier.height(40.dp))


        IconTextRow(IconValue =Icons.Default.ModeEdit , title = "Edit Profile")
        IconTextRow(IconValue =Icons.Default.Inbox , title = "Inbox")
        IconTextRow(IconValue =Icons.Default.Settings , title = "Settings",
            description = "Notifications, language",
            modifier = Modifier.clickable {
                context.startActivity(Intent(
                    context,SettingsActivity::class.java,
                ))
            }
        )
        IconTextRow(IconValue =Icons.Default.Forum , title = "Forum")


        IconTextWithToggle(IconValue = Icons.Default.ModeNight, title = "Night Mode", isChecked = isChecked.value){
                value, theme -> isChecked.value = value;
            viewModel.onChangeMode(theme)
        }
        IconTextRow(
            IconValue =Icons.Default.Star ,
            title = "Like WebNovel? Live us a Review!",
            description = "85% of readers have already left us a review!"
        )
        IconTextRow(IconValue =Icons.Default.HelpCenter , title = "Help Center")
            IconTextRow(IconValue =Icons.Default.Info , title = "About")
    }
    }
}







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
        val lifeText = remember{
        mutableStateOf("")
        }

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
                        lifeText.value = "onCreate"
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
                        lifeText.value = "OnStop"
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
                text = lifeText.value,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }

