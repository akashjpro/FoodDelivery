package com.itsj.food.delivery.ui.foodinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.itsj.food.delivery.R
import kotlinx.android.synthetic.main.activity_food_information.*
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class FoodInformation : AppCompatActivity() {
    private  var imagesList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_information)
        postToList()
        viewpager2FoodInformation.adapter = SlideImageViewFood(imagesList)
        viewpager2FoodInformation.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator:CircleIndicator3 = findViewById<CircleIndicator3>(R.id.CircleIndicator3_Image_Food)
        indicator.setViewPager(viewpager2FoodInformation)
    }
    private fun addToList(image: Int){
        imagesList.add(image)
    }
    private fun postToList(){
        for (i in 1..5){
            addToList(R.drawable.img_image1)
        }
    }

}