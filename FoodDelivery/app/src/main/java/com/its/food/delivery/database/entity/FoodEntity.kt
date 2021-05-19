package com.its.food.delivery.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Food")
data class FoodEntity (
    @PrimaryKey
    val foodId: String,
    var foodName: String,
    var foodPrice: String,
    var imgFoodUrl: String,
    var typeOfFood: String,
    var foodInformation: String
): Serializable