package com.github.almasud.rick_and_morty.ui.screens.character_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.almasud.rick_and_morty.domain.model.Character
import com.github.almasud.rick_and_morty.domain.repo.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsVM @Inject constructor(
    private val characterRepo: CharacterRepo
) : ViewModel() {
    val character: MutableState<Character?> = mutableStateOf(null)

    fun getCharacterById(id: Long) = viewModelScope.launch {
        character.value = characterRepo.getCharacterById(id = id)
    }
}
