package com.example.kotlincleanarchitecture.auth.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincleanarchitecture.common.Action
import com.example.kotlincleanarchitecture.common.NetworkResult
import com.example.kotlincleanarchitecture.auth.data.remote.dto.RequestBodyOtp
import com.example.kotlincleanarchitecture.auth.data.repository.AuthRepoImpl
import com.example.kotlincleanarchitecture.auth.domain.model.OtpResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepoImpl) : ViewModel() {

    private val _otp = MutableLiveData<NetworkResult<OtpResponseModel>>()
    val otpResponse: LiveData<NetworkResult<OtpResponseModel>> = _otp

    fun onAction(action: Action) {
        when (action) {
            is Action.Login -> {
                viewModelScope.launch {
                    repository.login(RequestBodyOtp(email = action.email)).collectLatest { data ->
                        _otp.postValue(data)
                    }
                }
            }

            Action.Register -> {

            }

            is Action.ResendOtp -> {

            }

            is Action.VerifyOtp -> {

            }
        }
    }
}