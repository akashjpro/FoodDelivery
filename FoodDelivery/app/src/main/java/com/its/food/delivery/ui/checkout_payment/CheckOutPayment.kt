package com.its.food.delivery.ui.checkout_payment

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityCheckOutPaymentBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.popup.PaymentPopUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckOutPayment : BaseActivity<ActivityCheckOutPaymentBinding, CheckOutPaymentViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_out_payment)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        init()
        observe()
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun observe() {
        // Payment popup
        viewModel.paymentPopUp.observe(this) { event ->
            event.getContentIfNotHandled()?.takeIf { it }?.let {
                PaymentPopUp().show(this.supportFragmentManager, null)
            }
        }

    }
}