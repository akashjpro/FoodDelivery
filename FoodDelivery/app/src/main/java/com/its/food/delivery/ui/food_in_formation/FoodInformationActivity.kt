package com.its.food.delivery.ui.food_in_formation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityFoodInformationBinding
import com.its.food.delivery.entity.Food
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_food_information.*
import me.relex.circleindicator.CircleIndicator3

class FoodInformationActivity: BaseActivity<ActivityFoodInformationBinding,FoodInformationViewModel>(){
    private  var imagesList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_food_information)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        init()

        postToList()

        binding.viewpager2FoodInformation.adapter = SlideImageViewFood(imagesList)
        binding.viewpager2FoodInformation.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator: CircleIndicator3 = findViewById<CircleIndicator3>(R.id.CircleIndicator3_Image_Food)
        indicator.setViewPager(viewpager2FoodInformation)
        setSupportActionBar(toolbarFoodInformation)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun init() {
        // Process intent data
        viewModel.processIntentData(intent)
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
