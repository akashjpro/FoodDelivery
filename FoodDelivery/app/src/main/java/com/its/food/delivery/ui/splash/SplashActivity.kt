package com.its.food.delivery.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivitySplashBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.home.Home
import com.its.food.delivery.ui.login_and_sign_up.LoginAndSignUpActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
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
                val intent = Intent(this@SplashActivity, Home::class.java)
                startActivity(intent)
                finish()
            }

        }

        viewModel.navigateToLogin.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this@SplashActivity, LoginAndSignUpActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}