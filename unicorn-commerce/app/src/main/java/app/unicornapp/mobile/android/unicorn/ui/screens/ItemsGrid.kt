package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Card
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.unicornapp.mobile.android.unicorn.R

/**
 * ItemsGrid
 */

@Composable
fun ItemsGridCell() {
    Card(
        elevation = 16.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredSize(180.dp, 180.dp)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dont_panic_tshirt_1),
                contentDescription = "T-shirt"
            )
        }

    }
}