package com.github.terrakok.cicerone.compose

import com.github.terrakok.cicerone.Screen

interface ComposeScreen : Screen {
    val route: String

    companion object {
        operator fun invoke(route: String) = object : ComposeScreen {
            override val route = route
            override val screenKey = route
        }
    }
}