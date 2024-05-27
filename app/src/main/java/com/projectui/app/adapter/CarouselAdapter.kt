package com.projectui.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectui.app.R

class CarouselAdapter(private val itemList: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val flashSaleTitle: TextView = view.findViewById(R.id.flash_sale_title)
        val countdownContainer: LinearLayout = view.findViewById(R.id.countdown_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Assuming all items are the same for now
        holder.imageView.setImageResource(R.drawable.img_productimage_1)
    }

    override fun getItemCount() = itemList.size
}
