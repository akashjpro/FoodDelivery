package com.its.food.delivery.ui.no_offers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.its.food.delivery.R
import kotlinx.android.synthetic.main.activity_no_offers.*

class NoOffersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_offers)
        setSupportActionBar(toolbarNoOffers)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}