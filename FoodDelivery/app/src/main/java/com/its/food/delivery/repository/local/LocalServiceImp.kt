package com.its.food.delivery.repository.local

import com.its.food.delivery.repository.remote.DataResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalServiceImp @Inject constructor() : LocalService {
    override fun login(): Flow<DataResponse<Boolean>> {
        val result = DEFAULT_RESPONSE
        return flow { emit(result) }.distinctUntilChanged()
    }

    companion object {
        private val DEFAULT_RESPONSE = DataResponse<Boolean>(false, null, null)
    }
}