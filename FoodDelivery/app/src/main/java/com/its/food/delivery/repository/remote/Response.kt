package com.its.food.delivery.repository.remote

import com.fasterxml.jackson.annotation.JsonProperty
import com.its.food.delivery.util.EMPLOYEE

data class DataResponse<T> (
    @JsonProperty("result")
    val result: Boolean,
    @JsonProperty("data")
    val data: T?,
    @JsonProperty("error")
    val error: String? = null
)

data class LoginDataResponse(
    @JsonProperty("token")
    val token: String = "",
    @JsonProperty("role")
    val role: String = EMPLOYEE,
    @JsonProperty("user_code")
    val userId: String = ""
)
