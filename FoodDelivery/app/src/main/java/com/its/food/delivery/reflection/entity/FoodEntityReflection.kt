package com.its.food.delivery.util.reflection.entity

import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.util.reflection.createInstanceClass
import com.its.food.delivery.util.reflection.memberPropertiesToMap
import com.its.food.delivery.util.reflection.simpleTransform
import com.its.food.delivery.vo.Food

suspend fun FoodEntity.toFood(): Food{
    val paramMap = this.memberPropertiesToMap()
    // paramMap[NOTES] = notes
    return createInstanceClass(
        paramMap,
        ::Food
    )
}

suspend fun List<FoodEntity>.toFoodList(): List<Food> =
    this.simpleTransform { it.toFood() }
