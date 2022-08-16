package com.example.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.components.EventDialog
import com.example.compose.components.RoundedButton
import com.example.compose.components.TransparentTextField


@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel(),
   // onBack: () -> Unit,
 //   onLogin:() -> Unit
 //   onDismissDialog: () -> Unit
) {
    val context = LocalContext.current
    val state = viewModel.state.value

    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password1 = remember { mutableStateOf("") }
    val password2 = remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = MaterialTheme.colors.primary
                    )
                }

                Text(
                    text = "Create An Account",
                    style = MaterialTheme.typography.h5.copy(
                        color = MaterialTheme.colors.primary
                    )
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
           //     horizontalAlignment = Alignment.CenterHorizontally,
          //      verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TransparentTextField(
                    textFieldValue = username,
                    textLabel = "Name",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                    error = state.errorMessage != null,
                )
                AnimatedVisibility(visible =state.errorMessage != null) {
                    state.errorMessage?.let {
                     Text(
                         text = context.getString(it),
                         color = Color.Red,
                         style = MaterialTheme.typography.body2
                     )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                TransparentTextField(
                    textFieldValue = email,
                    textLabel = "Email",
                    keyboardType = KeyboardType.Email,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    imeAction = ImeAction.Next,
                    error = state.errorMessage != null,

                    )
                AnimatedVisibility(visible =state.errorEmail != null) {
                    state.errorEmail?.let {
                        Text(
                            text = context.getString(it),
                            color = Color.Red,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                TransparentTextField(
                    textFieldValue = password1,
                    textLabel = "Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                    error = state.errorMessage != null,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle Password Icon"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                )
                AnimatedVisibility(visible =state.errorPassword != null) {
                    state.errorPassword?.let {
                        Text(
                            text = context.getString(it),
                            color = Color.Red,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                TransparentTextField(
                    textFieldValue = password2,
                    textLabel = "Confirm Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()

                            viewModel.singUp(
                                username.value,
                                email.value,
                                password1.value,
                                password2.value,
               //                 navController
                            )
                        }
                    ),
                    imeAction = ImeAction.Done,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                confirmPasswordVisibility = !confirmPasswordVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if (confirmPasswordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle Password Icon"
                            )
                        }
                    },
                    visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(20.dp))

                RoundedButton(
                    text = "Sign Up",
                    displayProgressBar = state.displayProgressBar,
                    onClick = {
                        focusManager.clearFocus()
                        viewModel.singUp(
                            username.value,
                            email.value,
                            password1.value,
                            password2.value
        //                    navController = navController
                        )
                    },
                modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                ClickableText(
                    text = buildAnnotatedString {
                        append("Already have an account?")

                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary,
                                fontWeight = FontWeight.Bold
                            )
                        ){
                            append("Log in")
                        }
                    },
                    onClick = {
           //             onBack()
                        navController.navigate("login"){
//                            popUpTo("main/home") { inclusive = true }
                       //     launchSingleTop = true
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )

                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "OR",
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.Black
                        )
                    )

                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login with",
                    style = MaterialTheme.typography.body1.copy(
                        MaterialTheme.colors.primary
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

          Text(text = state.error,color = MaterialTheme.colors.primary)

            //Text(text = "${state.response?.us}",color = MaterialTheme.colors.primary)


        }

//        if(state.errorMessage != null) {
//            EventDialog(errorMessage = state.errorMessage, onDismiss = { viewModel.hideErrorDialog() })
//        }
    }
}
