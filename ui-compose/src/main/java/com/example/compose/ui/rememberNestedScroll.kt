package com.example.compose.ui

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Velocity
import kotlin.math.abs

@Composable
fun rememberNestedScroll(
  //  onOffsetChanged:(Float)->Unit
    floatValue: MutableState<Float>,
    bottomBarOffset: MutableState<Float>,
    bottomBarHeightPx :Float,
    listState: LazyListState
) = remember {
    //var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            val newTopBarHeigth = bottomBarOffset.value - delta/2
            bottomBarOffset.value = newTopBarHeigth.coerceIn(0f,bottomBarHeightPx)
           // if(listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1){
             //   return Offset.Zero
           // }
            if(listState.firstVisibleItemIndex < 2 ){
            Log.d("AVAILABLE22","${available.y}")
            val newAlphaValue = floatValue.value + delta/410
            floatValue.value = newAlphaValue.coerceIn(0f,1f)
            }

            return Offset.Zero
        }

    //    override suspend fun onPreFling(available: Velocity): Velocity {
      //      if(available.y<0){
        //        onOffsetChanged(0f)
          //  }else{
        //        onOffsetChanged(appBarHeight)
          //  }
        //    return super.onPreFling(available)
   //     }
    }
}

@Composable
fun rememberNestedScrollFloatingButton(
    barOffset: MutableState<Float>,
    barHeight :Float,
) = remember {
    //var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            Log.d("DELTA" , delta.toString())
            val newTopBarHeigth = barOffset.value - delta
            barOffset.value = newTopBarHeigth.coerceIn(0f,barHeight.minus(55f))

            // if(listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1){
            //   return Offset.Zero
            // }
            return Offset.Zero
        }
    }
}