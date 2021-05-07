package com.its.food.delivery.ui.no_internet

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityNoInternetBinding
import com.its.food.delivery.ui.BaseActivity

class NoInternetActivity : BaseActivity<ActivityNoInternetBinding,NoInternetViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_no_internet)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
    }
}