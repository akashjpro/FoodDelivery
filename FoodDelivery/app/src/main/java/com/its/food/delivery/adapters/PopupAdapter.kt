package com.its.food.delivery.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.its.food.delivery.databinding.ItemPopupBinding
import com.its.food.delivery.entity.Popup


class PopupAdapter :
    ListAdapter<Popup, RecyclerView.ViewHolder>(FoodDiffCallback2()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PopupViewHolder(
            ItemPopupBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val popup = getItem(position)
        (holder as PopupViewHolder).bind(popup)
    }

    @SuppressLint("LogNotTimber")
    class PopupViewHolder(
        private val binding: ItemPopupBinding,
//        private val onItemClick: (item: Food) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.setClickListener {
//                binding.food?.let { food ->
//                    onItemClick(food)
//                }
//            }
//        }

        fun bind(item: Popup) {
            binding.apply {
                popup = item
                executePendingBindings()
            }
        }
    }
}

private class FoodDiffCallback2 : DiffUtil.ItemCallback<Popup>() {

    override fun areItemsTheSame(oldItem: Popup, newItem: Popup): Boolean {
        return oldItem.foodId == newItem.foodId
    }

    override fun areContentsTheSame(oldItem: Popup, newItem: Popup): Boolean {
        return oldItem == newItem
    }
}
