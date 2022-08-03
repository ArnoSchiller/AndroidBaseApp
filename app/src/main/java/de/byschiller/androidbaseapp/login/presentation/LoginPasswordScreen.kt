package de.byschiller.androidbaseapp.login.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import de.byschiller.androidbaseapp.login.navigation.LoginNavRoutes
import de.byschiller.androidbaseapp.navigation.NavRoutes

@Composable
fun LoginPasswordScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "This is ${stringResource(id = LoginNavRoutes.Password.title)}!")


            Button(onClick = { navController.navigate(NavRoutes.Home.route) }) {
                Text(text = "Go to ${stringResource(id = NavRoutes.Home.title)}")
            }
        }
    }
}