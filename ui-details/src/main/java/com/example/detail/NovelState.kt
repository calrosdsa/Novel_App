package com.example.detail

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.CloudDownload
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.data.dto.novel.NovelDetailDto
import com.example.data.dto.chapters.NovelChaptersDto
import com.example.data.dto.reviews.ReviewsDto

data class NovelState(
    val is_loading:Boolean = false,
    val novel: NovelDetailDto? = null,
    val currentId:Int = 0,
    val error:String = ""
)

data class NovelChaptersState(
    val chapters:NovelChaptersDto? =  null,
    val is_loading:Boolean = false,
    val error:String = ""
)

data class NovelReviewsState(
    val reviews:ReviewsDto? = null,
    val is_loading: Boolean = false,
    val error: String= ""
)

sealed class BottomItem(
    @StringRes val labelResId: Int,
    @StringRes val contentDescriptionResId: Int,
) {
    class ImageVectorIcon(
        @StringRes labelResId: Int,
        @StringRes contentDescriptionResId: Int,
        val iconImageVector: ImageVector,
    ) : BottomItem( labelResId, contentDescriptionResId)
}


val listOfBottomItems = listOf(
    BottomItem.ImageVectorIcon(
        labelResId = R.string.download,
        contentDescriptionResId = R.string.download,
        iconImageVector = Icons.Outlined.CloudDownload,
    ),
    BottomItem.ImageVectorIcon(
        labelResId = R.string.read_now,
        contentDescriptionResId = R.string.read_now,
        iconImageVector = Icons.Outlined.Book
    ),
    BottomItem.ImageVectorIcon(
        labelResId = R.string.add_to,
        contentDescriptionResId = R.string.add_to,
        iconImageVector = Icons.Outlined.AddCircle
    )

)
