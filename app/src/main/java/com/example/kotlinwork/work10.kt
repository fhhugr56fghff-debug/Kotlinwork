package com.example.kotlinwork



import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }

    Column(modifier = Modifier.padding(16.dp)) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection(
            onAdd = {
                val newProducts = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(1, 100)
                )
                products = newProducts

                if (newProducts.sumOf { it.price } > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        )

        RemoveProductSection(
            visible = products.isNotEmpty(),
            onRemove = { products = products.dropLast(1) }
        )
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(visible: Boolean, onRemove: () -> Unit) {
    if (visible) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}