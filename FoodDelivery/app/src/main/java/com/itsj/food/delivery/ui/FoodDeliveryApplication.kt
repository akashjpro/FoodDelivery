package com.itsj.food.delivery.ui

import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class FoodDeliveryApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        appContext = this
    }

    companion object {
        lateinit var appContext: Context
    }
}

val appContext = FoodDeliveryApplication.appContext


