package com.its.food.delivery.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("bindingImageResource")
fun bindingImageResource(view: ImageView, icon: Int) {
    view.setImageResource(icon)
}