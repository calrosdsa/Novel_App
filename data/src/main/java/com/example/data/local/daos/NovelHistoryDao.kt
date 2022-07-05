package com.example.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.local.entities.HistoryNovelEntity
import com.example.data.resultentities.HistoryDetailed
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NovelHistoryDao: EntityDao<HistoryNovelEntity>() {
    @Query("SELECT * FROM novel_history WHERE id = :id")
    abstract fun getNovelWithIdFlow(id: Long): Flow<HistoryNovelEntity>

    @Transaction
    @Query("SELECT * FROM novel_history WHERE id = :id")
    abstract suspend fun getHistoryWithIdDetailed(id: Long): HistoryDetailed?

    @Transaction
    @Query("SELECT * FROM novel_history WHERE id = :id")
    abstract fun getHistoryDetailedWithIdFlow(id: Long): Flow<HistoryDetailed>

    @Query("SELECT * FROM novel_history WHERE id = :id")
    abstract suspend fun getShowWithId(id: Long): HistoryNovelEntity?

    suspend fun getShowWithIdOrThrow(id: Long): HistoryNovelEntity {
        return getShowWithId(id)
            ?: throw IllegalArgumentException("No show with id $id in database")
    }

//    @Query("SELECT trakt_id FROM shows WHERE id = :id")
//    abstract suspend fun getTraktIdForShowId(id: Long): Int?
//
//    @Query("SELECT tmdb_id FROM shows WHERE id = :id")
//    abstract suspend fun getTmdbIdForShowId(id: Long): Int?

//    @Query("SELECT id FROM novel_history WHERE id = :traktId")
//    abstract suspend fun getIdForTraktId(traktId: Int): Long?
//
//    @Query("SELECT id FROM shows WHERE tmdb_id = :tmdbId")
//    abstract suspend fun getIdForTmdbId(tmdbId: Int): Long?

    @Query("DELETE FROM novel_history WHERE id = :id")
    abstract suspend fun delete(id: Long)

    @Query("DELETE FROM novel_history")
    abstract suspend fun deleteAll()

    suspend fun getIdOrSavePlaceholder(show: HistoryNovelEntity):Long {
        return insert(show)
//        val idForTraktId: Long? = if (show.traktId != null) getIdForTraktId(show.traktId) else null
//        val idForTmdbId: Long? = if (show.tmdbId != null) getIdForTmdbId(show.tmdbId) else null

//        if (idForTraktId != null && idForTmdbId != null) {
//            return if (idForTmdbId == idForTraktId) {
//                // Great, the entities are matching
//                idForTraktId
//            } else {
//                val showForTmdbId = getShowWithIdOrThrow(idForTmdbId)
//                val showForTraktId = getShowWithIdOrThrow(idForTraktId)
//                deleteEntity(showForTmdbId)
//                return insertOrUpdate(mergeShows(showForTraktId, showForTraktId, showForTmdbId))
//            }
//        }

//        if (idForTraktId != null) {
//            // If we get here, we only have a entity with the trakt id
//            return idForTraktId
//        }
//        if (idForTmdbId != null) {
//            // If we get here, we only have a entity with the tmdb id
//            return idForTmdbId
//        }

        // TODO add fuzzy search on name or slug

    }
}