package com.projectui.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import com.projectui.app.adapter.RelatedProductsAdapter
import com.projectui.app.data.ItemData

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Retrieve product details from intent
        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getStringExtra("product_price")
        val productImage = intent.getIntExtra("product_image", 0)

        // Set product details
        val productNameTextView: TextView = findViewById(R.id.product_name)
        val productPriceTextView: TextView = findViewById(R.id.product_price)
        val productImageView: ImageView = findViewById(R.id.product_image)

        productNameTextView.text = productName
        productPriceTextView.text = productPrice
        productImageView.setImageResource(productImage)

        // Back button setup
        val backIcon: ImageView = findViewById(R.id.back_icon)
        backIcon.setOnClickListener {
            finish()
        }

        // Related products RecyclerView setup
        val relatedProductsRecyclerView: RecyclerView = findViewById(R.id.related_products_recyclerview)
        relatedProductsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val relatedProducts = listOf(
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_1),
            ItemData("FS - QUILTED MAXI CROSS", "$299.43", R.drawable.img_productimage_2),
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_3)
        )

        relatedProductsRecyclerView.adapter = RelatedProductsAdapter(relatedProducts)

        // Add to Cart button setup
        val addToCartButton: Button = findViewById(R.id.add_to_cart_button)
        addToCartButton.setOnClickListener {
            // Handle add to cart logic
        }
    }
}
