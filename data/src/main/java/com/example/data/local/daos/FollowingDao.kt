package com.example.data.local.daos

import androidx.room.*
import com.example.data.local.entities.FollowingEntity
import kotlinx.coroutines.flow.Flow
import okhttp3.internal.notify

@Dao
interface FollowingDao {
    //@Query("SELECT * FROM following_novels WHERE id IN(:list)")
    @Query("SELECT * FROM following_novels")
    fun getAllFollowings(
    //    list: List<Int> = listOf(0,1,2,3)
    ): Flow<List<FollowingEntity>>
    @Query("SELECT id FROM following_novels")
    fun getAllNovelIds():Flow<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFollowings(followings: List<FollowingEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFollowing(followings:FollowingEntity )


    @Query("DELETE FROM following_novels WHERE title = :novelId")
    suspend fun deleteNovel(novelId:String)

    @Query("DELETE FROM following_novels WHERE id = :id")
    suspend fun deleteNovelById(id:Int)

    @Query("DELETE FROM following_novels")
    suspend fun deleteAll()



}