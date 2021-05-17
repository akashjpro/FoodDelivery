package com.its.food.delivery.di.module.provide

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.its.food.delivery.di.module.FetchLimitTime
import com.its.food.delivery.di.module.JSonPrettyPrint
import com.its.food.delivery.util.FetchLimiter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}