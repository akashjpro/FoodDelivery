package com.its.food.delivery.provider

import com.its.food.delivery.ui.main.home.Food

class WorkoutInstance {

    private var mList: List<Food> = ArrayList()

    companion object {
        private var mInstance: WorkoutInstance? = null

        fun getInstance(): WorkoutInstance {
            if (mInstance == null) {
                mInstance = WorkoutInstance()
            }
            return mInstance!!
        }
    }

    fun getFoods(): List<Food> {
        return mList
    }

    fun setFoods(list: List<Food>) {
        mList = list
    }
}