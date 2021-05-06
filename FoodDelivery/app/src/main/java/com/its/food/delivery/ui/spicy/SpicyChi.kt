package com.its.food.delivery.ui.spicy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.ui.main.home.AdapterFoodItem
import com.its.food.delivery.ui.main.home.Food
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*

class SpicyChi : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        var listFood: List<Food>
        listFood = mutableListOf(
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spicy_chiecrns)
        val adapterFood = AdapterFoodItem(listFood)
        recycler_Spicy_Chiecrns.adapter = adapterFood
        recycler_Spicy_Chiecrns.layoutManager = GridLayoutManager(this,2)
    }
}