package com.its.food.delivery.ui.my_profile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.FtsOptions
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityMyProfileEditBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.ui.orders.OrdersActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MyProfileEditActivity : BaseActivity<ActivityMyProfileEditBinding, MyProfileEditViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_profile_edit)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel


        init()
//        observe()
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

//    private fun observe() {
//        viewModel.navigateToOrders.observe(this) { event ->
//            event.getContentIfNotHandled()?.let {
//                val intent = Intent(this@MyProfileEditActivity, OrdersActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//
//        }
//    }
}