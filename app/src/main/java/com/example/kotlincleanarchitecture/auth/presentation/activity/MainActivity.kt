package com.example.kotlincleanarchitecture.auth.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.auth.presentation.viewModel.AuthViewModel
import com.example.kotlincleanarchitecture.common.Action
import com.example.kotlincleanarchitecture.common.LiveDataObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LiveDataObserver {
    private lateinit var button: Button
    private val viewModel by viewModels<AuthViewModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.login)

        button.setOnClickListener {
            viewModel.onAction(Action.Login(email = "testing@yopmail.com"))
        }

        observeLiveData(
            liveData = viewModel.otpResponse,
            onLoading = {
                println("data-----> Loading")
            },
            onSuccess = { data ->
                println("data-----> $data")
            },
            onError = { message, errorCode ->
                println("data-----> message $message  code $errorCode")
            }
        )
    }
}