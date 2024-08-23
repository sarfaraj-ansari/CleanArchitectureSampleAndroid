package com.example.kotlincleanarchitecture.common

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class Interceptor @Inject constructor(private val sharedPreferences: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Accept", "application/json")
        request.addHeader("Authorization", sharedPreferences.getString("token", "") ?: "")
        return chain.proceed(request.build())
    }
}