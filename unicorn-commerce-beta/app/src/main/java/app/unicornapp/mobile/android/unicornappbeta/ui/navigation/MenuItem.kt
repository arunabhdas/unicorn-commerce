package app.unicornapp.mobile.android.unicornappbeta.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * MenuItem for NavigtationDrawer
*/
data class MenuItem(
    val id: String,
    val title: String,
    val route: String,
    val contentDescription: String,
    val icon: ImageVector
)
