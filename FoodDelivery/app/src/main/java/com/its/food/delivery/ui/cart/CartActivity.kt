package com.its.food.delivery.ui.cart

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FoodInCartAdapter
import com.its.food.delivery.databinding.ActivityCartBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.entity.Food
import com.its.food.delivery.provider.WorkoutInstance
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.checkout.CheckoutActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity<ActivityCartBinding, CartViewModel>(), ExampleListFood {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setSupportActionBar(toolbarCart)
        init()
        observe()

        val foodInCartAdapter = FoodInCartAdapter(onItemClick = {
            val intent = Intent(this@CartActivity, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        }, onFavoriteClick = {
            val a = it
            WorkoutInstance.getInstance().setFoodFavorite(a)
        }, this)

        foodInCartAdapter.submitList(exampleLis())

        binding.recyclerviewFoodsInCart.adapter = foodInCartAdapter
        binding.recyclerviewFoodsInCart.layoutManager = LinearLayoutManager(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun observe() {
        viewModel.navigateToCheckOut.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@CartActivity, CheckoutActivity::class.java)
                startActivity(intent)
            }
        }
    }
}