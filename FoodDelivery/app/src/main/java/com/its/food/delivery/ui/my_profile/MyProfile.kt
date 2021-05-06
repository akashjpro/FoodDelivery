package com.its.food.delivery.ui.my_profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.its.food.delivery.R
import com.its.food.delivery.ui.home.Home
import com.its.food.delivery.ui.my_profile2.MyProfile2
import kotlinx.android.synthetic.main.activity_myprofile.*


class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myprofile)

    }

    fun onClickEditProfile(view: View) {
        val intent = Intent(this@MyProfile, MyProfile2::class.java)
        startActivity(intent)
        finish()
    }
}