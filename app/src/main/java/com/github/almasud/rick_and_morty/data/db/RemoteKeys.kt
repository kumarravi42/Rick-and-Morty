package com.github.almasud.rick_and_morty.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey
    val characterId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
