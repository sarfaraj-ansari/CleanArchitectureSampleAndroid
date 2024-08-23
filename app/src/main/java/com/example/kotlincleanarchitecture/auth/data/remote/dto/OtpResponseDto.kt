package com.example.kotlincleanarchitecture.auth.data.remote.dto

import com.example.kotlincleanarchitecture.auth.domain.model.OtpResponseModel
import com.google.gson.annotations.SerializedName

data class OtpResponseDto(
    val `data`: Data,
    val message: String,
    val status: Boolean
) {
    data class Data(
        val email: String,
        val otp: Int
    )
}

fun OtpResponseDto.toOtpModel(): OtpResponseModel {
    return OtpResponseModel(message = this.message)
}

data class RequestBodyOtp(
    @SerializedName("email") val email: String,
    @SerializedName("for") val for_customer: String = "2",
    @SerializedName("role") val role: Int = 1
)