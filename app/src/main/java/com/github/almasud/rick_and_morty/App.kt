package com.github.almasud.rick_and_morty

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // For Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    object Constant {
        object Navigation {
            object Graph {
                const val HOME_GRAPH = "home_graph"
            }

            object Argument {
                const val CHARACTER_ID = "character_id"
                const val CHARACTER_NAME = "character_name"
            }
        }

        object Api {
            const val BASE_URL = "https://rickandmortyapi.com/"
        }
    }
}