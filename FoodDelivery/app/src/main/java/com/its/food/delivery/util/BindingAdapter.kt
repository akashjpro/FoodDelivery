package com.its.food.delivery.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.its.food.delivery.R
import com.its.food.delivery.ui.appContext

@BindingAdapter("bindingImageResource")
fun bindingImageResource(view: ImageView, icon: Int) {
    view.setImageResource(icon)
}
