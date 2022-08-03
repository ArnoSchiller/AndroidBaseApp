package de.byschiller.androidbaseapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import de.byschiller.androidbaseapp.navigation.NavRoutes

@Composable
fun NavigationContainer() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        val uri = "https://www.example.com"

        composable(NavRoutes.Home.route) {
            Home(navController = navController)
        }

        // handle parameters passed during navigation
        // version 1 using route
        /*
        composable(NavRoutes.Greeting.route + "/{userName}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            Greeting(navController = navController, userName)
        }
        */
        // version 2 using query
        // this provides a default value, parameter of view must not be nullable
        composable(
            route = NavRoutes.Greeting.route + "?username={username}",
            deepLinks = listOf(navDeepLink { uriPattern = "$uri/{username}" }),
            arguments = listOf(navArgument("username") { defaultValue = "me" })
        ) { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("username")
            Greeting(navController = navController, userName)
        }

    }
}