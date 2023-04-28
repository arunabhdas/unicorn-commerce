package app.unicornapp.mobile.android.unicornappbeta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import androidx.navigation.compose.composable
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.BrowseScreen
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.HomeScreen
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.HomeDetailScreen
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.LoginScreen
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.MenuListScreen
import app.unicornapp.mobile.android.unicornappbeta.ui.screens.NotificationScreen
import timber.log.Timber

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
            route = Screen.MenuListScreen.route,
            arguments = listOf(
                navArgument(MENU_LIST_SCREEN_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(MENU_LIST_SCREEN_ARGUMENT_KEY_2) {
                    type = NavType.StringType
                }
            )
        ) {
            Timber.tag("TAG").d("value passed" + it.arguments?.getInt(MENU_LIST_SCREEN_ARGUMENT_KEY).toString())
            Timber.tag("TAG").d("value passed" + it.arguments?.getString(MENU_LIST_SCREEN_ARGUMENT_KEY_2).toString())
            MenuListScreen(
                navController = navController,
                id = it.arguments?.getInt(MENU_LIST_SCREEN_ARGUMENT_KEY).toString(),
                name = it.arguments?.getString(MENU_LIST_SCREEN_ARGUMENT_KEY_2).toString()
            )
        }
    }
}