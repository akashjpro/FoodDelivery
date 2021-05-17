package com.its.food.delivery.repository.remote

import com.its.food.delivery.util.api.APIResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteService {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Flow<APIResponse<DataResponse<LoginDataResponse>>>
}