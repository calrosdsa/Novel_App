package com.example.compose.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonOptions(
    Items:List<String>,
    modifier: Modifier = Modifier
){
    Row() {
    Items.forEach{
        Button(
            modifier = modifier,
            onClick = { /*TODO*/ }) {
            Text(text = it, style = MaterialTheme.typography.h6.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight.Black
            ))
        }
            Spacer(modifier = Modifier.width(20.dp))
    }

    }
}

@Composable
fun ButtonOptionsBox(
    text:String,
    modifier: Modifier = Modifier,
    check:Boolean,
    setCheck:() -> Unit,
){
    //Row() {

    //    Items.forEach{
            Box(modifier = modifier){
                Row(horizontalArrangement = if (check) Arrangement.SpaceBetween else Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)) {
          RadioButton(selected = check, onClick = { setCheck() })
                Text(text = text, style = MaterialTheme.typography.h6.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                ))
                }
    }
}