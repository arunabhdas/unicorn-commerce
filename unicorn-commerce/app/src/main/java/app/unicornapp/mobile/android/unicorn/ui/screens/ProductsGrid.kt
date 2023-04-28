package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unicornapp.mobile.android.unicorn.R

@Composable
fun ProductsGrid() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        repeat(10) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(2) {
                    ProductsGridCell()
                }
            }
        }
    }
}
@Preview
@Composable
fun ProductsGridCell() {
    Card(
        elevation = 16.dp,
        modifier = Modifier.padding(8.dp),
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .requiredSize(180.dp, 180.dp)
                .background(Color.Transparent)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dont_panic_tshirt_1),
                contentDescription = "T-shirt"
            )
            Text(
                text = "Don't Panic T-shirt",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(Color.Transparent)
                    .align(Alignment.TopStart)
            )
            Text(
                text = "$29.99",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.BottomEnd)
            )
        }

    }
}