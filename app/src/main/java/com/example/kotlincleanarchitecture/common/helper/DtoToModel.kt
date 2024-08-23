package com.example.kotlincleanarchitecture.common.helper

import com.example.kotlincleanarchitecture.common.NetworkResult

suspend fun <T> dtoToModel(
    data: NetworkResult<T>,
    success: suspend (T) -> Unit,
    failure: suspend (message: String?, errorCode: Int?) -> Unit
) {
    when(data) {
        is NetworkResult.Success -> { success.invoke(data.data) }
        is NetworkResult.Failure -> { failure.invoke(data.message, data.errorCode) }
        else -> {}
    }
}