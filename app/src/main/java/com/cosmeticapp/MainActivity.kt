package com.cosmeticapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cosmeticapp.ui.theme.CosmeticAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CosmeticAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Products(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class Product(val title: String, val description: String, val price: Float, val image: String)

@Composable
fun Products(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ProductItem()
        ProductItem()
        ProductItem()
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product = Product("item1", "desc1", 9.9f, image = "")
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .padding(all = 8.dp)
                .sizeIn(maxHeight = 80.dp)
                .aspectRatio(12f / 9f),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        ProductTextContent(product)
    }

}

@Composable
private fun ProductTextContent(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Text(
            text = product.title,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = product.description,
            modifier = Modifier.padding(vertical = 8.dp),
            maxLines = 2
        )
        Text(
            text = product.price.toString().plus("$"),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun ProductsPreview() {
    Products()
}
