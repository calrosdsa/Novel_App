package com.example.discover.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.data.dto.novel.Category
import com.example.data.local.entities.CategoryEntity
import com.google.accompanist.flowlayout.FlowRow

@Composable
internal fun GenreCategoryList(
    categories:List<CategoryEntity>,
    setCategory:(Int)->Unit,
    currentCategory:Int?,
//    isCategorySelected:Boolean
){
//    val all = CategoryEntity(
//        id = 0L,
//        title= "All"
//    )
//    val newCategoryList =  categories.plus(all).sortedBy { it.id }

  Row(modifier = Modifier.horizontalScroll(rememberScrollState()).height(125.dp)){
  //        items(
    //          items = categories,
      //        key = {
        //          it.id
          //    },
//              itemContent = { category->
      FlowRow(
          crossAxisSpacing = 10.dp,
          mainAxisSpacing = 10.dp,
          modifier = Modifier.width(700.dp),
      ) {
                 categories.map{category->
                 BoxSelectOption(
                     setCategory ={ setCategory(it) },
                     id = category.id,
                     title = category.title,
                     current = currentCategory?:0
                 )

                  }
      }
  }
}

@Composable
internal fun BoxSelectOption(
    setCategory: (Int) -> Unit,
    id:Long,
    title:String,
    current:Int = 0
){
    Box(modifier = Modifier
        .clip(MaterialTheme.shapes.small)
        .background(
            if (id == current.toLong()) MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(
                alpha = 0.65f
            )
        )
        .padding(8.dp)
        .clickable { setCategory(id.toInt()) }
    ){
        Text(text = title, style = MaterialTheme.typography.caption)
    }
}