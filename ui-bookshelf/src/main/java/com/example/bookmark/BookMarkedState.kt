package com.example.bookmark

import androidx.lifecycle.MediatorLiveData
import com.example.api.UiMessage
import com.example.domain.util.NovelOrder
import com.example.data.local.entities.FollowingEntity
import com.example.data.resultentities.ChapterAndNovelImage


data class FollowingState(
    val loading:Boolean = false,
    val followings:List<FollowingEntity>? = emptyList(),
    val option:Int = 0,
    val ordering: NovelOrder? = NovelOrder.Updated,
    val filterType: FilterOption? =FilterOption.Filter,
    val currentItem:FollowingEntity? = null,
    val message: UiMessage? = null,
)

data class DownLoadChapterState(
    val chapters:List<ChapterAndNovelImage> = emptyList(),
    val message: UiMessage? = null,
    val loading:Boolean = false,

)

sealed class FilterOption(
    val values:List<String>,
    val title: String,val isOrderType:Boolean = false,
    val listNovelOrder: List<NovelOrder>? = emptyList(),
){
    object Filter:FilterOption(
        listOf("All","Updated","Completed","Favorites"),
        "Filter By",
    )
    object Sorted:FilterOption(
        listOf("Last Added" , "Last Updated"),
        "Sorted By",
        true,
        listOf(NovelOrder.Added,NovelOrder.Updated),
    )
}

sealed class Results<out R>{
    data class Success<out T>(val data:T): Results<T>()
    data class Error(val exception: java.lang.Exception): Results<Nothing>()
    object Loading : Results<Nothing>()
}

val Results<*>.succeeded
    get() =  this is Results.Success && data != null

fun <T> Results<T>.successOr(fallback:T):T{
    return (this as? Results.Success<T>)?.data ?: fallback
}

interface FeedRepository{
    //fun getFeeds() :LiveData<List<Feed>>
}

abstract class UseCase<in P, R> {
    protected val result = MediatorLiveData<Results<R>>()
    open fun observe(): MediatorLiveData<Results<R>> {
        return result
    }
    abstract fun execute(parameters:P)
}

open class GetFeedsUseCase





