package com.its.food.delivery.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.ItemHistoryBinding
import com.its.food.delivery.entity.Food

class HistoryAdapter(
    private val onItemClick: (item: Food) -> Unit
) :
    ListAdapter<Food, RecyclerView.ViewHolder>(FoodDiffCallback3()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClick
        )
    }

    @SuppressLint("LogNotTimber")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val food = getItem(position)
        Log.d("AAAA","$food")
        (holder as FoodViewHolder).bind(food)
    }

    @SuppressLint("LogNotTimber")
    class FoodViewHolder(
        private val binding: ItemHistoryBinding,
        private val onItemClick: (item: Food) -> Unit,
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

private class FoodDiffCallback3 : DiffUtil.ItemCallback<Food>() {

    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
