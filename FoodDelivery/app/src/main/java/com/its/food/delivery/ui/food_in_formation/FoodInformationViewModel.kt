package com.its.food.delivery.ui.food_in_formation

import android.content.Intent
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.ui.main.home.Food
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import com.its.food.delivery.util.extensions.valueNotDistinct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class FoodInformationViewModel @Inject constructor() : BaseViewModel() {

    private val _food by lazy { MutableStateFlow<Food?>(null) }
    val food by lazy {
        _food.filterNotNull().asLiveData(viewModelScope.coroutineContext)
    }

    fun processIntentData(intent: Intent?) {
        val food = intent?.getBundleExtra(BUNDLE_KEY)?.get(FOOD_ENTITY_KEY)  as Food
        if (food == null) {
            throw IllegalArgumentException("food must not be null")
        } else {
            this._food.valueNotDistinct(food)
        }
    }
}