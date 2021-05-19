package com.its.food.delivery.util.reflection.vo

import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.util.reflection.createInstanceClass
import com.its.food.delivery.util.reflection.memberPropertiesToMap
import com.its.food.delivery.util.reflection.simpleTransform
import com.its.food.delivery.vo.Food

suspend fun Food.toFoodEntity(): FoodEntity =
    createInstanceClass(
        this.memberPropertiesToMap(),
        ::FoodEntity
    )

suspend fun List<Food>.toFoodList(): List<FoodEntity> =
    this.simpleTransform { it.toFoodEntity() }