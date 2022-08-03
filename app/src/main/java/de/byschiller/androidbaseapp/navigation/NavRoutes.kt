package de.byschiller.androidbaseapp.navigation

import de.byschiller.androidbaseapp.R

sealed class NavRoutes(val route: String, val title: Int) {
    object Home : NavRoutes("home", R.string.home_title)
    object Greeting : NavRoutes("greeting", R.string.greeting_title)
}