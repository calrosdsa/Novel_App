package com.example.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import kotlinx.coroutines.launch

@Composable
fun CustomDropDownMenu(
    listValue:List<String>,
    mSelectedText:String,
    mSelectedTextValue: (String)->Unit,
    mExpanded:Boolean,
    mExpandedValue: (Boolean)->Unit,
    mTextFieldSizeValue: (Size)->Unit,
    mTextFieldSize:Size

){

    // Create a list of cities

    // Create a string value to store the selected city

    //var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(modifier = Modifier.fillMaxSize()) {
        Column() {
            OutlinedTextField(
                value = mSelectedText,
                onValueChange = { mSelectedTextValue(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSizeValue(coordinates.size.toSize())
                    },
                label = { Text("Label") },
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable { mExpandedValue(!mExpanded)})
                }
            )

            // Create a drop-down menu with list of cities,
            // when clicked, set the Text Field text as the city selected
            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpandedValue(false) },
                modifier = androidx.compose.ui.Modifier
                    .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
            ) {
                listValue.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedTextValue(label)
                        mExpandedValue(false)
                    }) {
                        Text(text = label)
                    }
                }
            }


        }
}
}
