package com.example.data.local.entities

interface NovelEntity {
    val id:Long
}

interface Entry : NovelEntity {
    val novelId: Long
}


interface PaginatedEntry : Entry {
    val page: Int
}


interface NovelImage : NovelEntity {
    val path: String
    val type: ImageType
    val language: String?
    val rating: Float
    val isPrimary: Boolean
}

enum class ImageType(val storageKey: String) {
    BACKDROP("backdrop"),
    POSTER("poster"),
    LOGO("logo"),
}

internal fun <T : NovelImage> Collection<T>.findHighestRatedPoster(): T? {
    if (size <= 1) return firstOrNull()
    @Suppress("DEPRECATION") // Can't use maxByOrNull until we're API version 1.4
    return filter { it.type == ImageType.POSTER }
        .maxByOrNull { it.rating + (if (it.isPrimary) 10f else 0f) }
}

internal fun <T : NovelImage> Collection<T>.findHighestRatedBackdrop(): T? {
    if (size <= 1) return firstOrNull()
    @Suppress("DEPRECATION") // Can't use maxByOrNull until we're API version 1.4
    return filter { it.type == ImageType.BACKDROP }
        .maxByOrNull { it.rating + (if (it.isPrimary) 10f else 0f) }
}
