package com.its.food.delivery.ui.login_and_sign_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.its.food.delivery.R
import com.its.food.delivery.ui.food_in_formation.FoodInformation

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