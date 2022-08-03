package de.byschiller.androidbaseapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import de.byschiller.androidbaseapp.Greeting
import de.byschiller.androidbaseapp.Home
import de.byschiller.androidbaseapp.login.navigation.loginGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationContainer() {

    val navItems = listOf(
        NavRoutes.Greeting,
        NavRoutes.Home,
        NavRoutes.Login
    )

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                navItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.title)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
            Modifier.padding(innerPadding)
        ) {
            val uri = "https://www.example.com"

            composable(NavRoutes.Home.route) {
                Home(navController = navController)
            }
            composable( route = NavRoutes.Greeting.route) {
                Greeting(navController = navController, "test")
            }


            ////// passing parameters is not compatible with the BottomAppBar
            // handle parameters passed during navigation
            // version 1 using route
            /*
            composable( route = NavRoutes.Greeting.route + "/{username}",
                deepLinks = listOf(navDeepLink { uriPattern = "$uri/{username}" }),
                arguments = listOf(navArgument("username") { defaultValue = "me" })
            ) { backStackEntry ->

                val username = backStackEntry.arguments?.getString("userName")
                Greeting(navController = navController, username)
            }
             */
            // version 2 using query
            // this provides a default value, parameter of view must not be nullable
            /*
            composable(
                route = NavRoutes.Greeting.route + "?username={username}",
                deepLinks = listOf(navDeepLink { uriPattern = "$uri/{username}" }),
                arguments = listOf(navArgument("username") { defaultValue = "me" })
            ) { backStackEntry ->

                val userName = backStackEntry.arguments?.getString("username")
                Greeting(navController = navController, userName)
            }
            */

            // include navigation graphs
            loginGraph(navController)
        }
    }
}