package com.its.food.delivery.delivery_interface

import com.its.food.delivery.R
import com.its.food.delivery.entity.Food
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import java.util.*
import kotlin.collections.ArrayList

interface ExampleListFood {

    fun exampleLis(): List<Food> {
        val exampleListFood = generateList(10)
        return exampleListFood
    }

    fun generateList(size: Int): List<Food> {
        val list = ArrayList<Food>()
        for (i in 0 until size) {
            val item = Food(
                "1",
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

    fun filterFoodType(type: String?): ArrayList<Food> {
        var list = ArrayList<Food>()
        for (food in exampleLis()) {
            if (food.typeOfFood == type) {
                list.add(food)
            }
        }
        return list
    }

}