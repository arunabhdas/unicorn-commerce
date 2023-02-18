package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import app.unicornapp.mobile.android.unicorn.ui.navigation.Screen

/**
 * LoginScreen
 */
@Composable
fun LoginScreen(
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
        LoginCard(
            navController = navController
        )
    }
}

@Composable
fun LoginCard(
    navController: NavController
) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(36.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_adaptive_fore),
            contentDescription = "Logo Image"
        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.HomeDetailScreen.route)
            },
            text = "Login to Unicorn Commerce",
            color = Color.White,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = text,
            onValueChange = {
                  text = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                androidx.compose.material.Text(
                    text = "Username",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = MaterialTheme.colorScheme.inversePrimary,
                textColor = Color.White
            ),
            maxLines = 1,
            singleLine = true
        )

        OutlinedTextField(
            value = "",
            onValueChange = {
                 text = it
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                androidx.compose.material.Text(
                    text = "Password",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = MaterialTheme.colorScheme.inversePrimary,
                textColor = Color.White
            ),
            maxLines = 1,
            singleLine = true
        )

        Row() {
            Button(
                onClick = { /* TODO-FIXME */ },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF495E57)
                )

            ) {
                Text(
                    text = stringResource(id = R.string.login)
                )
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}