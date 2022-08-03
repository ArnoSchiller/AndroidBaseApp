package de.byschiller.androidbaseapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.byschiller.androidbaseapp.navigation.NavRoutes

@Composable
fun NavigationContainer() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {

        composable(NavRoutes.Home.route) {
            Home(navController = navController)
        }

        // handle parameters passed during navigation
        composable(NavRoutes.Greeting.route + "/{userName}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            Greeting(navController = navController, userName)
        }
    }
}