package com.its.food.delivery.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.R
import kotlinx.android.synthetic.main.food_item.view.*

class AdapterFoodItem(
    var itemFood: List<Food>
) : RecyclerView.Adapter<AdapterFoodItem.FoodItemViewHolder>() {
    inner class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        holder.itemView.apply {
            tvItemFoodName.text = itemFood[position].foodName
            tvPrice.text= itemFood[position].foodPrice.toString()
            imgItemFood.setImageResource(itemFood[position].imgFood)
        }
    }

    override fun getItemCount(): Int {
        return itemFood.size
    }

}