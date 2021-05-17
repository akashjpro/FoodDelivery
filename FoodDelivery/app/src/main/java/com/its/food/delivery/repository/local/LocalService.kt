package com.its.food.delivery.repository.local

import com.its.food.delivery.repository.remote.DataResponse
import kotlinx.coroutines.flow.Flow

interface LocalService {

    fun login(): Flow<DataResponse<Boolean>>

}