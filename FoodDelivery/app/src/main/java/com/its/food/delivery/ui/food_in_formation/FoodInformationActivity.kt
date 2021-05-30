package com.its.food.delivery.ui.food_in_formation

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FavoriteAdapter
import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.databinding.ActivityFoodInformationBinding
import com.its.food.delivery.entity.Food
import com.its.food.delivery.provider.WorkoutInstance
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.cart.CartActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_food_information.*
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class FoodInformationActivity: BaseActivity<ActivityFoodInformationBinding,FoodInformationViewModel>(){
    private var imagesList = mutableListOf<String>()
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
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuItemFavorite -> {
                WorkoutInstance.getInstance().setFoodFavorite(intent?.getBundleExtra(BUNDLE_KEY)?.get(FOOD_ENTITY_KEY)  as Food)
              true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun init() {
        // Process intent data
        viewModel.processIntentData(intent)
    }

    private fun addToList(image: String){
        imagesList.add(image)
    }

    private fun postToList(){
        val food = intent?.getBundleExtra(BUNDLE_KEY)?.get(FOOD_ENTITY_KEY)  as FoodEntity
        for (i in 1..5){
            addToList(food.imgFoodUrl)
        }
        //WorkoutInstance.getInstance().setFoodHistory(food)
    }
}
