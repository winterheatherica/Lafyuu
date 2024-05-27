package com.projectui.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.projectui.app.adapter.FavoriteAdapter
import com.projectui.app.data.ItemData

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // Back button setup
        val backIcon: ImageView = findViewById(R.id.back_icon)
        backIcon.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Favorite RecyclerView setup
        val favoriteRecyclerView: RecyclerView = findViewById(R.id.favorite_recycler_view)
        favoriteRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val favoriteItems = listOf(
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_1),
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_2),
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_3),
            ItemData("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_4)
        )

        favoriteRecyclerView.adapter = FavoriteAdapter(this, favoriteItems)
    }
}
