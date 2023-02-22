package app.unicornapp.mobile.android.unicorn.ui.navigation

/**
 * Created by Das on 2022-11-05.
 */
sealed class Screen(val route: String) {
    object LoginScreen: Screen(route = "login_screen")
    object HomeScreen: Screen(route = "home_screen")
    object BrowseScreen: Screen(route = "browse_screen")
    object NotificationScreen: Screen(route = "notification_screen")
    object HomeDetailScreen: Screen(route = "home_detail_screen")
}
