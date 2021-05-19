package com.its.food.delivery.repository.remote

import com.its.food.delivery.util.api.APIResponse
import com.its.food.delivery.vo.Food
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface RemoteService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Flow<APIResponse<DataResponse<LoginDataResponse>>>

    @GET("getFoods")
    fun getFoods(@HeaderMap headers: Map<String, String>): Flow<APIResponse<DataResponse<List<Food>>>>
}