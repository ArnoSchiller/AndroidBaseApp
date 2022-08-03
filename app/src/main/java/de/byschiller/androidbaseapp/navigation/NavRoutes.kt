package de.byschiller.androidbaseapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.ui.graphics.vector.ImageVector
import de.byschiller.androidbaseapp.R
import de.byschiller.androidbaseapp.login.navigation.LoginNavRoutes

sealed class NavRoutes(val route: String, val title: Int, val icon: ImageVector) {
    object Home : NavRoutes("home", R.string.home_title, Icons.Filled.Home)
    object Greeting : NavRoutes("greeting", R.string.greeting_title, Icons.Filled.Hearing)

    object Login : NavRoutes(LoginNavRoutes.baseRoute,R.string.login, Icons.Filled.SupervisedUserCircle)
}
