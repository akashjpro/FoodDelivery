package com.its.food.delivery.ui.login_and_sign_up

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityLoginAndSignupBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.util.EMPLOYEE
import com.its.food.delivery.util.api.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginAndSignUpActivity :
    BaseActivity<ActivityLoginAndSignupBinding, LoginAndSignUpActivityViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_and_signup)
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
                val intent = Intent(this@LoginAndSignUpActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        viewModel.loginEvent.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                // TODO: 5/17/21  
                processLogin("user1@gmail.com", "123456")
            }

        }
    }

    private fun processLogin(userName: String, password: String) {
        viewModel.login(userName, password).observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    Timber.d("Loading data: ${resource.cachedData?.toString()}")
                }
                is Resource.Error -> {
                    Timber.d("Error: ${resource.cachedData?.toString()} with code: ${resource.code}")

                }

                is Resource.Success -> {

                    val result = resource.data.result

                    Timber.d("result: ${resource.data.toString()}")

                    if (result) {
                        val role = resource.data?.data?.role ?: EMPLOYEE
                        val userId = resource.data?.data?.userId ?: ""
                        val token = resource.data?.data?.token ?: ""

                    } else {
                        // Show error dialog
                    }
                }
            }
        }
    }
}