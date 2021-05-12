package com.its.food.delivery.ui.spicy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Filter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.ActivitySpicyChiecrnsBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.entity.Food
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import com.its.food.delivery.util.SEARCH_KEY
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*
import okhttp3.internal.notify

class SpicyChiActivity : BaseActivity<ActivitySpicyChiecrnsBinding, SpicyChiViewModel>(),
    ExampleListFood {
    val exampleListFood = exampleLis()
    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {


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

        val foodName = intent?.getStringExtra(SEARCH_KEY)
        Log.d("aaaa","Từ truyền sang -- $foodName --")
        for (i in exampleListFood) {
            if (i.foodName.equals(foodName)) {
                foodAdapter.getFilter().filter(foodName.toString())
            }
        }

        //Update list food
        foodAdapter.submitList(exampleListFood)


        binding.recyclerSpicyChiecrns.adapter = foodAdapter
        binding.recyclerSpicyChiecrns.layoutManager = GridLayoutManager(this, 2)
        setSupportActionBar(toolbarResults)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}