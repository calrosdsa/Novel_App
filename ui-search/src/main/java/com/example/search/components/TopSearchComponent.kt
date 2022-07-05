package com.example.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopSearchComponent(
    value:String,
    onChangeValue:(TextFieldValue)->Unit,
    navBack:()->Unit,
){
    Row( modifier = Modifier
        .background(MaterialTheme.colors.surface)
        .padding(horizontal = 10.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    navBack()
                },
            contentDescription = "SearchArrowBack")
        TextField(value = value, onValueChange ={ onChangeValue(TextFieldValue(it))},
            placeholder ={ Text(text = "Search for stories",
                style = MaterialTheme.typography.h6.copy(
                    fontSize = 18.sp,
                    color = Color.LightGray.copy(
                        ContentAlpha.disabled
                    )
                )
            ) },
            maxLines=1,
            modifier = Modifier.fillMaxWidth(0.92f),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                unfocusedIndicatorColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = MaterialTheme.colors.surface,
            )
        )
        if(value.isNotBlank()){
            Icon(imageVector = Icons.Default.Close, contentDescription ="XIconCleanSearch" ,
                modifier = Modifier.clickable {
                    onChangeValue(TextFieldValue())
                }
            )
        }
    }
    Divider(color = MaterialTheme.colors.primaryVariant)
}