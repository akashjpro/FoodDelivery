package com.its.food.delivery.di.module.provide

import com.its.food.delivery.BuildConfig
import com.its.food.delivery.di.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ConfigModule {

    // -------------------------------------- APP CONFIG -------------------------------------------

    @DatabaseName
    @Provides
    fun provideDatabaseName(): String = "FoodDeliveryDatabase"

    @SharePreferenceFileName
    @Provides
    fun provideSharePreferenceFileName(): String = "FoodDelivery"

    @JSonPrettyPrint
    @Provides
    fun provideJSonPrettyPrint(): Boolean = BuildConfig.DEBUG

    // ------------------------------------ RETROFIT CONFIG ----------------------------------------

    @BaseURL
    @Provides
    fun provideBaseURL(): String = BuildConfig.URL_BASE

    // ------------------------------------ REFRESH TIME CONFIG ------------------------------------

    @FetchLimitTime
    @Provides
    fun provideFetchLimitTime(): Int = Int.MAX_VALUE

    // ------------------------------------ COROUTINE CONFIG ---------------------------------------

    @CPUDispatcher
    @Provides
    fun provideCPUDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IODispatcher
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideAppCoroutineScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default + CoroutineName("AppCoroutine"))

}