package com.its.food.delivery.ui

import com.its.food.delivery.R
import com.its.food.delivery.ui.main.home.Food

interface ExampleListFood {

    fun exampleLis(): List<Food> {
        val exampleListFood = generateList(10)
        return exampleListFood
    }
    fun generateList(size: Int):List<Food>{
        val list = ArrayList<Food>()
        for (i in 0 until size){
//            val drawable = R.drawable.img_image
            val item = Food(
                "Veggie mix $i",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            )
            list += item
        }
        return list
    }
}