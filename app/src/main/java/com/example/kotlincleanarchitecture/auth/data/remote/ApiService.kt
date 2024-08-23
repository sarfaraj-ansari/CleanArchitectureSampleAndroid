package com.example.kotlincleanarchitecture.auth.data.remote

import com.example.kotlincleanarchitecture.app.Constants
import com.example.kotlincleanarchitecture.auth.data.remote.dto.RequestBodyOtp
import com.example.kotlincleanarchitecture.auth.data.remote.dto.OtpResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.api_otp)
    suspend fun login(@Body reqBody: RequestBodyOtp): Response<OtpResponseDto>
}