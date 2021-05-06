package com.its.food.delivery.ui.login_and_sign_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityLoginAndSignupBinding
import com.its.food.delivery.databinding.ActivitySplashBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformation
import com.its.food.delivery.ui.home.Home
import com.its.food.delivery.ui.splash.SplashViewModel

class LoginAndSignUpActivity : BaseActivity<ActivityLoginAndSignupBinding, LoginAndSignUpActivityViewModel>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login_and_signup)

//		// Data binding
//		binding = DataBindingUtil.setContentView(this, R.layout.activity_login_and_signup)
//		binding.lifecycleOwner = this
//		binding.viewModel = this.viewModel
//		init()
//		observe()
	}

	private fun init() {
		lifecycle.addObserver(viewModel)
	}

	private fun observe() {
		viewModel.navigateToMain.observe(this) { event ->
			event.getContentIfNotHandled()?.let {
				val intent = Intent(this@LoginAndSignUpActivity, Home::class.java)
				startActivity(intent)
				finish()
			}

		}

		viewModel.navigateToLogin.observe(this) { event ->
			event.getContentIfNotHandled()?.let {
				val intent = Intent(this@LoginAndSignUpActivity, LoginAndSignUpActivity::class.java)
				startActivity(intent)
				finish()
			}
		}
	}

	fun onClickLogin(view: View) {
		val intent = Intent(this@LoginAndSignUpActivity, Home::class.java)
		startActivity(intent)
		finish()
	}

}