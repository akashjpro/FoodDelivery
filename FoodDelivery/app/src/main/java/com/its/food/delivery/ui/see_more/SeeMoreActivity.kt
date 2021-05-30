package com.its.food.delivery.ui.see_more

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.ActivitySeeMoreBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import com.its.food.delivery.util.TEXT_TAB
import kotlinx.android.synthetic.main.activity_results.*
import kotlinx.android.synthetic.main.activity_see_more.*

class SeeMoreActivity : BaseActivity<ActivitySeeMoreBinding, SeeMoreViewModel>(), ExampleListFood {

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_see_more)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })
        val foodType: String? = intent?.getStringExtra(TEXT_TAB)
        Log.d("AAAA", "$foodType")
        toolbarSeeMore.title = foodType + "s"
        val list = filterFoodType(foodType)

        //Update list food
        //foodAdapter.submitList(list)

        binding.recyclerSeeMore.adapter = foodAdapter
        binding.recyclerSeeMore.layoutManager = GridLayoutManager(this, 2)

        setSupportActionBar(toolbarSeeMore)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}