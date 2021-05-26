package com.its.food.delivery.provider

import com.its.food.delivery.entity.Food

class WorkoutInstance {

    private var mList: List<Food> = ArrayList()
    private var exampleListHistory = ArrayList<Food>()
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
    fun setFoodHistory(food: Food){
        exampleListHistory.add(food)
    }
    fun getListHistory():List<Food>{
        return exampleListHistory
    }

}