package com.example.bookmark.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkRemove
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.local.entities.FollowingEntity

@Composable
fun DialogBookMark(
    visible:Boolean,
    setVisible:(Boolean)->Unit,
    item: FollowingEntity,
    setOption:(Int, Int)->Unit,
    removeNovel:(Int,String)->Unit,
){

    if(visible){

        Dialog(onDismissRequest = { setVisible(false) }) {
            Column(modifier= Modifier
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                //.fillMaxHeight(0.56f)
                .padding(10.dp)
            ) {
                Text(text = "Library Command",style= MaterialTheme.typography.subtitle1)
                Divider(modifier = Modifier.padding(vertical = 6.dp))
                Text(text = " ${item.title}", style = MaterialTheme.typography.h6.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colors.primary
                ),maxLines = 1)
                Spacer(modifier = Modifier.height(15.dp))
                RowOptionLibrary(
                    title =if(item.options.contains(2)) "I have not completed it yet"
                    else "I have completed this book",
                    IconRow = if(item.options.contains(2)) Icons.Outlined.LocalLibrary else Icons.Default.Flag,
                    setOption = {
                        item.id?.let { setOption(it,2) }
                        setVisible(false)
                    }

                )
                RowOptionLibrary(title = if(item.options.contains(3))"Remove Favorite" else "Add to Favorite",
                    IconRow = Icons.Default.Star,setOption = {
                        item.id?.let { setOption(it,3) }
                        setVisible(false)

                    }
                )
                RowOptionLibrary(title = "Remove from Library", IconRow = Icons.Outlined.BookmarkRemove,
                    setOption = {
                        item.id?.let { removeNovel(it,item.title) }
                        setVisible(false)
                    }
                )
            }
        }
    }
}

