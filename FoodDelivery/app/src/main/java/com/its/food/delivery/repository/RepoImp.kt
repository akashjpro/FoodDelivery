package com.its.food.delivery.repository

import com.its.food.delivery.database.entity.FoodEntity
import com.its.food.delivery.di.IODispatcher
import com.its.food.delivery.repository.local.LocalService
import com.its.food.delivery.repository.remote.DataResponse
import com.its.food.delivery.repository.remote.LoginDataResponse
import com.its.food.delivery.repository.remote.LoginRequest
import com.its.food.delivery.repository.remote.RemoteService
import com.its.food.delivery.util.FetchLimiter
import com.its.food.delivery.util.GET_FOODS
import com.its.food.delivery.util.api.Resource
import com.its.food.delivery.util.api.networkBoundResource
import com.its.food.delivery.util.reflection.vo.toFoodList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepoImp @Inject constructor(
    private val remoteService: RemoteService,
    private val localService: LocalService,
    private val appScope: CoroutineScope,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher,
    private val fetchLimiter: FetchLimiter<String>,
) : Repo {

    private var headerRequest = mapOf<String, String>()

    override fun setHeaderRequest(headers: Map<String, String>) {
        headerRequest = headers
    }

    override fun login(
        username: String,
        password: String,
        force: Boolean
    ) = networkBoundResource(fetchFromRemote = {
        remoteService.login(
            LoginRequest(
                username,
                password
            )
        )
    }, remoteResponse = {
        val dataResponse = it ?: DataResponse(false, LoginDataResponse())
        flow {
            emit(dataResponse)
        }
    })

    override fun getFoods(force: Boolean): Flow<Resource<DataResponse<List<FoodEntity>>>>  =
        networkBoundResource(
            fetchFromLocal = { localService.getFoods() },
            shouldFetchFromRemote = { result ->
                val list = result?.data ?: ArrayList()
                force || list == null || list.isEmpty() || fetchLimiter.shouldFetch(GET_FOODS)
            },
            fetchFromRemote = { remoteService.getFoods(headerRequest) },
            processRemoteResponse = {},
            saveRemoteData = { response ->
                // Save response data in app scope
                appScope.launch {
                    val listFood = response.body?.data ?: ArrayList()
                   localService.replaceAllFoods(listFood.toFoodList())
                }.join()
            },
            onFetchFailed = {
                fetchLimiter.reset(GET_FOODS)
            }
        ).flowOn(dispatcher).conflate()
}