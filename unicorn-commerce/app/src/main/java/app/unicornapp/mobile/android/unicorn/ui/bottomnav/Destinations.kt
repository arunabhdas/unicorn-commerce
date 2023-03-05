package app.unicornapp.mobile.android.unicorn.ui.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Destinations
 */
interface Destinations {
    val route: String
    val icon: ImageVector
    val title: String
}

object MenuList : Destinations {
    override val route = "MenuList"
    override val icon = Icons.Default.Menu
    override val title = "Menu"
}


object Home: Destinations {
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}

object Settings: Destinations {
    override val route = "Settings"
    override val icon = Icons.Filled.Settings
    override val title = "Settings"
}