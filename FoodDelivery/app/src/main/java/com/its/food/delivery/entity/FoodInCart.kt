package com.its.food.delivery.entity

import java.io.Serializable

data class FoodInCart(
    val foodId: String,
    var foodName: String,
    var foodPrice: String,
    var imgFood: Int,
    var typeOfFood: String,
    var foodInformation: String
): Serializable