package com.github.almasud.rick_and_morty.data.di

import android.content.Context
import com.github.almasud.rick_and_morty.data.db.CharacterDao
import com.github.almasud.rick_and_morty.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context) : AppDatabase =
        AppDatabase.getInstance(context = context)
    @Provides
    fun providesCharacterDao(appDatabase: AppDatabase) : CharacterDao = appDatabase.characterDao()
}
