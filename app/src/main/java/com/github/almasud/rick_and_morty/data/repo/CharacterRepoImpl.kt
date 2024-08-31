package com.github.almasud.rick_and_morty.data.repo

import com.github.almasud.rick_and_morty.data.api.CharacterApiService
import com.github.almasud.rick_and_morty.data.api.resposne.NetworkResult
import com.github.almasud.rick_and_morty.data.api.resposne.model.CharactersResponse
import com.github.almasud.rick_and_morty.data.db.CharacterDao
import com.github.almasud.rick_and_morty.domain.model.Character
import com.github.almasud.rick_and_morty.domain.repo.CharacterRepo
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(
    private val apiService: CharacterApiService,
    private val characterDao: CharacterDao
) : CharacterRepo {
    override suspend fun getCharacters(page: Int): NetworkResult<CharactersResponse> =
        NetworkResult.handleRestApiResponse {
            apiService.getCharacters(page = page)
        }

    override suspend fun getCharacterById(id: Long): Character =
        characterDao.getCharacterById(id = id)
}