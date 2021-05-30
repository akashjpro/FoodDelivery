package com.its.food.delivery.ui.food_in_formation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.its.food.delivery.R
import com.its.food.delivery.ui.appContext

class SlideImageViewFood(private var images: List<String>): RecyclerView.Adapter<SlideImageViewFood.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.imageViewItemImageFood)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SlideImageViewFood.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image_food_information,parent,false))
    }

    override fun onBindViewHolder(holder: SlideImageViewFood.Pager2ViewHolder, position: Int) {
        Glide.with(appContext).load(images[position]).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}