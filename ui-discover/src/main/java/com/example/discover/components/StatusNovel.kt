package com.example.discover.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.discover.statusOptions

@Composable
internal fun StatusNovel(
    setStatus:(Int)->Unit,
    currentStatus:Int?,
) {

    Row() {
    statusOptions.map {
        BoxSelectOption(id = it.id, title =it.title,current = currentStatus?:0,
            setCategory = {status-> setStatus(status) }
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
    }
}