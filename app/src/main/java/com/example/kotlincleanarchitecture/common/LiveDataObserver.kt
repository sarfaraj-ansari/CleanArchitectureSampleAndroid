package com.example.kotlincleanarchitecture.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface LiveDataObserver {

    fun <T> LifecycleOwner.observeLiveData(
        liveData: LiveData<NetworkResult<T>>,
        onLoading: () -> Unit,
        onSuccess: (T) -> Unit,
        onError: (message: String?, errorCode: Int?) -> Unit
    ) {
        liveData.observe(this, Observer { result ->
            when (result) {
                is NetworkResult.Loading -> onLoading()
                is NetworkResult.Success -> onSuccess(result.data)
                is NetworkResult.Failure -> onError(result.message, result.errorCode)
            }
        })
    }

}