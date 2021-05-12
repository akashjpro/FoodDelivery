package com.its.food.delivery.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityCartBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.checkout.CheckoutActivity
import com.its.food.delivery.ui.checkout_payment.CheckOutPaymentActivity
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.ui.orders.OrdersActivity
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity<ActivityCartBinding, CartViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setSupportActionBar(toolbarCart)
        init()
        observe()
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@CartActivity, MainActivity::class.java)
        startActivity(intent)
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