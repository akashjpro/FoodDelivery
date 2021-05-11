package com.its.food.delivery.ui.spicy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.ActivitySpicyChiecrnsBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*

class SpicyChiActivity : BaseActivity<ActivitySpicyChiecrnsBinding, SpicyChiViewModel>(),
    ExampleListFood {

    override fun onCreate(savedInstanceState: Bundle?) {

        val exampleListFood = exampleLis()
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_spicy_chiecrns)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })

        binding.recyclerSpicyChiecrns.adapter = foodAdapter
        binding.recyclerSpicyChiecrns.layoutManager = GridLayoutManager(this, 2)

        //Update list food
        foodAdapter.submitList(exampleListFood)
    }
}