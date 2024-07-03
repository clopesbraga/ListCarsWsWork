package br.com.wsworks.listcarswswork.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.wsworks.listcarswswork.ui.screens.DetailScreen
import br.com.wsworks.listcarswswork.ui.screens.ListScreen
import br.com.wsworks.listcarswswork.ui.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            Navigation()

        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("list") { ListScreen(navController) }
        composable(
            "detail/{car}",
            arguments = listOf(navArgument("car"){ NavType.StringType})
        ) { backStackEntry->
            val car = backStackEntry.arguments?.getString("car")
            DetailScreen(navController,car)
        }
    }
}

