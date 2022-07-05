package com.example.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FilterRow(
    openFilter:()->Unit,
    chooseOptionFilter:() ->Unit,
    chooseOptionSorted: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    chooseOptionFilter()
                openFilter()
            }
        ) {
            Text(
                text = "Filters",
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "FilterArrowDown")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                chooseOptionSorted  ()
                openFilter()
            }
        ) {
            Text(
                text = "Sorted By",
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "SortedArrowDown")
        }

    }
}