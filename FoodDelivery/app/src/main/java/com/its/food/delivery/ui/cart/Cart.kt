package com.its.food.delivery.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityCartBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.orders.Orders

class Cart : BaseActivity<ActivityCartBinding, CartViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        init()
        observe()
    }
    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun observe() {
        viewModel.navigateToMain.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@Cart, Cart::class.java)
                startActivity(intent)
                finish()
            }

        }

        viewModel.navigateToOrders.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@Cart, Orders::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}