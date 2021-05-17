package com.its.food.delivery.util.api

import com.its.food.delivery.util.ErrorCode
import com.its.food.delivery.util.tryCatchLogSuspendNullable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
inline fun <REMOTE, LOCAL> networkBoundResource (
    crossinline fetchFromRemote: () -> Flow<APIResponse<REMOTE>>,
    crossinline remoteResponse:  suspend (response: REMOTE?) -> Flow<LOCAL>
) = flow {

    // Emit loading state without data
    emit(Resource.loading(null))

    when (val fetchResult = tryCatchLogSuspendNullable(null) { fetchFromRemote().first() }) {


        is APIResponse.Success -> {
            emitAll(remoteResponse(fetchResult.body).map { Resource.success(it) })
        }

        is APIResponse.HttpError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.HTTP_ERROR)  })
        }

        is APIResponse.UnauthorizedError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.UNAUTHORIZED)  })
        }

        is APIResponse.ForbiddenError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.FORBIDDEN)  })
        }

        is APIResponse.NetWorkError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.CONNECT_ERROR)  })
        }

        is APIResponse.GenericError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.UNKNOWN_ERROR) })
        }

        is APIResponse.CombineHttpError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.HTTP_ERROR) })
        }

        is APIResponse.CombineNetworkError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.CONNECT_ERROR) })
        }

        is APIResponse.CombineError -> {
            emitAll(remoteResponse(fetchResult.combineResponse).map { Resource.error(it, ErrorCode.UNKNOWN_ERROR) })
        }

        else -> {
            emitAll(remoteResponse(null).map { Resource.error(it, ErrorCode.UNKNOWN_ERROR) })
        }
    }
}
