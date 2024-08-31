package com.github.almasud.rick_and_morty.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.almasud.rick_and_morty.domain.model.Character

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<Character>)

    @Query("SELECT * FROM characters")
    fun getCharacters(): PagingSource<Int, Character>

    @Query("SELECT * FROM characters WHERE id=:id")
    suspend fun getCharacterById(id: Long): Character

    @Query("DELETE FROM characters")
    suspend fun clearCharacters()
}
