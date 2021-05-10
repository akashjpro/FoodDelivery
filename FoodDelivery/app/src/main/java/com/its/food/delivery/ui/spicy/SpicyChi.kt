package com.its.food.delivery.ui.spicy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.ui.ExampleListFood
import com.its.food.delivery.ui.OnItemClickListener
import com.its.food.delivery.ui.main.home.AdapterFoodItem
import com.its.food.delivery.ui.main.home.Food
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*

class SpicyChi : AppCompatActivity(), ExampleListFood, OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        val exampleListFood = exampleLis()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spicy_chiecrns)
        val adapterFood = AdapterFoodItem(exampleListFood, this)
        recycler_Spicy_Chiecrns.adapter = adapterFood
        recycler_Spicy_Chiecrns.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}