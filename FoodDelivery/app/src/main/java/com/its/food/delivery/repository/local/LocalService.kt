package com.its.food.delivery.repository.local

import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.repository.remote.DataResponse
import kotlinx.coroutines.flow.Flow

interface LocalService {

    fun login(): Flow<DataResponse<Boolean>>

    fun getFoods(): Flow<DataResponse<List<FoodEntity>>>

    suspend fun replaceAllFoods(foods: List<FoodEntity>)
}