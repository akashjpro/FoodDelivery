package com.its.food.delivery.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityCartBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.orders.OrdersActivity

class CartActivity : BaseActivity<ActivityCartBinding, CartViewModel>() {
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
                val intent = Intent(this@CartActivity, CartActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        viewModel.navigateToOrders.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@CartActivity, OrdersActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}