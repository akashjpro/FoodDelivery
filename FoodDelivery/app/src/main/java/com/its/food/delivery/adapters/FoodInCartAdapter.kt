package com.its.food.delivery.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.ItemFoodInCartBinding
import com.its.food.delivery.entity.Food
import com.its.food.delivery.ui.appContext
import com.its.food.delivery.ui.cart.CartActivity

class FoodInCartAdapter(
    private val onItemClick: (item: Food) -> Unit,
    private val context: Context
) :
    ListAdapter<Food, RecyclerView.ViewHolder>(FoodDiffCallback1()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(
            ItemFoodInCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClick, context
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val food = getItem(position)
        (holder as FoodViewHolder).bind(food)
    }

    @SuppressLint("LogNotTimber")
    class FoodViewHolder(
        private val binding: ItemFoodInCartBinding,
        private val onItemClick: (item: Food) -> Unit,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.food?.let { food ->
                    onItemClick(food)
                }
            }
            binding.btnFavorite.setOnClickListener {
                Toast.makeText(this.context, "${binding.food?.foodName} Button Favorite is Click", Toast.LENGTH_SHORT).show()
                Log.d("aaaa", "Button favorite is click")
            }
            binding.btnDelete.setOnClickListener {
                Toast.makeText(this.context, "${binding.food?.foodName} Button Delete is Click", Toast.LENGTH_SHORT).show()
                Log.d("aaaa", "Button favorite is click")
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
