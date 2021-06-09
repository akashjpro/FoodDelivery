package com.its.food.delivery.repository

import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.repository.remote.DataResponse
import com.its.food.delivery.repository.remote.LoginDataResponse
import com.its.food.delivery.util.api.Resource
import com.its.food.delivery.vo.Albums
import kotlinx.coroutines.flow.Flow

interface Repo {

    // SETUP HEADER ------------------------------------------------------------------------------------

    fun setHeaderRequest(headers: Map<String, String>)

    // EMPLOYEE ------------------------------------------------------------------------------------

    fun login(
        username: String,
        password: String,
        force: Boolean = false
    ): Flow<Resource<DataResponse<LoginDataResponse>>>

    fun getFoods(force: Boolean = false): Flow<Resource<DataResponse<List<FoodEntity>>>>

    fun getAlbums(force: Boolean = false): Flow<Resource<List<Albums>>>

}