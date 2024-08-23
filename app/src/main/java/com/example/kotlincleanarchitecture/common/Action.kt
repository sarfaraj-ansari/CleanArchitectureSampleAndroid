package com.example.kotlincleanarchitecture.common

sealed interface Action {
    data class Login(val email: String) : Action
    data object Register : Action
    data class ResendOtp(val email: String) : Action
    data class VerifyOtp(val email: String, val otp: String) : Action
}