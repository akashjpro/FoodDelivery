package com.its.food.delivery.repository

import com.its.food.delivery.di.IODispatcher
import com.its.food.delivery.repository.local.LocalService
import com.its.food.delivery.repository.remote.DataResponse
import com.its.food.delivery.repository.remote.LoginDataResponse
import com.its.food.delivery.repository.remote.LoginRequest
import com.its.food.delivery.repository.remote.RemoteService
import com.its.food.delivery.util.FetchLimiter
import com.its.food.delivery.util.api.networkBoundResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow
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
}