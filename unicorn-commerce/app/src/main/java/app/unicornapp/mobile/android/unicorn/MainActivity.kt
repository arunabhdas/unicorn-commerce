package app.unicornapp.mobile.android.unicorn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.ui.bottomnav.Destinations
import app.unicornapp.mobile.android.unicorn.ui.bottomnav.Home
import app.unicornapp.mobile.android.unicorn.ui.bottomnav.MenuList
import app.unicornapp.mobile.android.unicorn.ui.bottomnav.Settings
import app.unicornapp.mobile.android.unicorn.ui.navigation.MenuItem
import app.unicornapp.mobile.android.unicorn.ui.navigation.CustomAppBar
import app.unicornapp.mobile.android.unicorn.ui.navigation.DrawerBody
import app.unicornapp.mobile.android.unicorn.ui.navigation.SetupNavGraph
import app.unicornapp.mobile.android.unicorn.ui.screens.HomeScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.MenuListScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.SettingsScreen
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
                // Uncomment below and MyApp lines to use drawer navigation
                navController = rememberNavController()
                MyApp(navController)
                // TODO-FIXME-BOTTOMNAV
                // Uncomment MyBottomNavApp to get bottomnav navigation
                // MyBottomNavApp(navController as NavHostController)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

@Composable
fun MyBottomNavApp(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = { MyBottomNavigation(navController = navController)},
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Home.route
                ) {
                composable(MenuList.route) {
                    MenuListScreen(navController = navController, id="789", name = "MenuList")
                }
                composable(Home.route) {
                    HomeScreen(navController = navController)
                }

                composable(Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(
    navController: NavController
) {
    val destinationList = listOf<Destinations> (
        MenuList,
        Home,
        Settings
    )

    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.tertiary_contrast),
        contentColor = colorResource(id = R.color.white)
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        destinationList.forEachIndexed{index, destination ->
            val currentRoute = backStackEntry.value?.destination?.route
            val selected = currentRoute ==  destination.route
            BottomNavigationItem(
                label = { Text(
                            text = destination.title,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Light,
                            color = Color.White
                         )
                        },
                icon = { Icon(
                    imageVector = destination.icon,
                    contentDescription = destination.title,
                    tint = if (selected) Color.White else Color.Black
                )},
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }
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
                        id = "collections",
                        title = "Collections",
                        route = "collections_screen",
                        contentDescription = "Navigate to Collections",
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
