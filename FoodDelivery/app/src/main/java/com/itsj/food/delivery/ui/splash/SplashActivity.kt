package com.itsj.food.delivery.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itsj.food.delivery.R
import com.itsj.food.delivery.ui.loginandsignup.LoginAndSignupActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

		GlobalScope.launch(context = Dispatchers.Main) {
			val intent = Intent(this@SplashActivity, LoginAndSignupActivity::class.java)
			startActivity(intent)
			finish()
		}

	}



}