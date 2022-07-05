package com.example.data.local.daos

import com.example.data.local.entities.Entry
import com.example.data.resultentities.EntryWithHistoryNovels

abstract class EntryDao<EC : Entry, LI : EntryWithHistoryNovels<EC>> : EntityDao<EC>() {
    abstract suspend fun deleteAll()
}