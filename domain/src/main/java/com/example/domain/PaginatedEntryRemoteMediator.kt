
package com.example.domain

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.data.local.entities.HistoryNovelEntry
import com.example.data.local.entities.PaginatedEntry
import com.example.data.resultentities.EntryWithHistoryNovels
import com.example.data.resultentities.HistoryEntryWithNovels
import kotlinx.coroutines.delay

/**
 * A [RemoteMediator] which works on [PaginatedEntry] entities. [fetch] will be called with the
 * next page to load.
 */
@OptIn(ExperimentalPagingApi::class)
class PaginatedEntryRemoteMediator<LI, ET>(
    private val fetch: suspend (page: Int) -> Unit
) : RemoteMediator<Int, LI>() where ET : PaginatedEntry, LI : EntryWithHistoryNovels<ET> {
    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, LI>
    ): MediatorResult {
        val nextPage = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> null
            LoadType.APPEND -> {
                val lastItem = getRemoteKeyForLastItem(state)
                    ?: return MediatorResult.Success(endOfPaginationReached = true)
                lastItem
            }
        }
        return try {
           if (nextPage != null) {
                fetch(nextPage)
            }
            MediatorResult.Success(endOfPaginationReached = false)
        } catch (t: Throwable) {
            MediatorResult.Error(t)
        }
    }

    private fun getRemoteKeyForLastItem(state: PagingState<Int, LI>): Int? {
        // Get the last page that was retrieved, that contained items.
        // From that last page, get the last item
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.entry?.page?.let {
                it + 1
            }
    }

    private fun getRemoteKeyForFirstItem(state: PagingState<Int, LI>): Int? {
        // Get the first page that was retrieved, that contained items.
        // From that first page, get the first item
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.entry?.page
    }

    private fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, LI>
    ): Int? {
        // The paging library is trying to load data after the anchor position
        // Get the item closest to the anchor position
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.entry?.page?.let {
                it + 1
            }
        }
    }

}