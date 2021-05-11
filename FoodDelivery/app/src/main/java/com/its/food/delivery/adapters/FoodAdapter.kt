package com.its.food.delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.FoodItemBinding
import com.its.food.delivery.entity.Food

class FoodAdapter(private val onItemClick: (item: Food) -> Unit) :
    ListAdapter<Food, RecyclerView.ViewHolder>(FoodDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(
            FoodItemBinding.inflate(
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
        private val binding: FoodItemBinding,
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

private class FoodDiffCallback : DiffUtil.ItemCallback<Food>() {

    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
