package com.example.compose.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TransparentTextField(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    textLabel: String,
    maxChar: Int? = null,
    error:Boolean = false,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    keyboardType: KeyboardType,
    keyboardActions: KeyboardActions,
    imeAction: ImeAction,
    trailingIcon: @Composable() (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue.value.take(maxChar ?: 40),
        onValueChange = { textFieldValue.value = it },
        label = {
            Text(text = textLabel,color = MaterialTheme.colors.primary)
        },
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.onPrimary,
            //unfocusedIndicatorColor = MaterialTheme.colors.surface,
            unfocusedIndicatorColor = if(error) Color.Red else MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high)
        )

    )
}