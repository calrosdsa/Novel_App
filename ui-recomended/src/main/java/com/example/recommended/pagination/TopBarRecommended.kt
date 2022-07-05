package com.example.recommended.pagination

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarRecommended(
    onExit: (String) -> Unit,
    navToSearchPage:()->Unit,
){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(Modifier.padding(start = 10.dp)) {
            Text(text = "SPECIALLY FOR YOU", style = MaterialTheme.typography.caption.copy(fontSize = 11.sp))
            Text(text = "Recommended", style = MaterialTheme.typography.h6)
        }
//            Spacer(modifier = Modifier.width(100.dp))
        Row(Modifier.offset(x = 7.dp)) {
            IconButton(onClick = { navToSearchPage() }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon R.",
                modifier = Modifier
                    .padding(10.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray.copy(alpha = 0.3f))
            )
            }
            IconButton(onClick = { onExit("main/home") }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close Icon R.",
                modifier = Modifier
                    .padding(10.dp)
                    .size(32.dp)
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp))
                    .background(Color.LightGray.copy(alpha = 0.3f))
            )
            }

        }
    }
}