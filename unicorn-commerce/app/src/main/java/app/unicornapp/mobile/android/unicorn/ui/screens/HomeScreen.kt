package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.Approval
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import app.unicornapp.mobile.android.unicorn.ui.navigation.Screen

/**
 * HomeScreen
 */

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary),
        contentAlignment = Alignment.TopStart
    ) {
        /* TODO-FIXME
        Image(painterResource(
            id = R.drawable.banner_bg_6),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        */
        HomeCard(
            navController = navController
        )
    }
}

@Composable
fun HomeCard(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(36.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.HomeDetailScreen.route)
            }.padding(20.dp),
            text = "Unicorn Commerce",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.HomeDetailScreen.route)
            }.padding(20.dp),
            text = "The Custom Apparel Store",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Row() {
            Button(
                onClick = { /* TODO-FIXME */ },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorScheme.tertiary
                ),
                modifier = Modifier.padding(20.dp)
                
            ) {
                Text(
                    text = stringResource(id = R.string.buy)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.height(100.dp)
                .padding(20.dp),

        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController()
    )
}