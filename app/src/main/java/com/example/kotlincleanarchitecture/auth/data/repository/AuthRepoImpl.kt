package com.example.kotlincleanarchitecture.auth.data.repository

import com.example.kotlincleanarchitecture.common.NetworkResult
import com.example.kotlincleanarchitecture.common.helper.dtoToModel
import com.example.kotlincleanarchitecture.common.ApiCallHandler
import com.example.kotlincleanarchitecture.auth.data.remote.ApiService
import com.example.kotlincleanarchitecture.auth.data.remote.dto.RequestBodyOtp
import com.example.kotlincleanarchitecture.auth.data.remote.dto.toOtpModel
import com.example.kotlincleanarchitecture.auth.domain.model.OtpResponseModel
import com.example.kotlincleanarchitecture.auth.domain.repository.AuthRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val apiService: ApiService) : AuthRepo,
    ApiCallHandler {
    override suspend fun login(requestBodyOtp: RequestBodyOtp): Flow<NetworkResult<OtpResponseModel>> =
        flow {
            emit(NetworkResult.Loading)
            val result = handleApiCall(apiCall = { apiService.login(requestBodyOtp) })
            dtoToModel(
                data = result,
                success = { otpData -> emit(NetworkResult.Success(otpData.toOtpModel())) },
                failure = { message, errorCode -> emit(NetworkResult.Failure(message, errorCode)) }
            )
        }
}