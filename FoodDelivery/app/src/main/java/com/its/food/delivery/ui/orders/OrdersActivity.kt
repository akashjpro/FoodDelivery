package com.its.food.delivery.ui.orders

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityOrdersBinding
import com.its.food.delivery.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_orders.*

class OrdersActivity : BaseActivity<ActivityOrdersBinding,OrdersViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_orders)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setSupportActionBar(toolbarOrder)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}