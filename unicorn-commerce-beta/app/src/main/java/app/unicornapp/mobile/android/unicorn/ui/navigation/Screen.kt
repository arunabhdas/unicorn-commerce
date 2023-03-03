package app.unicornapp.mobile.android.unicorn.ui.navigation

/**
 * Screen
 */

const val MENU_LIST_SCREEN_ARGUMENT_KEY = "id"
const val MENU_LIST_SCREEN_ARGUMENT_KEY_2 = "name"

sealed class Screen(val route: String) {
    object LoginScreen: Screen(route = "login_screen")
    object HomeScreen: Screen(route = "home_screen")
    object BrowseScreen: Screen(route = "browse_screen")
    object NotificationScreen: Screen(route = "notification_screen")
    object HomeDetailScreen: Screen(route = "home_detail_screen")
    object MenuListScreen: Screen(route = "menu_list_screen/{$MENU_LIST_SCREEN_ARGUMENT_KEY}/{$MENU_LIST_SCREEN_ARGUMENT_KEY_2}") {

        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{$MENU_LIST_SCREEN_ARGUMENT_KEY}", newValue = id.toString())
        }

        fun passIdAndName(
            id: Int,
            name: String
        ): String {
            return "menu_list_screen/$id/$name"
        }
    }
}
