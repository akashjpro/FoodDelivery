package com.its.food.delivery.ui.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityCheckOutPaymentBinding
import com.its.food.delivery.databinding.ActivityCheckoutBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.checkout_payment.CheckOutPaymentActivity
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.ui.my_profile2.MyProfileEditActivity
import com.its.food.delivery.ui.popup.PaymentPopUp

class CheckoutActivity : BaseActivity<ActivityCheckoutBinding,CheckOutViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        init()
        observe()
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun observe() {

        viewModel.navigateToCheckOutPayment.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@CheckoutActivity, CheckOutPaymentActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}