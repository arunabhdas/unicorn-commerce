package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import app.unicornapp.mobile.android.unicorn.ui.theme.UnicornApppColor

/**
 * BottomPanel
 */
@Composable
fun BottomPanel(
    navController: NavController
) {
    Column {
        SpringCollection()
        FallCollection()
    }
}


@Composable
fun SpringCollection(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp)
    ) {
        Text(
            text = "On Sale Items",
            color = UnicornApppColor.five,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}


@Composable
fun FallCollection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp)
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(UnicornApppColor.five)
                .padding(15.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.tshirt),
                    color = UnicornApppColor.graphene,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.size_medium),
                    color = UnicornApppColor.one,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = stringResource(id = R.string.price),
                    color = UnicornApppColor.one,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = R.drawable.dont_panic_tshirt_1),
                contentDescription = "",
                Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
        }
    }
    Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = UnicornApppColor.one,
        thickness = 1.dp
    )
}

@Preview(showBackground = true)
@Composable
fun BottomPanelPreview(){
    BottomPanel(navController = rememberNavController())
}
