package com.its.food.delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.FoodItemBinding
import com.its.food.delivery.entity.Food
import java.util.*
import kotlin.collections.ArrayList

class FoodAdapter(private val onItemClick: (item: Food) -> Unit) :
    ListAdapter<Food, RecyclerView.ViewHolder>(FoodDiffCallback()) {
    //    var foodListFilterde = ArrayList<Food>()
    override fun getItemCount(): Int {
        return super.getItemCount()
    }

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

    fun getFilter(onCount: (count: Int) -> Unit): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val foodList = ArrayList<Food>()
                if (charSearch.isEmpty()) {
                } else {

                    for (item in currentList) {
                        if (item.foodName.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            foodList.add(item)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = foodList
//                filterResults.count
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                submitList(
                    results?.values as ArrayList<Food>
                )
                val exampleList : ArrayList<Food> = results?.values as ArrayList<Food>
                onCount(exampleList.count())
                notifyDataSetChanged()
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
