package app.unicornapp.mobile.android.unicorn.data

import app.unicornapp.mobile.android.unicorn.R

/**
 * Product.kt
 */
data class Product (
    val name: String,
    val price: String,
    val description: String,
    val image: Int
)

val products = listOf<Product>(
    Product("Don't Panic", "$29.99", "Don't Panic Tshirt", R.drawable.tshirt_1),
    Product("Got Milky Way", "$39.99", "Got Milky Way Tshirt", R.drawable.tshirt_2),
    Product("Starry Nights", "$49.99", "Starry Nights Tshirt", R.drawable.tshirt_3),

)