package com.its.food.delivery.repository.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequest(
    @JsonProperty("username")
    val userName: String,
    @JsonProperty("password")
    val password: String
)