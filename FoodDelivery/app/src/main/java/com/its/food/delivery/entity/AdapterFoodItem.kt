package com.its.food.delivery.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.R
import kotlinx.android.synthetic.main.food_item.view.*

class AdapterFoodItem(
    private var listitemFood: List<Food>,
    private val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<AdapterFoodItem.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.imgItemFood
        val tvName: TextView = itemView.tvItemFoodName
        val tvPrice: TextView = itemView.tvPrice

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentItem = listitemFood[position]
        holder.imageView.setImageResource(currentItem.imgFood)
        holder.tvName.text = currentItem.foodName
        holder.tvPrice.text = currentItem.foodPrice

    }

    override fun getItemCount() = listitemFood.size

}


