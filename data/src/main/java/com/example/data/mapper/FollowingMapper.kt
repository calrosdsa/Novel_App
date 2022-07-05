package com.example.data.mapper

import com.example.data.dto.library.Result
import com.example.data.local.entities.FollowingEntity

fun Result.toFollowingEntity():FollowingEntity{
    return  FollowingEntity(
        id = id,
     chapters = chapters,
     options = options,
     progress = progress,
     slug = slug,
     title = title,
     updated = updated,
    added = added
    )
}