package de.byschiller.androidbaseapp.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import de.byschiller.androidbaseapp.login.presentation.LoginPasswordScreen
import de.byschiller.androidbaseapp.login.presentation.LoginUsernameScreen


fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = LoginNavRoutes.Username.route,
        route = LoginNavRoutes.baseRoute
    ) {
        composable(LoginNavRoutes.Username.route) { LoginUsernameScreen(navController) }
        composable(LoginNavRoutes.Password.route) { LoginPasswordScreen(navController) }
    }
}