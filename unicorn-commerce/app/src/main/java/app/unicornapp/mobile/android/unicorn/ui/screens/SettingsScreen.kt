package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import app.unicornapp.mobile.android.unicorn.ui.navigation.Screen
import app.unicornapp.mobile.android.unicorn.ui.theme.UnicornApppColor

/**
 * SettingsScreen
 */
@Composable
fun SettingsScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(
                id = R.drawable.banner_bg_6),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 20.dp
            )
        ) {
            Text(
                text = "Settings",
                color = Color.White,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(
                    id = R.drawable.logo),
                contentDescription = "Logo Image"
            )
            Button(
                onClick = { /* TODO */},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = UnicornApppColor.three
                )
            ) {
                Text(
                    text = "Change Password",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Light
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = UnicornApppColor.three
                )
            ) {
                Text(
                    text = "Logout",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Light
                )
            }
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.HomeScreen.route) {
                            inclusive = true
                        }
                    }
                },
                text = "Back to Home",
                color = Color.White,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = FontWeight.Bold
            )
            AnimateLogo()
        }

    }

}


@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        navController = rememberNavController()
    )
}