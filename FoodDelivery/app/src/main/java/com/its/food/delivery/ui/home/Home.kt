package com.its.food.delivery.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityHomeBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.ListFood
import com.its.food.delivery.ui.cart.Cart
import com.its.food.delivery.ui.history.History
import com.its.food.delivery.ui.my_profile.MyProfile
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login_and_signup.*
import kotlinx.android.synthetic.main.activity_login_and_signup.view.*


class Home : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        var listFood: List<Food>
        listFood = mutableListOf(
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Drink",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
            Food(
                "Veggie tomato mix1",
                "19000",
                R.drawable.img_image,
                "Food",
                "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            ),
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("AAAA", "Run Here")
        val adapterFood = AdapterFoodItem(listFood)
        recyclerviewFoods.adapter = adapterFood


//        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
//        binding.lifecycleOwner = m
//        binding.viewModel = this.viewModel
//        init()
//        observe()
    }

//    private fun init() {
//        lifecycle.addObserver(viewModel)
//    }
//
//    private fun observe() {
//        viewModel.navigateToMain.observe(this) { event ->
//            event.getContentIfNotHandled()?.let {
//                val intent = Intent(this@Home, Home::class.java)
//                startActivity(intent)
//                finish()
//            }
//
//        }
//
//        viewModel.navigateToNoInternet.observe(this) { event ->
//            event.getContentIfNotHandled()?.let {
//                val intent = Intent(this@Home, NoInternet::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//    }

    @SuppressLint("LogNotTimber")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
        Log.d("AAAA", "Run Here 1")
        return true
    }

    @SuppressLint("LogNotTimber")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnCart -> {
                Log.d("AAAA", "Run Here Button Cart")
                val intent1 = Intent(this@Home, Cart::class.java)
                startActivity(intent1)
                finish()
                true
            }
            R.id.navigation_account -> {
                val intent1 = Intent(this@Home, MyProfile::class.java)
                startActivity(intent1)
                finish()
                true
            }
            R.id.navigation_history -> {
                val intent1 = Intent(this@Home, History::class.java)
                startActivity(intent1)
                finish()
                true
            }
            R.id.navigation_home -> {
                val intent1 = Intent(this@Home, Home::class.java)
                startActivity(intent1)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}