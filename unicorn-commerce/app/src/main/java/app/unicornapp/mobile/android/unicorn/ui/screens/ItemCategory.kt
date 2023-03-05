package app.unicornapp.mobile.android.unicorn.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * ItemCategory
 */
@Composable
fun ItemCategory (category: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(
                context,
                "ItemCategory Button",
                Toast.LENGTH_SHORT
            ).show()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF495E57),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
    ) {
        Text(
            text = category
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCategoryPreview() {
    ItemCategory(category = "Category")
}

val Categories = listOf<String>(
    "Python",
    "Java",
    "C++",
    "Kotlin"
)