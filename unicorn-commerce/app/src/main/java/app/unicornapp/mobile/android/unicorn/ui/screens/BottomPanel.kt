package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.unicornapp.mobile.android.unicorn.R

/**
 * BottomPanel
 */
@Composable
fun BottomPanel() {
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
            .padding(15.dp)
            .clickable{ }
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.buy)
            )
            Text(
                text = stringResource(id = R.string.buy)
            )
        }
    }
}


@Composable
fun FallCollection() {
    // to be defined
}

@Preview(showBackground = true)
@Composable
fun BottomPanelPreview(){
    BottomPanel()
}
