package com.its.food.delivery.repository.local

import android.util.Log
import com.its.food.delivery.database.dao.FoodDao
import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.repository.remote.DataResponse
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocalServiceImp @Inject constructor(private val foodDao: FoodDao) : LocalService {
    override fun login(): Flow<DataResponse<Boolean>> {
        val result = DEFAULT_RESPONSE
        return flow { emit(result) }.distinctUntilChanged()
    }

    override fun getFoods(): Flow<DataResponse<List<FoodEntity>>> =
        foodDao.getFoods().flatMapLatest {
            flow { emit(DataResponse(true, it))}.distinctUntilChanged()
        }

    override suspend fun replaceAllFoods(foods: List<FoodEntity>) {
        foodDao.replaceAllFoods(foods)
    }


    companion object {
        private val DEFAULT_RESPONSE = DataResponse<Boolean>(false, null, null)
    }
}