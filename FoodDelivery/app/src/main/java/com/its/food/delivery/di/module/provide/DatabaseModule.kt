package com.its.food.delivery.di.module.provide

import android.content.Context
import androidx.room.Room
import com.its.food.delivery.database.FoodDatabase
import com.its.food.delivery.database.dao.FoodDao
import com.its.food.delivery.di.DatabaseName
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
        @DatabaseName name: String
    ): FoodDatabase =
        Room.databaseBuilder(context, FoodDatabase::class.java, name).build()

    @Provides
    fun provideFoodDao(database: FoodDatabase) : FoodDao = database.foodDao()
}