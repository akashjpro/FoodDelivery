package com.itsj.food.delivery.ui.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.itsj.food.delivery.R
import com.itsj.food.delivery.ui.foodinformation.FoodInformation
import com.itsj.food.delivery.ui.home.Home

class LoginAndSignUpActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login_and_signup)
	}

	fun onClickLogin(view: View) {
		val intent = Intent(this@LoginAndSignUpActivity, FoodInformation::class.java)
		startActivity(intent)
		finish()
	}
}