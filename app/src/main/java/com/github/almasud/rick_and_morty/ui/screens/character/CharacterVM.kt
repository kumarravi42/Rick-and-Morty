package com.github.almasud.rick_and_morty.ui.screens.character

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.almasud.rick_and_morty.App
import com.github.almasud.rick_and_morty.data.db.AppDatabase
import com.github.almasud.rick_and_morty.data.repo.paging_source.CharacterRemoteMediator
import com.github.almasud.rick_and_morty.domain.model.Character
import com.github.almasud.rick_and_morty.domain.repo.CharacterRepo
import com.github.almasud.rick_and_morty.ui.NavItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharacterVM @Inject constructor(
    private val characterRepo: CharacterRepo,
    private val app: Application
) : ViewModel() {
    lateinit var navigateTo: (navRoute: String, singleTopMode: Boolean, restoreSaveState: Boolean) -> Unit
    lateinit var characters: Flow<PagingData<Character>>
    private var database: AppDatabase = AppDatabase.getInstance(app)

    fun showProfileScreen(character: Character) {
        navigateTo(
            "${NavItem.CharacterDetails.route}/${App.Constant.Navigation.Argument.CHARACTER_ID}=${character.id}&${App.Constant.Navigation.Argument.CHARACTER_NAME}=${character.name}",
            true, false
        )
    }

    @OptIn(ExperimentalPagingApi::class)
    fun loadCharacters() {
        Timber.d("loadCharacters: is called")
        characters = Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = CharacterRemoteMediator(
                characterRepo,
                AppDatabase.getInstance(app)
            ),
            pagingSourceFactory = { database.characterDao().getCharacters() }
        ).flow.cachedIn(viewModelScope)
    }

    init {
        viewModelScope.launch {
            loadCharacters()
        }
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }

}
