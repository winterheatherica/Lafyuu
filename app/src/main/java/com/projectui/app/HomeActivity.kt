package com.projectui.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.projectui.app.adapter.CarouselAdapter
import com.projectui.app.adapter.CategoryAdapter
import com.projectui.app.adapter.GridAdapter
import com.projectui.app.adapter.HorizontalAdapter
import com.projectui.app.data.CategoryData
import com.projectui.app.data.ItemData
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fav = findViewById<ImageView>(R.id.favorite_icon)
        fav.setOnClickListener {
            val favorite = Intent(this, FavoriteActivity::class.java)
            startActivity(favorite)
        }

        // Bottom Navigation setup
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle home navigation
                    true
                }
                R.id.navigation_explore -> {
                    // Handle explore navigation
                    true
                }
                R.id.navigation_cart -> {
                    // Handle cart navigation
                    true
                }
                R.id.navigation_offer -> {
                    // Handle offer navigation
                    true
                }
                R.id.navigation_account -> {
                    // Handle account navigation
                    true
                }
                else -> false
            }
        }

        // Carousel setup
        val carouselViewPager: ViewPager2 = findViewById(R.id.carousel_view_pager)
        val carouselItems = listOf(1, 2, 3)  // Dummy data to create 3 identical items
        carouselViewPager.adapter = CarouselAdapter(carouselItems)

        // Category RecyclerView
        val categoryRecyclerView: RecyclerView = findViewById(R.id.category_recycler_view)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val categories = listOf(
            CategoryData("Man Shirt", R.drawable.img_arrowdown_light_blue_a200),
            CategoryData("Dress", R.drawable.img_dressicon),
            CategoryData("Man Work Equipment", R.drawable.img_bag),
            CategoryData("Woman Bag", R.drawable.img_thumbsup),
            CategoryData("Man Shoes", R.drawable.img_arrowright),
            CategoryData("High Heels", R.drawable.img_vector)
        )

        categoryRecyclerView.adapter = CategoryAdapter(categories)

        // Flash Sale RecyclerView
        val flashSaleRecyclerView: RecyclerView = findViewById(R.id.flash_sale_recycler_view)
        flashSaleRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val flashSaleItems = listOf(
            ItemData("FS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_1),
            ItemData("FS - QUILTED MAXI CROSS", "$299.43", R.drawable.img_productimage_2),
            ItemData("FS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_3)
        )

        flashSaleRecyclerView.adapter = HorizontalAdapter(flashSaleItems)

        // Navigate to Flash Sale Activity on "See More" click
        val seeMoreFlashSale: TextView = findViewById(R.id.see_more_flash_sale)
        seeMoreFlashSale.setOnClickListener {
            val intent = Intent(this, FlashSaleActivity::class.java)
            startActivity(intent)
        }

        // Mega Sale RecyclerView
        val megaSaleRecyclerView: RecyclerView = findViewById(R.id.mega_sale_recycler_view)
        megaSaleRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val megaSaleItems = listOf(
            ItemData("MS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_4),
            ItemData("MS - QUILTED MAXI CROSS", "$299.43", R.drawable.img_productimage_5),
            ItemData("MS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_6)
        )

        megaSaleRecyclerView.adapter = HorizontalAdapter(megaSaleItems)

        // Recommended Product RecyclerView
        val recommendedRecyclerView: RecyclerView = findViewById(R.id.recommended_recycler_view)
        recommendedRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        val recommendedItems = listOf(
            ItemData("Nike Air Max 270", "$299.43", R.drawable.img_productimage_1),
            ItemData("Nike Air Max 270", "$299.43", R.drawable.img_productimage_2),
            ItemData("Nike Air Max 270", "$299.43", R.drawable.img_productimage_3)
        )

        recommendedRecyclerView.adapter = GridAdapter(recommendedItems)
    }
}