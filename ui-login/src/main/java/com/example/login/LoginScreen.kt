package com.example.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.components.EventDialog
import com.example.compose.components.RoundedButton
import com.example.compose.components.TransparentTextField
import com.example.novels.MainDestination
//`import com.example.signup.SignUpActivity
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavController,
  //  onNavigateToRegister: () -> Unit,
   // onDismissDialog: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val emailValue = rememberSaveable{ mutableStateOf("") }
//    val coroutineScope = rememberCoroutineScope()
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
//    val context = LocalContext.current



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            ConstraintLayout() {

                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .constrainAs(surface) {
                            //bottom.linkTo(parent.bottom)
                            //top.linkTo(parent.top)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){
                        state.user?.let { Text(text = it.username,
                        color = MaterialTheme.colors.primary
                            ) }

                        Text(
                            text = "Welcome Back!",
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colors.primary

                            )
                        )

                        Text(
                            text = "Login to your Account",
                            style = MaterialTheme.typography.h5.copy(
                                color = MaterialTheme.colors.primary
                            )
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                            TransparentTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email",
                                keyboardType = KeyboardType.Email,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next,
                                error = state.error != ""
                            )
                            AnimatedVisibility(visible =state.error != "") {
                                    Text(
                                        text = state.error,
                                        color = Color.Red,
                                        style = MaterialTheme.typography.body2.copy(
                                            fontWeight = FontWeight(350)
                                        )
                                    )
                            }

                            TransparentTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Password",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()

                                        viewModel.login(emailValue.value, passwordValue.value
                                            ,navController = navController
                                        )
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if(passwordVisibility) {
                                                Icons.Default.Visibility
                                            } else {
                                                Icons.Default.VisibilityOff
                                            },
                                           tint = MaterialTheme.colors.primary,
                                            contentDescription = "Toggle Password Icon"
                                        )
                                    }
                                },
                                error = state.error != "",
                                        visualTransformation = if(passwordVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                }
                            )
                            AnimatedVisibility(visible =state.error != "") {
                                Text(
                                    text = state.error,
                                    color = Color.Red,
                                    style = MaterialTheme.typography.body2.copy(
                                        fontWeight = FontWeight(350)
                                    )
                                )
                            }

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Forgot Password?",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.End,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RoundedButton(
                                text = "Login",
                                displayProgressBar = state.displayProgressBar,
                                onClick = {
                                    viewModel.login(emailValue.value, passwordValue.value
                                       ,navController
                                    )
    //                                navController.navigate("main/profile"){
  //                                      popUpTo("main/profile")  { inclusive = true }
//                                    }
                //                    coroutineScope.launch {

                  //                  }

                                }
                            )

                            ClickableText(
                                text = buildAnnotatedString {
                                    append("Do not have an Account?")

                                    withStyle(
                                        style = SpanStyle(
                                            color = MaterialTheme.colors.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                    ){
                                        append("Sign up")
                                    }
                                }
                            ){
                                navController.navigate("signup"){
                                    launchSingleTop = true
                                    //popUpTo("main") { inclusive = true }
                                }
                            }
                        }
//        Text(
//            text = "akamkas",
//            color = Color.Red,
//            style = MaterialTheme.typography.body2.copy(
//                fontWeight = FontWeight(350)
//            )
//        )
                    }
                }

                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            top.linkTo(surface.top, margin = (-36).dp)
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {
                        navController.navigate(MainDestination.SIGNUP_SCREEN)
        //                onNavigateToRegister()
           //             context.startActivity(
          //                  Intent(context, SignUpActivity::class.java)
          //              )
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(42.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Forward Icon",
                        tint = Color.White
                    )
                }
            }
        }

//       if(state.errorMessage != null){
//            EventDialog(
//                errorMessage = state.errorMessage,
//                onDismiss = viewModel::hideErrorDialog
//            )
//        }
    }
}
