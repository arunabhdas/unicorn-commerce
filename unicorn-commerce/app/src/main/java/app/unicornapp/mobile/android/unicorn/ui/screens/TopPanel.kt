package app.unicornapp.mobile.android.unicorn.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import app.unicornapp.mobile.android.unicorn.ui.navigation.Screen

/**
 * UpperPanel
 */
@Composable
fun TopPanel(
    navController: NavController
) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.HomeDetailScreen.route)
                }
                .padding(20.dp),
            text = "Unicorn Commerce",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.HomeDetailScreen.route)
                }
                .padding(20.dp),
            text = "The Custom Apparel Store",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.Start) {
            Text(
                text = stringResource(id = R.string.description_one),
                Modifier.width(200.dp),
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
            Image(
                painter = painterResource(id = R.drawable.dont_panic_tshirt_1),
                contentDescription = "",
                Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
        }

        Row() {
            Button(
                onClick = {
                          Toast.makeText(context, "Order Confirmed", Toast.LENGTH_SHORT).show()
                },
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

    }
}

@Preview
@Composable
fun TopPanenlPreview() {
    TopPanel(
        navController = rememberNavController()
    )
}