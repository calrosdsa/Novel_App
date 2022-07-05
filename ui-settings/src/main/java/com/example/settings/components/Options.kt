package com.example.settings.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun RowOption(
    title:String,
    subtitle:String,
    showDialog:(Boolean)->Unit,
    modifier:Modifier = Modifier
){
    Column(modifier = modifier
        .padding(vertical = 7.dp)
        .fillMaxWidth()
        .clickable { showDialog(true) }) {
        Text(text =  title,style= MaterialTheme.typography.h6,modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp))
        Text(text = subtitle,style= MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.primary,modifier = Modifier
            .fillMaxWidth()
           )

    }
}