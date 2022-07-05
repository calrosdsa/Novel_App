package com.example.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.local.entities.HistorySearchEntity
import com.example.novels.MainDestination

@Composable
fun HistorySearchComponent(
    history:List<HistorySearchEntity>,
    deleteAll:(List<HistorySearchEntity>) -> Unit,
    deleteAlert:Boolean,
    activeAlert:(Boolean)->Unit
){
    Column() {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "History", style = MaterialTheme.typography.h6)
            Icon(imageVector = Icons.Outlined.DeleteOutline,
                contentDescription = "DeleteHistory",
                modifier = Modifier.clickable {
                    activeAlert(!deleteAlert)
                }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(){
            items(
                items = history,
                key = {item ->
                    item.title
                },
                //contentType = {comment -> comment.id},
                itemContent = {
                     Text(
                         text = it.title,
                         modifier = Modifier
                             .clip(MaterialTheme.shapes.medium)
                             .background(MaterialTheme.colors.primaryVariant)
                             .padding(8.dp),
                         style = MaterialTheme.typography.caption
                     )
                    Spacer(modifier = Modifier.width(9.dp))
                }
            )
        }

    }

    if(deleteAlert){
        Dialog(onDismissRequest = { activeAlert(false) }) {
            Column(modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(20.dp)
            ) {
                Text(
                    text = "Confirm deletion of Search history?",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(color=MaterialTheme.colors.primaryVariant)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(0.5f)) {
                        Text(
                            text = "Discard", style = MaterialTheme.typography.h6.copy(
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center).padding(10.dp)
                        )
                    }
                    Divider(
                        color=MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .height(38.dp)
                            .width(1.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth(0.5f)
                        .clickable {
                            deleteAll(history)
                            activeAlert(false)
                        }
                    ) {
                        Text(
                            text = "Sure", style = MaterialTheme.typography.h6.copy(
                                fontSize = 18.sp
                            ),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.align(Alignment.Center).padding(10.dp)
                        )
                    }
                }

            }
        }
    }
}