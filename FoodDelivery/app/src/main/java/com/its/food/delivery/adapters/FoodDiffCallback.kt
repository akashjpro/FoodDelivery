package com.its.food.delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.ItemFoodInCartBinding
import com.its.food.delivery.entity.Food

class FoodInCartAdapter(private val onItemClick: (item: Food) -> Unit) :
    ListAdapter<Food, RecyclerView.ViewHolder>(FoodDiffCallback1()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(
            ItemFoodInCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val food = getItem(position)
        (holder as FoodViewHolder).bind(food)
    }

    class FoodViewHolder(
        private val binding: ItemFoodInCartBinding,
        private val onItemClick: (item: Food) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.food?.let { food ->
                    onItemClick(food)
                }
            }
        }

        fun bind(item: Food) {
            binding.apply {
                food = item
                executePendingBindings()
            }
        }
    }
}

private class FoodDiffCallback1 : DiffUtil.ItemCallback<Food>() {

    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
