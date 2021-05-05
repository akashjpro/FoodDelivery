package com.its.food.delivery.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.its.food.delivery.R
import com.its.food.delivery.ui.cart.Cart

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.btnCart -> {
                val intent1 = Intent(this@Home, Cart::class.java)
                startActivity(intent1)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


//    fun onClickHome(view: View) {
//        val intent2 = Intent(this@Home, Home::class.java)
//        startActivity(intent2)
//        finish()
//    }
//    fun onClickAccount(view: View) {
//        val intent3 = Intent(this@Home, MyProfile::class.java)
//        startActivity(intent3)
//        finish()
//    }
}