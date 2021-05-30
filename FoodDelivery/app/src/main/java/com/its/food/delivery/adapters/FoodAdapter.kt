package com.its.food.delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.databinding.ItemFoodBinding
import com.its.food.delivery.entity.Food
import java.util.*
import kotlin.collections.ArrayList

class FoodAdapter(private val onItemClick: (item: FoodEntity) -> Unit) :
    ListAdapter<FoodEntity, RecyclerView.ViewHolder>(FoodDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(
            ItemFoodBinding.inflate(
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
        private val binding: ItemFoodBinding,
        private val onItemClick: (item: FoodEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.food?.let { food ->
                    onItemClick(food)
                }
            }
        }

        fun bind(item: FoodEntity) {
            binding.apply {
                food = item
                executePendingBindings()
            }
        }
    }

    fun getFilter(onCount: (count: Int) -> Unit): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val foodList = ArrayList<FoodEntity>()
                if (charSearch.isEmpty()) {
                } else {
                    for (item in currentList) {
                        if (item.foodName.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT)) || item.typeOfFood.toLowerCase(
                                Locale.ROOT
                            )
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            foodList.add(item)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = foodList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                submitList(
                    results?.values as ArrayList<FoodEntity>
                )
                val exampleList: ArrayList<Food> = results.values as ArrayList<Food>
                onCount(exampleList.count())
                notifyDataSetChanged()
            }
        }
    }
}

private class FoodDiffCallback : DiffUtil.ItemCallback<FoodEntity>() {

    override fun areItemsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: FoodEntity, newItem: FoodEntity): Boolean {
        return oldItem == newItem
    }
}
