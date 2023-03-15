package app.unicornapp.mobile.android.unicorn.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import app.unicornapp.mobile.android.unicorn.R

/**
 * AnimateLogo
 */

@Composable
fun AnimateLogo() {
    var alfaImg by remember {
        mutableStateOf(0f)
    }
    val animateAlfaImg by animateFloatAsState(
        targetValue = alfaImg,
        animationSpec = tween(
            durationMillis = 4000
        )
    )
    Box(
        modifier = Modifier
            .clickable {
                alfaImg += 1f
            }
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.logo_background),
            contentDescription = "Logo Background",
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(
                id = R.drawable.shoppingbag),
            contentDescription = "Shopping Bag",
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(alpha = animateAlfaImg)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun AnimateLogoPreview() {
    AnimateLogo()
}