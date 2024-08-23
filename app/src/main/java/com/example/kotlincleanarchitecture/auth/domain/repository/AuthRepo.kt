package com.example.kotlincleanarchitecture.auth.domain.repository

import com.example.kotlincleanarchitecture.common.NetworkResult
import com.example.kotlincleanarchitecture.auth.data.remote.dto.RequestBodyOtp
import com.example.kotlincleanarchitecture.auth.domain.model.OtpResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun login(requestBodyOtp: RequestBodyOtp): Flow<NetworkResult<OtpResponseModel>>
}