package com.example.discover

import com.example.api.UiMessage
import com.example.data.dto.browse.BrowseDto
import com.example.data.local.entities.CategoryEntity

data class DiscoverState(
  //  val browse: BrowseDto? = null,
    val categoryEntity: List<CategoryEntity>? = emptyList(),
    val loading:Boolean = false,
    val message:UiMessage? = null,
)

data class FilterState(
    val status:Int? = null,
    val ordering:String ="-popular",
    val category:Int? = null,
)

sealed class SortedOptions(val ordering:String,val title:String)
object Created:SortedOptions("-created","New")
object Updated:SortedOptions("-updated","Updated")
object Popular:SortedOptions("-popular","Popular")


sealed class StatusOptions(val id:Long,val title: String)
object All:StatusOptions( 0L,"All")
object Ongoing:StatusOptions(2L,"Ongoing")
object Completed:StatusOptions(3L,"Completed")

val sortedOptions= listOf(Created,Updated,Popular)
val statusOptions = listOf(All,Ongoing,Completed)