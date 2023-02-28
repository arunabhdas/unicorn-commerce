package app.unicornapp.mobile.android.unicorn.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.unicornapp.mobile.android.unicorn.ui.screens.BrowseScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.HomeScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.HomeDetailScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.LoginScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.MenuListScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.NotificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.HomeDetailScreen.route
        ) {
            HomeDetailScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.BrowseScreen.route
        ) {
            BrowseScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.MenuListScreen.route
        ) {
            MenuListScreen(
                navController = navController
            )
        }
    }
}