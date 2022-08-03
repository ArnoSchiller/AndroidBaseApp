package de.byschiller.androidbaseapp.login.navigation

import de.byschiller.androidbaseapp.R

sealed class LoginNavRoutes(val route: String, val title: Int) {

    companion object {
        const val baseRoute = "login"
    }

    val absoluteRoute: String = "$baseRoute/$route"
    object Username : LoginNavRoutes("username", R.string.username_title)
    object Password : LoginNavRoutes("password", R.string.password_title)
}