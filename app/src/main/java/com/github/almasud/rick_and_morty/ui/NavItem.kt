package com.github.almasud.rick_and_morty.ui

import androidx.annotation.StringRes
import com.github.almasud.rick_and_morty.R

sealed class NavItem(
    @StringRes val title: Int,
    val route: String
) {
    object Character : NavItem(R.string.character, "character")
    object CharacterDetails : NavItem(R.string.character_details, "character_details")
}