package app.unicornapp.mobile.android.unicorn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.ui.navigation.MenuItem
import app.unicornapp.mobile.android.unicorn.ui.navigation.CustomAppBar
import app.unicornapp.mobile.android.unicorn.ui.navigation.DrawerBody
import app.unicornapp.mobile.android.unicorn.ui.navigation.SetupNavGraph
import app.unicornapp.mobile.android.unicorn.ui.screens.TopAppBar
import app.unicornapp.mobile.android.unicorn.ui.theme.UnicornTheme
import app.unicornapp.mobile.android.unicorn.viewmodel.UnicornViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var navController: NavController
    private val viewModel: UnicornViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            UnicornTheme {
                navController = rememberNavController()
                MyApp(navController)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

@Composable
fun MyApp(
    navController: NavController,
    titles: List<String> = listOf("Unicorn")
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        route = "home_screen",
                        contentDescription = "Navigate to Home",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "browse",
                        title = "Browse",
                        route = "browse_screen",
                        contentDescription = "Navigate to Browse",
                        icon = Icons.Default.Email
                    ),
                    MenuItem(
                        id = "notifications",
                        title = "Notifications",
                        route = "notification_screen",
                        contentDescription = "Navigate to Notifications",
                        icon = Icons.Default.Notifications
                    )
                ),
                onItemClick = {menuItem ->
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    println("Clicked on ${menuItem.title}")
                    navController.navigate(route = menuItem.route)
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {

            SetupNavGraph(navController = navController as NavHostController)
            CustomAppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        }
    }
}

@Composable
fun WelcomeScreen(titles: List<String> = listOf("Unicorn", "App")) {

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column {
            for (title in titles) {
                Greeting(title)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Welcome to $name!",

                )
            Text(
                text = "Welcome to $name!",
            )
        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    UnicornTheme {
        MyApp(
            navController = rememberNavController(),
            listOf("One", "Two", "Three")
        )
    }
}
