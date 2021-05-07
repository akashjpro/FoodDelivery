package com.its.food.delivery.ui.orders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityOrdersBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.*

class OrdersActivity : BaseActivity<ActivityOrdersBinding,OrdersViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_orders)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
    }
}