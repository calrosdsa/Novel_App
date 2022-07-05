package com.example.bookmark.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmark.FilterOption
import com.example.domain.util.NovelOrder
import com.example.domain.util.OrderType

@Composable
fun BottomSheetBookMark(
    item:FilterOption,
    setOption:(Int)->Unit,
    closeSheet:()->Unit,
    setOrdering:(NovelOrder)->Unit,
    currentOption:Int,
    currentOrder:NovelOrder,
){
        Column(Modifier.padding(14.dp)) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .background(MaterialTheme.colors.surface)
                    .padding(horizontal = 13.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        closeSheet()
                    }
                ,
                contentDescription = "DescriptionArrow"
            )
            Text(text = item.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(10.dp))
            item.values.mapIndexed {index,it->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = it, style = MaterialTheme.typography.h6.copy(
                        fontSize = 17.sp
                    ))
                    if(item.isOrderType){
                        RadioButton(
                            selected = item.listNovelOrder?.get(index) == currentOrder,
                            onClick = {
                                    if(index == 0){
                                        setOrdering(NovelOrder.Added)
                                    }else{
                                        setOrdering(NovelOrder.Updated)
                                    }
                            }
                        )
                    }else{

                    RadioButton(
                        selected = index == currentOption,
                        onClick = {
                            setOption(index)
                            closeSheet()
                        }
                    )
                    }
                }
            }



        }
}