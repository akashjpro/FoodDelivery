package com.its.food.delivery.di.module.provide

import android.content.Context
import android.content.SharedPreferences
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.its.food.delivery.di.FetchLimitTime
import com.its.food.delivery.di.JSonPrettyPrint
import com.its.food.delivery.di.SharePreferenceFileName
import com.its.food.delivery.util.FetchLimiter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideMapper(@JSonPrettyPrint prettyPrint: Boolean): ObjectMapper {
        val mapper = jacksonObjectMapper()

        if (prettyPrint) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT)
        }
        return mapper
    }

    @Singleton
    @Provides
    fun provideFetchLimiter(@FetchLimitTime minutes: Int): FetchLimiter<String> =
        FetchLimiter(minutes, TimeUnit.MINUTES)

    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context,
        @SharePreferenceFileName filename: String
    ): SharedPreferences = context.getSharedPreferences(filename, Context.MODE_PRIVATE)
}