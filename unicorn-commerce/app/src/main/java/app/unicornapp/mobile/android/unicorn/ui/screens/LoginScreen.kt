package app.unicornapp.mobile.android.unicorn.ui.screens

import android.widget.Toast
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
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
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(36.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.logo),
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

        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.HomeDetailScreen.route)
            },
            text = "The Custom Apparel Platform for Ecommerce",
            color = Color.White,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                  username = it
            },
            label = { Text(text = "Username")},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                androidx.compose.material.Text(
                    text = "Username",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        color = Color.White,
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = Color.White,
                unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                textColor = Color.White,
                cursorColor = Color.White
            ),
            maxLines = 1,
            singleLine = true
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                 password = it
            },
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
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
                unfocusedLabelColor = Color.White,
                unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                textColor = Color.White,
                cursorColor = Color.White
            ),
            maxLines = 1,
            singleLine = true
        )

        Row() {
            Button(
                onClick = {
                    if (username.text == "username" && password.text == "password") {
                        Toast.makeText(context,
                            "Welcome!",
                            Toast.LENGTH_LONG
                        ).show()
                        navController.navigate(route = Screen.HomeScreen.route)
                    } else {
                        Toast.makeText(context,
                            "Invalid",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
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