package com.its.food.delivery.ui.food_in_formation

import android.content.Intent
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.entity.Food
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import com.its.food.delivery.util.extensions.valueNotDistinct
import com.its.food.delivery.util.livedata.SingleEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodInformationViewModel @Inject constructor() : BaseViewModel() {

    private val _food by lazy { MutableStateFlow<FoodEntity?>(null) }
    val food by lazy {
        _food.filterNotNull().asLiveData(viewModelScope.coroutineContext)
    }
//    private  var imagesList = mutableListOf<Int>()

    fun processIntentData(intent: Intent?) {
        val food = intent?.getBundleExtra(BUNDLE_KEY)?.get(FOOD_ENTITY_KEY)  as FoodEntity
        if (food == null) {
            throw IllegalArgumentException("food must not be null")
        } else {
            this._food.valueNotDistinct(food)
        }
//        for (i in 1..5){
//            imagesList.add(food.imgFood)
//        }
    }

}