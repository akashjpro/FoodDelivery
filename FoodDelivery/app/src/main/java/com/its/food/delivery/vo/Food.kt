package com.its.food.delivery.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class Food(
    @JsonProperty("food_id")
    val foodId: String,
    @JsonProperty("food_name")
    var foodName: String,
    @JsonProperty("food_price")
    var foodPrice: String,
    @JsonProperty("img_food_url")
    var imgFoodUrl: String,
    @JsonProperty("type_of_food")
    var typeOfFood: String,
    @JsonProperty("food_information")
    var foodInformation: String
)