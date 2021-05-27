package com.its.food.delivery.provider

import android.annotation.SuppressLint
import android.util.Log
import com.its.food.delivery.entity.Food

class WorkoutInstance {

    private var mList: List<Food> = ArrayList()
    private var exampleListHistory = ArrayList<Food>()
    private var exampleListFavorite = ArrayList<Food>()


    companion object {
        private var INSTANCE: WorkoutInstance? = null

        fun getInstance(): WorkoutInstance {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                val instance = WorkoutInstance()
                INSTANCE = instance
                instance
            }
        }
    }

    fun getFoods(): List<Food> {
        return mList
    }

    fun setFoods(list: List<Food>) {
        mList = list
    }

    //History
    @SuppressLint("LogNotTimber")
    fun setFoodHistory(food: Food) {
        exampleListHistory.add(food)
        Log.d("AAAA","Add food vào list History thành công | Size== ${exampleListHistory.size}")
    }

    @SuppressLint("LogNotTimber")
    fun getListHistory(): List<Food> {
        Log.d("AAAA","===== Lấy List History =========")
        return exampleListHistory
    }

    //Favorite
    @SuppressLint("LogNotTimber")
    fun setFoodFavorite(food: Food) {
        exampleListFavorite.add(food)
        Log.d("AAAA","Add Food ${food.foodName} vào List Favorite thành công  | Size == ${exampleListFavorite.size}")
    }

    @SuppressLint("LogNotTimber")
    fun getListFavorite(): List<Food> {
        Log.d("AAAA","===== Lấy List Favorite =========")
        return exampleListFavorite
    }


}