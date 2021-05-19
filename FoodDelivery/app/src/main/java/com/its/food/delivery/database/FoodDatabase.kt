package com.its.food.delivery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.its.food.delivery.database.dao.FoodDao
import com.its.food.delivery.database.entity.FoodEntity

@Database(entities = [FoodEntity::class], version = 1)

abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}