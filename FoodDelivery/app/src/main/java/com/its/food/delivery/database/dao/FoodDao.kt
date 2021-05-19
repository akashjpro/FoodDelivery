package com.its.food.delivery.database.dao

import androidx.room.*
import com.its.food.delivery.database.entity.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertFood(vararg food: FoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertFoods(foods: List<FoodEntity>)

    @Update
    abstract suspend fun updateFood(vararg food: FoodEntity)

    @Update
    abstract suspend fun updateFoods(foods: List<FoodEntity>)

    @Delete
    abstract fun deleteFood(vararg food: FoodEntity)

    @Delete
    abstract suspend fun deleteFoods(foods: List<FoodEntity>)

    @Query("DELETE FROM FOOD")
    abstract suspend fun deleteAllFoods()

    @Query("SELECT * FROM FOOD")
    abstract fun getFoods(): Flow<List<FoodEntity>>

    @Query("SELECT * FROM FOOD WHERE foodId = :foodId")
    abstract fun getFoodsOfId(foodId: String): Flow<List<FoodEntity>>

    @Transaction
    open suspend fun replaceAllFoods(foods: List<FoodEntity>) {
        deleteAllFoods()
        insertFoods(foods)
    }

}