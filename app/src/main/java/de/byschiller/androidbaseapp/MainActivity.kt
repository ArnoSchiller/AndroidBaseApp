package de.byschiller.androidbaseapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import de.byschiller.androidbaseapp.login.navigation.LoginNavRoutes
import de.byschiller.androidbaseapp.navigation.NavRoutes
import de.byschiller.androidbaseapp.navigation.NavigationContainer
import de.byschiller.androidbaseapp.ui.theme.AndroidBaseAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var simpleString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("DI", simpleString)
        setContent {
            AndroidBaseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationContainer()
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "This is ${stringResource(id = NavRoutes.Home.title)}!")

            // pass parameter to route
            Button(onClick = {
                // version 1
                navController.navigate(NavRoutes.Greeting.route + "/exampleName")
                // version 2
                //navController.navigate(NavRoutes.Greeting.route + "?username=exampleName")
            }) {
                Text(text = "Go to ${stringResource(id = NavRoutes.Greeting.title)}")
            }

            // test navGraph
            Button(onClick = {
                navController.navigate(LoginNavRoutes.Username.route)
            }) {
                Text(text = "Go to ${stringResource(id = LoginNavRoutes.Username.title)}")
            }
        }
    }
}

@Composable
fun Greeting(navController: NavHostController, name: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "This is ${stringResource(id = NavRoutes.Greeting.title)}!")

            Text(text = "Hello $name!")

            Button(onClick = { navController.navigate(NavRoutes.Home.route) }) {
                Text(text = "Go to ${stringResource(id = NavRoutes.Home.title)}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidBaseAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavigationContainer()
        }
    }
}