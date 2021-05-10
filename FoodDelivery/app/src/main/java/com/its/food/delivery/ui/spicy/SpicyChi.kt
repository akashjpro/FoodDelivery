package com.its.food.delivery.ui.spicy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.entity.AdapterFoodItem
import com.its.food.delivery.entity.Food
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*

class SpicyChi : AppCompatActivity(), ExampleListFood {

    override fun onCreate(savedInstanceState: Bundle?) {

        val exampleListFood = exampleLis()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spicy_chiecrns)
        val adapterFood = AdapterFoodItem(exampleListFood,  onItemClick = {
            val foodItemClick: Food = exampleLis()[it]
            val intent = Intent(this, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, foodItemClick)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })
        recycler_Spicy_Chiecrns.adapter = adapterFood
        recycler_Spicy_Chiecrns.layoutManager = GridLayoutManager(this, 2)
    }
}