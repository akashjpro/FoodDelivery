package com.its.food.delivery.ui.main.home

import java.io.Serializable

data class Food(
    var foodName: String,
    var foodPrice: String,
    var imgFood: Int,
    var typeOfFood: String,
    var foodInformation: String
): Serializable
